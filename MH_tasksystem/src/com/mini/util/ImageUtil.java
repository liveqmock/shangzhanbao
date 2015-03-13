package com.mini.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeComponent;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;

public class ImageUtil extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 行分隔符
	final static public String LS = System.getProperty("line.separator", "\n");

	// 文件分割符
	final static public String FS = System.getProperty("file.separator", "\\");

	//以javascript脚本获得网页全屏后大小
	final static StringBuffer jsDimension;
	
	static {
		jsDimension = new StringBuffer();
		jsDimension.append("var width = 0;").append(LS);
		jsDimension.append("var height = 0;").append(LS);
		jsDimension.append("if(document.documentElement) {").append(LS);
		jsDimension.append(
						"  width = Math.max(width, document.documentElement.scrollWidth);")
				.append(LS);
		jsDimension.append(
						"  height = Math.max(height, document.documentElement.scrollHeight);")
				.append(LS);
		jsDimension.append("}").append(LS);
		jsDimension.append("if(self.innerWidth) {").append(LS);
		jsDimension.append("  width = Math.max(width, self.innerWidth);")
				.append(LS);
		jsDimension.append("  height = Math.max(height, self.innerHeight);")
				.append(LS);
		jsDimension.append("}").append(LS);
		jsDimension.append("if(document.body.scrollWidth) {").append(LS);
		jsDimension.append(
				"  width = Math.max(width, document.body.scrollWidth);")
				.append(LS);
		jsDimension.append(
				"  height = Math.max(height, document.body.scrollHeight);")
				.append(LS);
		jsDimension.append("}").append(LS);
		jsDimension.append("return width + ':' + height;");
	}
	
	
//	final static String fileName = System.currentTimeMillis() + ".jpg";//文件名称

	public ImageUtil(final String url, final int maxWidth, final int maxHeight,final String realName,final String fileName) {
		super(new BorderLayout());
		JPanel webBrowserPanel = new JPanel(new BorderLayout());
		final JWebBrowser webBrowser = new JWebBrowser(null);
		webBrowser.setBarsVisible(false);
		webBrowser.navigate(url);
		webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		add(webBrowserPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));

		webBrowser.addWebBrowserListener(new WebBrowserAdapter() {

			// 监听加载进度
			public void loadingProgressChanged(WebBrowserEvent e) {
				// 当加载完毕时
				if (e.getWebBrowser().getLoadingProgress() == 100) {
					String result = (String) webBrowser
							.executeJavascriptWithResult(jsDimension.toString());
					int index = result == null ? -1 : result.indexOf(":");
					NativeComponent nativeComponent = webBrowser
							.getNativeComponent();
					Dimension originalSize = nativeComponent.getSize();
					Dimension imageSize = new Dimension(Integer.parseInt(result
							.substring(0, index)), Integer.parseInt(result
							.substring(index + 1)));
					imageSize.width = Math.max(originalSize.width,
							imageSize.width + 50);
					imageSize.height = Math.max(originalSize.height,
							imageSize.height + 50);
					nativeComponent.setSize(imageSize);
					if(imageSize.width<imageSize.height){
						imageSize.height=imageSize.width;//截取网页的高度和宽度一样，同比例缩放
					}
					BufferedImage image = new BufferedImage(imageSize.width,
							imageSize.height, BufferedImage.TYPE_INT_RGB);
					nativeComponent.paintComponent(image);
					nativeComponent.setSize(originalSize);
					// 当网页超出目标大小时
					if (imageSize.width > maxWidth
							|| imageSize.height > maxHeight) {
						//截图部分图形
//						image = image.getSubimage(0, 0, maxWidth, maxHeight);
						//此部分为使用缩略图
						int width = image.getWidth(), height = image
							.getHeight();
						
						 AffineTransform tx = new AffineTransform();
						tx.scale(1, 1);//1:1的截图
						AffineTransformOp op = new AffineTransformOp(tx,
								AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
						//缩小
						image = op.filter(image, null);
					}
					try {
						// 输出图像
						ImageIO.write(image, "jpg", new File(realName+fileName));
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					// 退出操作
//					System.exit(0);
				}
			}
		}

		);
		add(panel, BorderLayout.SOUTH);

	}
	
	/**
	 * 给页面做缩略图。
	 * @author dailimin
	 * @param url  是需要做缩略图的页面的路径
	 * @param realName  是文件存放的目录的路径 realname+filename是文件的整体路径
	 * @param filename  是文件的名称，使用page的ID来命名 realname+filename是文件的整体路径
	 * @return
	 */
	public static String createImg(final String url,final String realName,final String fileName){
		
		
//		NativeInterface.open();
//		
//		SwingUtilities.invokeLater(new Runnable(){
//			public void run() {
//				// SWT组件转Swing组件，不初始化父窗体将无法启动webBrowser
//				JFrame frame = new JFrame("以DJ组件保存指定网页截图");
//				// 加载google，最大保存为640x480的截图
//				ImageUtil img = new ImageUtil(url, 0, 0,realName,fileName);
//				frame.getContentPane().add(
//						img,
//						BorderLayout.CENTER);
//				frame.setSize(800, 600);
//				// 仅初始化，但不显示
//				frame.invalidate();
//				frame.pack();
//				frame.setVisible(false);
//			}
//		});
////		NativeInterface.runEventPump();
//		
//		//返回图片生成的路径
//		return fileName;
		
		return "";
	}

	public static void main(String[] args) {
		System.out.println("开始截图----"+new Date());
//		ImageUtil img = new ImageUtil("http://www.baidu.com", 640, 480,"");
//		NativeInterface.open();
//		SwingUtilities.invokeLater(new Runnable(){
//			public void run() {
//				// SWT组件转Swing组件，不初始化父窗体将无法启动webBrowser
//				JFrame frame = new JFrame("以DJ组件保存指定网页截图");
//				// 加载google，最大保存为640x480的截图
//				ImageUtil img = new ImageUtil("http://www.baidu.com", 640, 480,"realpath");
//				frame.getContentPane().add(
//						img,
//						BorderLayout.CENTER);
//				frame.setSize(800, 600);
//				// 仅初始化，但不显示
//				frame.invalidate();
//				frame.pack();
//				frame.setVisible(false);
//			}
//		});
//		NativeInterface.runEventPump();
		
	//	System.out.println(createImg("http://www.baidu.com", "C:\\Users\\hp\\Desktop\\ctn\\minipage\\","111.jpg"));
		
		System.out.println("结束截图----"+new Date());
	}

}
