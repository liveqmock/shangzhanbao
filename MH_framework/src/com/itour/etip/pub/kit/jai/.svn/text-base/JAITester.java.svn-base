package com.itour.etip.pub.kit.jai;

//This program has two parts , it can invert a image, and compare with the original one in a frame.You need download and install Java Advanced Imaging before you use it!!!
//compile:
//javac "###1&2.java"
//run:
//java "###2" "image file name.jpg" <return>
//now, here is the code:
//part one:
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.DataBuffer;
import java.awt.image.IndexColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.iterator.RandomIter;
import javax.media.jai.iterator.RandomIterFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.TIFFEncodeParam;
import com.sun.media.jai.widget.DisplayJAI;

/**
 * This class represents a Panel which contains two instances of
 * DisplayJAIWithPixelInfo. The scrolling bars of both images are synchronized
 * so scrolling one image will automatically scroll the other.
 */
public class JAITester extends JPanel implements AdjustmentListener {

	/** The DisplayJAIWithPixelInfo for the first image. */
	protected DisplayJAIWithPixelInfo dj1;

	/** The DisplayJAIWithPixelInfo for the second image. */
	protected DisplayJAIWithPixelInfo dj2;

	/** The JScrollPane which will contain the first of the images */
	protected JScrollPane jsp1;

	/** The JScrollPane which will contain the second of the images */
	protected JScrollPane jsp2;

	/**
	 * Constructs an instance of this class, setting the components? layout,
	 * creating two instances of DisplayJAI for the two images and creating/
	 * registering event handlers for the scroll bars.
	 * 
	 * @param im1
	 *            the first image (left side)
	 * @param im2
	 *            the second image (right side)
	 */
	public JAITester(PlanarImage im1, PlanarImage im2) {
		super();
		setLayout(new GridLayout(1, 2));
		try {
			dj1 = new DisplayJAIWithPixelInfo(im1); // Instances of DisplayJAI
			// for
		} catch (Throwable ex) {

		}
		// the
		try {
			dj2 = new DisplayJAIWithPixelInfo(im2); // two images
		} catch (Throwable ex) {

		}
		jsp1 = new JScrollPane(dj1); // JScrollPanes for the both
		jsp2 = new JScrollPane(dj2); // instances of DisplayJAI
		add(jsp1);
		add(jsp2);
		// Retrieve the scroll bars of the images and registers adjustment
		// listeners to them.
		// Horizontal scroll bar of the first image.
		jsp1.getHorizontalScrollBar().addAdjustmentListener(this);
		// Vertical scroll bar of the first image.
		jsp1.getVerticalScrollBar().addAdjustmentListener(this);
		// Horizontal scroll bar of the second image.
		jsp2.getHorizontalScrollBar().addAdjustmentListener(this);
		// Vertical scroll bar of the second image.
		jsp2.getVerticalScrollBar().addAdjustmentListener(this);
	}

	/**
	 * This method will be called when any of the scroll bars of the instances
	 * of DisplayJAI are changed. The method will adjust the scroll bar of the
	 * other DisplayJAI as needed.
	 * 
	 * @param e
	 *            the AdjustmentEvent that ocurred (meaning that one of the
	 *            scroll bars position has changed.
	 */
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// If the horizontal bar of the first image was changed...
		if (e.getSource() == jsp1.getHorizontalScrollBar()) {
			// We change the position of the horizontal bar of the second image.
			jsp2.getHorizontalScrollBar().setValue(e.getValue());
		}
		// If the vertical bar of the first image was changed...
		if (e.getSource() == jsp1.getVerticalScrollBar()) {
			// We change the position of the vertical bar of the second image.
			jsp2.getVerticalScrollBar().setValue(e.getValue());
		}
		// If the horizontal bar of the second image was changed...
		if (e.getSource() == jsp2.getHorizontalScrollBar()) {
			// We change the position of the horizontal bar of the first image.
			jsp1.getHorizontalScrollBar().setValue(e.getValue());
		}
		// If the vertical bar of the second image was changed...
		if (e.getSource() == jsp2.getVerticalScrollBar()) {
			// We change the position of the vertical bar of the first image.
			jsp1.getVerticalScrollBar().setValue(e.getValue());
		}
	}

	public static void main(String[] args) throws Exception {
		float x = 0f;
		float y = 0f;

		FileSeekableStream stream = new FileSeekableStream(
				"c:/myhomelife/DSCF0373.JPG");
		ParameterBlock pb = (new ParameterBlock());
		PlanarImage in = JAI.create("stream", stream);
		pb.addSource(in);
		pb.add(x);
		pb.add((float) (in.getHeight() / 3));
		pb.add((float) in.getWidth());
		pb.add((float) ((in.getHeight()) * 2 / 3));
		PlanarImage out = JAI.create("crop", pb, null);
		OutputStream os = new FileOutputStream("c:/myhomelife/DSCF0373.tif");
		TIFFEncodeParam param = new TIFFEncodeParam();
		ImageEncoder enc = ImageCodec.createImageEncoder("tiff", os, param);
		enc.encode(out);
		stream.close();
		os.close();

		// Read the image.
		PlanarImage input = JAI
				.create("fileload", "c:/myhomelife/DSCF0373.JPG");
		// Invert the image.
		PlanarImage output = JAI.create("fileload",
				"c:/myhomelife/DSCF0373.tif");

		JFrame frame = new JFrame();
		frame.setTitle("Invert image ");
		frame.getContentPane().add(new JAITester(input, output));
		// Set the closing operation so the application is finished.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); // adjust the frame size using preferred dimensions.
		frame.setVisible(true); // show the frame.

	}
}

class DisplayJAIWithPixelInfo extends DisplayJAI {
	private StringBuffer pixelInfo; // The pixel information (formatted in a
	private double[] dpixel; // The pixel information as an array of doubles.
	private int[] ipixel; // The pixel information as an array of integers.
	private boolean isDoubleType; // Indicates which of the above arrays we
	private RandomIter readIterator; // A RandomIter that allow us to get the
	private boolean isIndexed; // True if the image has a indexed color model.
	private short[][] lutData; // Will contain the look-up table data if
	protected int width, height; // The dimensions of the image

	/**
	 * 35 * The constructor of the class, which creates the arrays and instances
	 * needed 36 * to obtain the image data and registers the class to listen to
	 * mouse motion events. 37 *
	 * 
	 * @param image
	 *            a RenderedImage for display 38
	 */
	public DisplayJAIWithPixelInfo(RenderedImage image) throws Throwable {
		super(image); // Calls the constructor for DisplayJAI.
		readIterator = RandomIterFactory.create(image, null); // Creates the
		// iterator.
		// Get some data about the image
		width = image.getWidth();
		height = image.getHeight();
		int dataType = image.getSampleModel().getDataType(); // Gets the data
		// type
		switch (dataType) {
		case DataBuffer.TYPE_BYTE:
		case DataBuffer.TYPE_SHORT:
		case DataBuffer.TYPE_USHORT:
		case DataBuffer.TYPE_INT:
			isDoubleType = false;
			break;
		case DataBuffer.TYPE_FLOAT:
		case DataBuffer.TYPE_DOUBLE:
			isDoubleType = true;
			break;
		}
		// Depending on the image data type, allocate the double or the int
		// array.
		if (isDoubleType)
			dpixel = new double[image.getSampleModel().getNumBands()];
		else
			ipixel = new int[image.getSampleModel().getNumBands()];
		// Is the image color model indexed?
		isIndexed = (image.getColorModel() instanceof IndexColorModel);
		if (isIndexed) {
			// Retrieve the index color model of the image.
			IndexColorModel icm = (IndexColorModel) image.getColorModel();
			// Get the number of elements in each band of the colormap.
			int mapSize = icm.getMapSize();
			// Allocate an array for the lookup table data.
			byte[][] templutData = new byte[3][mapSize];
			// Load the lookup table data from the IndexColorModel.
			icm.getReds(templutData[0]);
			icm.getGreens(templutData[1]);
			icm.getBlues(templutData[2]);
			// Load the lookup table data into a short array to avoid negative
			// numbers.
			lutData = new short[3][mapSize];
			for (int entry = 0; entry < mapSize; entry++) {
				lutData[0][entry] = templutData[0][entry] > 0 ? templutData[0][entry]
						: (short) (templutData[0][entry] + 256);
				lutData[1][entry] = templutData[1][entry] > 0 ? templutData[1][entry]
						: (short) (templutData[1][entry] + 256);
				lutData[2][entry] = templutData[2][entry] > 0 ? templutData[2][entry]
						: (short) (templutData[2][entry] + 256);
			}
		} // end if indexed
		// Registers the mouse motion listener.
		addMouseMotionListener(this);
		// Create the StringBuffer instance for the pixel information.
		pixelInfo = new StringBuffer(50);
	}

	/**
	 * 98 * This method will be called when the mouse is moved over the image
	 * being 99 * displayed. 100 *
	 * 
	 * @param me
	 *            the mouse event that caused the execution of this method. 101
	 */
	public void mouseMoved(java.awt.event.MouseEvent me) {
		pixelInfo.setLength(0); // Clear the StringBuffer
		int x = me.getX();
		int y = me.getY();
		if ((x >= width) || (y >= height)) {
			pixelInfo.append("No data!");
			return;
		}
		if (isDoubleType) // Process the pixel as an array of double values
		{
			pixelInfo.append("(floating-point data) ");
			readIterator.getPixel(me.getX(), me.getY(), dpixel); // Read the
			// pixel's
			// values
			for (int b = 0; b < dpixel.length; b++)
				pixelInfo.append(dpixel[b] + ","); // Append to the
			// StringBuffer
			pixelInfo = pixelInfo.deleteCharAt(pixelInfo.length() - 1); // Erase
			// last
			// comma
		} else // Pixel type is not floating point, will be processed as
		// integers.
		{
			if (isIndexed) // If color model is indexed
			{
				pixelInfo.append("(integer data with colormap) ");
				readIterator.getPixel(me.getX(), me.getY(), ipixel); // Read
				// the
				// pixel's
				// values
				// Assume ipixel.length = 1
				pixelInfo.append("Index: " + ipixel[0]);
				// Add also the RGB entry from the LUT.
				pixelInfo.append(" RGB:" + lutData[0][ipixel[0]] + ","
						+ lutData[1][ipixel[0]] + "," + lutData[2][ipixel[0]]);
			} else
			// Pixels are of integer type, but not indexed
			{
				pixelInfo.append("(integer data) ");
				readIterator.getPixel(me.getX(), me.getY(), ipixel); // Read
				// the
				// pixel's
				// values
				for (int b = 0; b < ipixel.length; b++)
					pixelInfo.append(ipixel[b] + ","); // Append to the
				// StringBuffer
				pixelInfo = pixelInfo.deleteCharAt(pixelInfo.length() - 1); // Erase
				// last
				// comma
			}
		} // Pixel is integer type
	} // end of method mouseMoved

	/**
	 * 145 * This method allows access to the pixel info which was obtained in
	 * the mouseMoved method. 146 *
	 * 
	 * @return the pixel information, formatted as a string 147
	 */
	public String getPixelInfo() {
		return pixelInfo.toString();
	}

}
