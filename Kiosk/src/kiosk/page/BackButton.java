package kiosk.page;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Class Role : ���������� ���Ǵ� ���ư�� ������ �� ���¸� �����Ѵ�.
 */
public class BackButton extends JButton {
	/* ��ư ������ */
	private static final int BUTTON_WIDTH = KioskPage.PAGE_WIDTH / 5;
	private static final int BUTTON_HEIGHT = KioskPage.PAGE_HEIGHT / 20;
	
	private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
	public BackButton() {
		initButton();
	}
	
	private void initButton() {
		this.setText("�ڷ�");
		this.setFont(new Font("arian", Font.BOLD, 25));
		this.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.setLocation(KioskPage.PAGE_WIDTH - this.getWidth() - KioskPage.PAGE_WIDTH / 30,
				KioskPage.PAGE_HEIGHT - (KioskPage.PAGE_HEIGHT - this.getHeight()));
		this.setBackground(BACKGROUND_COLOR);
	}

}