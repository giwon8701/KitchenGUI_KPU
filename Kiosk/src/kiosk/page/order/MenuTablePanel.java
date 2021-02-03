package kiosk.page.order;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.page.KioskPage;

/**
 * Class Role : �� �鿡 ���̴� �޴����� ���ϼ��ִ� ���̺��̴�.
 */
public class MenuTablePanel extends JPanel {
	
	private final ArrayList<MenuButton> MENU_BUTTON_LIST = new ArrayList<>();

	public static final int TABLE_WIDTH = KioskPage.PAGE_WIDTH;
	public static final int TABLE_HEIGHT = KioskPage.PAGE_HEIGHT;

	public MenuTablePanel(int menuRows, int menuCols) {
		// �ʱ�ȭ
		GridLayout gridlayout = new GridLayout(menuRows, menuCols);
		this.setLayout(gridlayout);
		
		// ������ & �÷� 
		this.setSize(TABLE_WIDTH-150, TABLE_HEIGHT);
		this.setBackground(Color.WHITE);
		
	}
	
	// �޴����
	private void registerMenu() {
		for (MenuButton menuBtn : MENU_BUTTON_LIST) {
			this.add(menuBtn);
		}
	}

	// �޴� �߰�
	public void addMenu(MenuButton... menuButtons) {
		if (menuButtons.length != 0) {
			for (MenuButton menuBtn : menuButtons) {
				MENU_BUTTON_LIST.add(menuBtn);
				this.add(menuBtn);
			}
		}
	}
}