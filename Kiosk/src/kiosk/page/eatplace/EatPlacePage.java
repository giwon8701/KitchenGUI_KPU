package kiosk.page.eatplace;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import kiosk.MainFrame;
import kiosk.page.KioskGuidePanel;
import kiosk.page.ImageTextButton;
import kiosk.page.KioskPage;
import kiosk.page.confirm.ConfirmPage;
import kiosk.page.order.OrderPage;
import kiosk.page.order.OrderPlace;
import kiosk.page.payment.place.AlarmSelectPage;
import kiosk.page.welcome.WelcomePage;
import kiosk.page.welcome.WelcomePage2;

/**
 * Class Role : �Ļ���� ������ �� �Ļ����/��� ���� ȭ����
 * ����Ѵ�.
 */
public class EatPlacePage extends KioskPage {

	private final int MIDDLE_PANEL_WIDTH = KioskPage.PAGE_WIDTH * 4 / 5;
	private final int MIDDLE_PANEL_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 5;

	private final KioskGuidePanel PLACE_SELECT_GUIDE_PANEL = new KioskGuidePanel("�Ļ��Ͻ� ��Ҹ� ������ �ּ���", 0, 2);
	private final ImageTextButton EAT_BUTTON = new ImageTextButton("���� �Ļ�", new ImageIcon("image/icon_eat.jpg"));
	private final ImageTextButton TAKE_BUTTON = new ImageTextButton("����ũ �ƿ�(����)", new ImageIcon("image/icon_take.jpg"));
	private static EatPlace eatplace;
	
	public EatPlacePage() {
		initPage();		// ��׶���(���)
		initPlaceGuidePanel();	
		setListeners();
	}

	private void initPage() {		// ���ȭ�� ����
		this.setBackgroundImg("image/background.png");
		this.showBackgroundImg(true);
		this.showBackButton(true);
	}

	private void initPlaceGuidePanel() {		// ���̵��г� ����
		PLACE_SELECT_GUIDE_PANEL.addItem(EAT_BUTTON, TAKE_BUTTON);
		Component placeSelectGuideComp = PLACE_SELECT_GUIDE_PANEL.getPanel();
		placeSelectGuideComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT);
		placeSelectGuideComp.setLocation((KioskPage.PAGE_WIDTH - MIDDLE_PANEL_WIDTH) / 2, KioskPage.PAGE_HEIGHT / 4);
		
		this.add(placeSelectGuideComp);
	}

	private void setListeners() {		// ��ư Ŭ���� �׼� ����(������� �������� ������ ����)
		//BACK_BUTTON.addActionListener((args) -> MainFrame.attachPanel(new WelcomePage()));
		BACK_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.attachPanel(new OrderPage());
			}
		});
		EAT_BUTTON.addActionListener((args) -> {
			OrderPlace.getInstance().setEatPlace(EatPlace.����Ļ�);	// �ֹ���� ������������ �ѱ� ����
			setPlace(EatPlace.����Ļ�);			// �ֹ�Ȯ���������� �ѱ� ����
			MainFrame.attachPanel(new ConfirmPage(false));
		});
		TAKE_BUTTON.addActionListener((args) -> {
			OrderPlace.getInstance().setEatPlace(EatPlace.����);
			setPlace(EatPlace.����);
			MainFrame.attachPanel(new ConfirmPage(false));
		});
	}
	
	public void setPlace(EatPlace eatplace) {		// eatplace ����
		this.eatplace = eatplace;
	}
	public static EatPlace getPlace() {			// eatplace ���
		return eatplace;
	}
	public static int sendserver( ) {
		if(getPlace() == EatPlace.����Ļ�)
			return 0;
		else
			return 1;
	}

	
}