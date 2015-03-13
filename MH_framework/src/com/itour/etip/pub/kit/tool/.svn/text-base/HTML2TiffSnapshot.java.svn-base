package com.itour.etip.pub.kit.tool;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.StringTokenizer;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.SeekableOutputStream;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.codec.TIFFField;

/**
 * HTML2JPG,HTML页面转图片的实现方法。
 * 
 * @author Leo
 * 
 */
public class HTML2TiffSnapshot {
	private static final int DEFAULT_HEIGHT = 2200; // altura

	private static final int DEFAULT_WIDTH = 1728; // largura
	static {
		System.setProperty("com.sun.media.jai.disableMediaLib", "true");
	}

	/**
	 * 创建tif图片，
	 * 
	 * @param html
	 *            html文本
	 * @param fileName
	 *            文件名
	 */
	public static String createTiff(String htmlTable, String style, String fileName) {
		JFrame toolFrame = new JFrame();
		// System.out.println("html:"+html);
		// 此处html不完整，需要补充成为一个完整html
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
		html.append("<HTML>");
		html.append("<HEAD>");
		html.append("<TITLE>传真文件</TITLE>");
		html.append("</HEAD>");
		html.append("<BODY align='center' width=" + DEFAULT_WIDTH + " height=" + DEFAULT_HEIGHT + ">");
		html.append(htmlTable);
		html.append("</BODY>");
		html.append("</HTML>");
		// System.out.println(html.toString());
		/**
		 * 利用html生成图片，因为不能直接生成tif格式，选择生成png格式。
		 */
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setContentType("text/html;charset=UTF-8");

		HTMLEditorKit kit = new HTMLEditorKit();
		editorPane.setEditorKit(kit);
		StyleSheet styleSheet = kit.getStyleSheet();
		// 以下根据导入的参数设置样式
		if (style != null && style.trim().length() > 0) {
			StringTokenizer tokens = new StringTokenizer(style, ".");
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				if (token != null && token.trim().length() > 0) {
					styleSheet.addRule("."+token);
					//System.out.println("addRule:" + token);
				}
			}
		}

		editorPane.setText(html.toString());
		// System.out.println(editorPane.getText());

		// editorPane.setSize(3000,3000);
		JScrollPane jsp = new JScrollPane(editorPane);
		toolFrame.getContentPane().add(jsp);
		toolFrame.setLocation(0, 0);
		toolFrame.pack();
		BufferedImage in = new BufferedImage(DEFAULT_WIDTH, DEFAULT_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = in.createGraphics();
		editorPane.paint(graphics2D);

		RenderedImage output = JAI.create("invert", in);

		RenderedImage source = HTML2TiffSnapshot.scaleToPix(output, DEFAULT_WIDTH, DEFAULT_HEIGHT);

		ParameterBlock pb = new ParameterBlock();
		pb.addSource(source);
		pb.add(0f);
		pb.add((float) (0));
		pb.add((float) output.getWidth());
		pb.add((float) output.getHeight());
		PlanarImage image = JAI.create("crop", pb, null);

		if (image.getNumBands() == 3) {
			double[][] matrix = { { 0.114, 0.587, 0.299, 0 } };
			ParameterBlock pb1 = new ParameterBlock();
			pb1.addSource(image);
			pb1.add(matrix);
			image = JAI.create("bandcombine", pb1, null);
		}

		// Binarize the image.
		RenderedImage out = JAI.create("binarize", image, new Double(1));

		SeekableOutputStream os = null;
		File fileOutput = new File(fileName);
		// System.out.println(fileOutput.getAbsolutePath());
		try {
			os = new SeekableOutputStream(new RandomAccessFile(fileOutput, "rw"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		TIFFEncodeParam param = new TIFFEncodeParam();

		ImageEncoder enc = ImageCodec.createImageEncoder("tiff", os, param);
		param.setCompression(TIFFEncodeParam.COMPRESSION_GROUP3_2D);
		param.setWriteTiled(false);
		param.setTileSize(-1, DEFAULT_HEIGHT);
		param.setLittleEndian(true);
		param.setReverseFillOrder(true);
		param.setT4Encode2D(false);
		param.setT4PadEOLs(true);
		TIFFField[] dialogicTags;
		dialogicTags = new TIFFField[9];
		dialogicTags[0] = new TIFFField(254, TIFFField.TIFF_LONG, 1, (Object) new long[] { (long) 2 });
		dialogicTags[1] = new TIFFField(258, TIFFField.TIFF_SHORT, 1, (Object) new char[] { 1 });
		dialogicTags[2] = new TIFFField(262, TIFFField.TIFF_SHORT, 1, (Object) new char[] { 0 });
		dialogicTags[3] = new TIFFField(274, TIFFField.TIFF_SHORT, 1, (Object) new char[] { 1 });
		dialogicTags[4] = new TIFFField(282, TIFFField.TIFF_RATIONAL, 1, (Object) new long[][] {
				{ (long) 204, (long) 1 }, { (long) 0, (long) 0 } });
		dialogicTags[5] = new TIFFField(283, TIFFField.TIFF_RATIONAL, 1, (Object) new long[][] {
				{ (long) 196, (long) 1 }, { (long) 0, (long) 0 } });
		dialogicTags[6] = new TIFFField(296, TIFFField.TIFF_SHORT, 1, (Object) new char[] { 2 });
		dialogicTags[7] = new TIFFField(326, TIFFField.TIFF_LONG, 1, (Object) new long[] { (long) 0 });
		dialogicTags[8] = new TIFFField(327, TIFFField.TIFF_SHORT, 1, (Object) new char[] { 0 });

		param.setExtraFields(dialogicTags);
		try {
			enc.encode(out);
			if (!fileOutput.exists()) {
				fileOutput.createNewFile();
			}
			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		toolFrame.dispose();
		return fileOutput.getAbsolutePath();
	}

	public static void main(String[] args) throws Exception {
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
		html.append("<HTML>");
		html.append("<HEAD>");
		html.append("<TITLE> New Document </TITLE>");
		html.append("</HEAD>");
		html.append("<BODY height=2200 width=1728><table>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("<tr><td>dafdsafdsafdsafdsafdsafdsa<br></td></tr>");
		html.append("</table></font></BODY>");
		html.append("</HTML>");
		String fileName = String.valueOf(new Date().getTime()) + ".tif";
		HTML2TiffSnapshot.createTiff(html.toString(), null, fileName);
	}

	public static RenderedImage scaleToPix(RenderedImage source, double pixX, double pixY) {

		if (source == null) {
			return null;
		}
		int ww = source.getWidth();
		int hh = source.getHeight();
		float fattX = (float) (pixX / ww);
		float fattY = (float) (pixY / hh);

		ParameterBlock pb = new ParameterBlock();
		pb.addSource(source); // The source image
		pb.add(fattX); // The xScale
		pb.add(fattY); // The yScale
		pb.add(0.0f); // The x translation
		pb.add(0.0f); // The y translation

		try {
			source = JAI.create("scale", pb, null);
			return source;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
