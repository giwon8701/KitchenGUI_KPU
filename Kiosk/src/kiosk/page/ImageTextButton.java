package kiosk.page;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Class Role : ���������� ���������� ���Ǵ� �̹�����ư�̴�.
 * ����� ������¡ �� �̹����� �ϴ��� �ؽ�Ʈ ������ ������ �ִ�.
 */
public class ImageTextButton extends JButton {
	private static final int IMAGE_SIZE_WIDTH = KioskPage.PAGE_WIDTH * 4 / 15;
	private static final int IMAGE_SIZE_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 15;
	
	private static final float FONT_SIZE = 15.0f; // float�� ����ũ��, int�� ���ڵ�����
	private static final Color FONT_COLOR = Color.RED;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	
	public ImageTextButton() {
		init();
	}

	public ImageTextButton(Action a) {
		super(a);
		init();
	}

	public ImageTextButton(Icon icon) {
		super(icon);
		init();
	}

	public ImageTextButton(String text, ImageIcon icon) {
		super(text, icon);
		init();
		setResizedImg(icon);
	}

	public ImageTextButton(String text) {
		super(text);
		init();
	}
	
	private void init() {
		this.setFont(this.getFont().deriveFont(FONT_SIZE));
		this.setForeground(FONT_COLOR);
		this.setBackground(BACKGROUND_COLOR);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
	}
	
	private void setResizedImg(ImageIcon icon) {	// �Ļ����(����Ļ�,����ũ�ƿ�) �̹��� ������¡
		setResizedImg(icon, IMAGE_SIZE_WIDTH*3/2, IMAGE_SIZE_HEIGHT*4/2);
	}
	
	public void setResizedImg(ImageIcon icon, int width, int height) {
		Image resizedImg = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon resizedImgIcon = new ImageIcon(resizedImg);
		
		this.setIcon(resizedImgIcon);
	}
}