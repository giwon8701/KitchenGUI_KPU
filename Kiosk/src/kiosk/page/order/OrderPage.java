package kiosk.page.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import kiosk.MainFrame;
import kiosk.page.ImageEdit;
import kiosk.page.KioskPage;
import kiosk.page.eatplace.EatPlacePage;
import kiosk.page.payment.place.AlarmSelectPage;
import kiosk.page.welcome.WelcomePage2;

/**
 * Class Role : 주문관련 페이지이다.
 * 상단 이미지, 중간 스크롤, 하단 장바구니로 구성되어 있다.
 */
public class OrderPage extends KioskPage {
	// 상단 높이
//	public static int TOP_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 10;
	public static int TOP_HEIGHT = KioskPage.PAGE_HEIGHT * 3 / 20;
	// 중간 높이
//	public static int CENTER_HEIGHT = KioskPage.PAGE_HEIGHT * 5 / 10;
	public static int CENTER_HEIGHT = KioskPage.PAGE_HEIGHT * 11 / 20;
	// 하단 높이
	public static int BOTTOM_HEIGHT = KioskPage.PAGE_HEIGHT * 3 / 10;

	private final JLabel TOP_IMG = new JLabel(ImageEdit.getResizeIcon("image/banner_top.png", KioskPage.PAGE_WIDTH, TOP_HEIGHT));
	
	private final JScrollPane SCROLL = new JScrollPane();
	private final MenuTab MENU_TAB = new MenuTab();
	
	private final CartPanel cartPanel = new CartPanel();
	
	public OrderPage() {
		this.setLayout(null);

		// 사이즈
		TOP_IMG.setSize(KioskPage.PAGE_WIDTH, TOP_HEIGHT);
		SCROLL.setSize(KioskPage.PAGE_WIDTH-10, CENTER_HEIGHT);
	//	MENU_TAB.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT);
		MENU_TAB.setSize(KioskPage.PAGE_WIDTH, CENTER_HEIGHT);
		cartPanel.setSize(KioskPage.PAGE_WIDTH, BOTTOM_HEIGHT);

		// 위치
		TOP_IMG.setLocation(0, 0);
		SCROLL.setLocation(0, TOP_IMG.getHeight());
		MENU_TAB.setLocation(0, TOP_IMG.getHeight());
		cartPanel.setLocation(0, KioskPage.PAGE_HEIGHT * 7 / 10);

		cartPanel.setOpaque(true);
	
		// 기타
		SCROLL.getVerticalScrollBar().setUnitIncrement(18); // 스크롤 속도

		// 추가
		SCROLL.setViewportView(MENU_TAB);
		this.add(MENU_TAB);
		this.add(TOP_IMG);
		//this.add(SCROLL);
		
		this.add(cartPanel);
		
		this.setVisible(true);

		this.setComponentZOrder(BACK_BUTTON, 0);

		this.BACK_BUTTON.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.attachPanel(new WelcomePage2());
				SelectedMenu.init();
				CartPanel.initCart();
				MenuButton.info.clear();
				CartPanel.CartMenu.setNumRows(0);
			}
		});
	}
}