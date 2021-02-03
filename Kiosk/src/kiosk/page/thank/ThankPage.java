package kiosk.page.thank;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import kiosk.Client;
import kiosk.MainFrame;
import kiosk.page.ImageTextPanel;
import kiosk.page.KioskPage;
import kiosk.page.confirm.ChoosePlace;
import kiosk.page.confirm.ConfirmPage;
import kiosk.page.confirm.MileagePanel;
import kiosk.page.confirm.OrderData;
import kiosk.page.confirm.OrderTotalDataPanel;
import kiosk.page.confirm.Phonenumber;
import kiosk.page.eatplace.EatPlacePage;
import kiosk.page.order.CartPanel;
import kiosk.page.order.MenuButton;
import kiosk.page.order.OrderPlace;
import kiosk.page.order.SelectedMenu;
import kiosk.page.welcome.WelcomePage;
import kiosk.page.welcome.WelcomePage2;

/** 
 * Class Role : �ֹ� �Ϸ� �ȳ� ������
 */
public class ThankPage extends KioskPage {

	private final ImageTextPanel THANK_IMG_TEXT_PANEL = new ImageTextPanel(new ImageIcon("image/bg_thanks.jpg"),
			"�ֹ��� �Ϸ�Ǿ����ϴ�.");
	StringBuilder send = new StringBuilder();
	public static int OrderNum = 1;
	public ThankPage() {
		sendserver();
		initPage();
		initOrderData();
		Phonenumber.initPhoneNumber();		// �ڵ�����ȣ �����
		initThankImgTextPanel();
		setListener();

	}

	private void initPage() {
		this.showBackgroundImg(false);
		this.showBackButton(false);
	}
	
	private void initThankImgTextPanel() {
		THANK_IMG_TEXT_PANEL.setTextBackground(new Color(00, 94, 00));
		//THANK_IMG_TEXT_PANEL.setTextBackground(Color.GREEN);
		
		Component thankImgTextPanel = THANK_IMG_TEXT_PANEL.getPanel();
		thankImgTextPanel.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT);
		thankImgTextPanel.setLocation(0, 0);
		
		this.add(thankImgTextPanel);
	}

	private void initOrderData() {
		OrderPlace.getInstance().init();
		SelectedMenu.init();
		CartPanel.initCart();
		initgetMenu();
		MenuButton.info.clear();
	}

	private void setListener() {

			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainFrame.attachPanel(new WelcomePage2());
				}
			});
	}
	private StringBuilder getMenu() {
		int binary;
		int amount;
		int size;
		int temp;
		for(int i=0;i<MenuButton.info.size();i++) {
			binary = MenuButton.info.get(i).getBinary();
			amount = MenuButton.info.get(i).getAmount();
			size = MenuButton.info.get(i).sendSize();
			temp = MenuButton.info.get(i).sendTemp();
			send.append(".").append(binary).append(".").append(amount).append(".").append(size).append(".").append(temp);
		}
		return send;
	}
	private void initgetMenu() {
		send = null;
	}
	
	private void sendserver() {
		// �����ֹ�,����Ļ�,���þ˸�,�޴���������,�ֹ���ȣ,�ڵ�����ȣ,�޴����(+����)
			try {
//				if(OrderPlace.getAlarmSelect().equals("BELL")) {
					Client.bw.write("0000" + "," + "0" + "," +			// �����ֹ���, �����ֹ�or���ÿ���
									ChoosePlace.sendserver() + "," +		// �Ļ� or����ũ�ƿ�(����)
									"1" + ","+	// �˸�(����or������)
									Integer.toBinaryString(OrderTotalDataPanel.menunum()) + "," + // �޴���������
									OrderNum + "." +		// �ֹ���ȣ
									MileagePanel.getnumber() +	//�ڵ�����ȣ
									getMenu() + "\n"); // �ֹ��޴�(�̸�,����)
					Client.bw.flush();
//				}
/*				else {
					Client.bw.write("0000" + "," + "0" + "," +
									EatPlacePage.sendserver() + "," +		// �Ļ� or����ũ�ƿ�(����)
									OrderPlace.sendserver() + ","+	// �˸�(����or������)
									Integer.toBinaryString(OrderTotalDataPanel.menunum()) + "," + // �޴���������
									OrderNum + "." +
									Phonenumber.getnumber() +	//�ڵ�����ȣ
									getMenu() + "\n");
					Client.bw.flush();
				}*/
			} catch (IOException e) {e.printStackTrace();}
	}
}