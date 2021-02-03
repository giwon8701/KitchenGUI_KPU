package kiosk;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedWriter;

import javax.swing.JFrame;

import kiosk.page.KioskPage;
import kiosk.page.welcome.WelcomePage;
import kiosk.page.welcome.WelcomePage2;

/**
 * Class Role : ���α׷����� �����ϰ� ���Ǵ� �������̴�.
 * 
 * ���-
 * 1. �Էµ� Page�� �����ӿ� ���δ�.(�����ϴ�.)
 * 2. ȭ���� �����ش�.
 */
public final class MainFrame extends JFrame {
	static BufferedWriter bw=null;
	/* ������ ������ */
//	public static final int FRAME_WIDTH = Display.SCREEN_WIDTH / 2;
	public static final int FRAME_WIDTH = Display.SCREEN_WIDTH + 10;
	
//	public static final int FRAME_HEIGHT = Display.WINDOWS_HEIGHT;
	public static final int FRAME_HEIGHT = Display.SCREEN_HEIGHT + 40;
	/* �̱��� */
	private static final MainFrame UNIQUE_INSTANCE = new MainFrame(bw);
	private static final String TITLE = "ORDER HERE!";

	private MainFrame(BufferedWriter bw) {
		super(TITLE);
		initMainFrame();
		MainFrame.bw = bw;
	}

	// ������ ȯ�漳��
	private void initMainFrame() {
		this.setLayout(null);
		this.setTitle(TITLE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		this.setLocation((Display.SCREEN_WIDTH - FRAME_WIDTH) / 2, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.add(new WelcomePage());
		this.add(new WelcomePage2());
	}

	// �Էµ� KioskPage�� �����ӿ� ���δ�.
	public static void attachPanel(KioskPage page) {
		// �����̳� ����
		UNIQUE_INSTANCE.getContentPane().removeAll();

		// �г� �߰�
		UNIQUE_INSTANCE.getContentPane().add(page);

		// ����
		UNIQUE_INSTANCE.revalidate();
		UNIQUE_INSTANCE.repaint();
	}

	// ȭ���� �����ش�.
	static void showScreen() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		UNIQUE_INSTANCE.setUndecorated(true);
	//	gd.setFullScreenWindow(UNIQUE_INSTANCE);
		
		UNIQUE_INSTANCE.setVisible(true);
	}
}