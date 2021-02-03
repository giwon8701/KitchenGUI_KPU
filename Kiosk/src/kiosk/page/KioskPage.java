package kiosk.page;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import kiosk.Display;
import kiosk.MainFrame;

/**
 * Class Role : MainFrame ���� ���Ǵ� �г� 
 * 1. ���ȭ�� ǥ�ÿ��θ� �����Ѵ�.
 * 2. ���ȭ�� �̹������� ��� ������ �����Ѵ�. 
 * 3. ���ư ǥ�ÿ��ΰ� �����ϴ�.
 */
public abstract class KioskPage extends JPanel {
	public static final int PAGE_WIDTH = MainFrame.FRAME_WIDTH - MainFrame.FRAME_WIDTH / 200;
	public static final int PAGE_HEIGHT = MainFrame.FRAME_HEIGHT - (Display.SCREEN_HEIGHT - Display.WINDOWS_HEIGHT);

	protected final BackButton BACK_BUTTON = new BackButton();

	private boolean isBackgroundImg;
	private String backgroundImg;
	public KioskPage() {
		initPage();
	}
				
	private void initPage() {
		this.setLayout(null);
		this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
		this.setLocation(0, 0);
	}

	// ����̹��� ����
	protected void setBackgroundImg(String filePath) {
		backgroundImg = filePath;
	}

	/* ����̹��� ǥ�� ���� */
	protected void showBackgroundImg(boolean bool) {
		if (bool != isBackgroundImg) {
			if (bool && backgroundImg != null) {
				isBackgroundImg = bool;
			}
		}
	}

	/* ���ư ǥ�� ���� */
	protected void showBackButton(boolean bool) {
		if (bool && backgroundImg != null) {
			this.add(BACK_BUTTON);
		}
	}

	/* ����̹��� ���� */
	@Override
	protected void paintComponent(Graphics g) {
		if (isBackgroundImg) {
			try {
				BufferedImage bufferImg = ImageIO.read(new File(backgroundImg));
				super.paintComponent(g);
				g.drawImage(bufferImg, 0, 0, PAGE_WIDTH, PAGE_HEIGHT, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}