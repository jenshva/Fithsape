package main;

import connectivity.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Jens van der Sman
 */
public class Fitshape {

	/**
	 * Define frame width, height and name
	 */
	public static final int FRAME_WIDTH		= 1280;
	public static final int FRAME_HEIGHT	= 720;
	public static final String NAME			= "Fitshape Sportscholen";
	public static final String CURRENCY		= "€ ";
	/**
	 * static fonts which are used within the application
	 */
	public static final Font FONT_10_PLAIN = new Font("Verdana", Font.PLAIN, 10);
	public static final Font FONT_10_BOLD = new Font("Verdana", Font.BOLD, 10);
	public static final Font FONT_12_BOLD = new Font("Verdana", Font.BOLD, 12);
	public static final Font FONT_16_BOLD = new Font("Verdana", Font.BOLD, 16);
	/**
	 * database manager
	 */
	private DbManager dbManager;
	private QueryManager queryManager;
	/**
	 * the main window
	 */
	private JFrame mainWindow;
	/**
	 * singleton of the application
	 */
	private static Fitshape instance = new Fitshape();

	private Fitshape() {
	}

	public void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Error setting LookAndFeelClassName: " + e);
		}
		// create and initialize the connectivity
		dbManager = new DbManager();
		dbManager.openConnection();
		queryManager = new QueryManager(dbManager);
	}

	public void startup() {
		mainWindow = new JFrame(NAME);
		mainWindow.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		/**
		 * Make the window closing [x] button on the frame active
		 */
		mainWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				shutdown();
			}
		});

		mainWindow.getContentPane().setLayout(new BorderLayout());
		showPanel(new view.ProductList());

		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);
	}

	public void showPanel(JPanel panel) {

		mainWindow.getContentPane().removeAll();

		mainWindow.getContentPane().add(new view.MenuLeft(), BorderLayout.WEST);
		mainWindow.getContentPane().add(panel, BorderLayout.CENTER);
		
		mainWindow.getContentPane().validate();
		mainWindow.getContentPane().repaint();

	}

	public void exit() {
		mainWindow.setVisible(false);
		shutdown();
	}

	private void shutdown() {
		mainWindow.dispose();
		dbManager.closeConnection();
	}

	/**
	 * @return the instance of this class
	 */
	public static Fitshape getInstance() {
		return instance;
	}

	/**
	 * @return the queryManager
	 */
	public static QueryManager getQueryManager() {
		return getInstance().queryManager;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		final Fitshape applicatie = Fitshape.getInstance();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					applicatie.initialize();
					applicatie.startup();
				} catch (Exception e) {
					System.out.println("Application" + 
							applicatie.getClass().getName() + " failed to launch");
					System.out.println(e);
				}
			}
		});

	}
}
