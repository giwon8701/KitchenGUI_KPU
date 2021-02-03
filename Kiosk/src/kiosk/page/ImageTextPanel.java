package kiosk.page;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class Role : ���������� ���Ǵ� �̹����ؽ�Ʈ �г��̴�.
 * �߾��� �̹����� �ϴ��� �ؽ�Ʈ���� ������ ������ �ִ�.
 */
public class ImageTextPanel {
	private static final JPanel IMAGE_TEXT_PANEL = new JPanel();
	
	private static final JLabel IMAGE_LABEL = new JLabel();
	private static final JLabel TEXT_LABEL = new JLabel();
	
	private static final int IMAGE_SIZE_WIDTH = KioskPage.PAGE_WIDTH;
	private static final int IMAGE_SIZE_HEIGHT = KioskPage.PAGE_HEIGHT * 9 / 10;
	
	private static final float TEXT_FONT_SIZE = 20.0f;
	private static Color TEXT_BACKGROUND_COLOR = new Color(00, 94, 00);
	private static final Color TEXT_FONT_COLOR = Color.WHITE;
	
	public ImageTextPanel(ImageIcon imgIcon, String text) {
		initImageTextPanel();
		initImgLabel(imgIcon);
		initTextLabel(text);
	}
	
	private void initImageTextPanel() {
		IMAGE_TEXT_PANEL.setLayout(null);
	}
	
	private void initImgLabel(ImageIcon imgIcon) {
		IMAGE_LABEL.setSize(IMAGE_SIZE_WIDTH, IMAGE_SIZE_HEIGHT);
		IMAGE_LABEL.setLocation(0, 0);
		setResizeImg(imgIcon);
		
		IMAGE_TEXT_PANEL.add(IMAGE_LABEL);
	}
	
	private void setResizeImg(ImageIcon imgIcon) {
		Image resizedImg = imgIcon.getImage().getScaledInstance(IMAGE_SIZE_WIDTH, IMAGE_SIZE_HEIGHT, Image.SCALE_SMOOTH);
		ImageIcon resizedImgIcon = new ImageIcon(resizedImg);
		
		IMAGE_LABEL.setIcon(resizedImgIcon);
	}
	
	private void initTextLabel(String text) {
		TEXT_LABEL.setText(text);
		TEXT_LABEL.setHorizontalAlignment(JLabel.CENTER);
		TEXT_LABEL.setFont(TEXT_LABEL.getFont().deriveFont(TEXT_FONT_SIZE));
		
		TEXT_LABEL.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT - IMAGE_SIZE_HEIGHT);
		TEXT_LABEL.setLocation(0, IMAGE_SIZE_HEIGHT);
		
		TEXT_LABEL.setBackground(TEXT_BACKGROUND_COLOR);
		TEXT_LABEL.setForeground(TEXT_FONT_COLOR);
		TEXT_LABEL.setOpaque(true);
		
		IMAGE_TEXT_PANEL.add(TEXT_LABEL);
	}
	
	public void setTextBackground(Color color) {
		TEXT_LABEL.setBackground(color);
	}
	
	public Component getPanel() {
		return IMAGE_TEXT_PANEL;
	}
}