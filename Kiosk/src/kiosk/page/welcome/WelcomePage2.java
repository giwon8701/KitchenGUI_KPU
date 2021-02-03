package kiosk.page.welcome;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import kiosk.MainFrame;
import kiosk.page.KioskGuidePanel;
import kiosk.page.KioskGuidePanel2;
import kiosk.page.KioskPage;
import kiosk.page.order.CartPanel;
import kiosk.page.order.OrderPage;

public class WelcomePage2 extends KioskPage {
	
	private final KioskGuidePanel WATING_PANEL = new KioskGuidePanel(0, 2);
	
	private final int MIDDLE_PANEL_WIDTH = KioskPage.PAGE_WIDTH * 4 / 5;
	private final int MIDDLE_PANEL_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 5;
	
	private final KioskGuidePanel2 WAITLINE_PANEL = new KioskGuidePanel2();
	private final KioskGuidePanel2 WAITTIME_PANEL = new KioskGuidePanel2();
	
	private final KioskGuidePanel YES_NO_SELECT_PANEL = new KioskGuidePanel(0, 1);
	private final OrderButton YES_BUTTON = new OrderButton("�ֹ��ϱ�");
	
	Font font_blank = new Font("arian", Font.BOLD, 50);
	Font font_label = new Font("arian", Font.PLAIN, 70);
	Font font = new Font("arian", Font.BOLD, 140);
	JLabel WaitLineLabel, WaitTimeLabel;
	public static JLabel WaitNum;
	public static JLabel WaitTime;
	public static JLabel Blank;
	public static JLabel Blank2;
	
	public static int WaitingTime = 0;
	public static int WaitingLine = 0;
	public static Timer timer;
	public WelcomePage2() {
		
		initPage();
		initWaitingPanel();
		initOrderButtonPanel();
		setListener();
	}
	
	private void initPage() {		// ���ȭ�� ����
		this.setBackgroundImg("image/background.png");
		this.showBackgroundImg(true);
		this.showBackButton(false);
	}
	
	private void initWaitingPanel() {

		EtchedBorder Etch = new EtchedBorder(10); // ������Ʈ �׵θ�
		/************����μ�***************************/
		WaitLineLabel = new JLabel("��� �μ� "); WaitLineLabel.setFont(font_label);
		WaitNum = new JLabel(WaitingLine + " ��");
		WaitNum.setFont(font);
		
		Blank = new JLabel();
		Blank.setText("                                                                          ");
		Blank.setFont(font_blank);
      
		WAITLINE_PANEL.addItem(WaitLineLabel, Blank, WaitNum);
		JComponent LineInfo = WAITLINE_PANEL.getPanel();
		LineInfo.setBorder(Etch);
		//LineInfo.setBorder(Line);
        /***********���ð�****************************/
        WaitTimeLabel = new JLabel("��� �ð� "); WaitTimeLabel.setFont(font_label);
		WaitTime = new JLabel(WaitingTime + " ��");
		WaitTime.setFont(font);
		Blank2 = new JLabel();
		Blank2.setText("                                                                        ");
		Blank2.setFont(font_blank);
      
		WAITTIME_PANEL.addItem(WaitTimeLabel, Blank2, WaitTime);
		JComponent TimeInfo = WAITTIME_PANEL.getPanel();
		TimeInfo.setBorder(Etch);
		//TimeInfo.setBorder(Line);
		/************************************************/
		
		WATING_PANEL.addItem(LineInfo, TimeInfo);
		
		
		// ����ο� + ���ð� ���ĳ��� �г�
		JComponent WaitingPanel = WATING_PANEL.getPanel();
		WaitingPanel.setSize(KioskPage.PAGE_WIDTH * 3/4 , KioskPage.PAGE_HEIGHT * 2/8);
		WaitingPanel.setLocation(150, KioskPage.PAGE_HEIGHT / 4);
		this.add(WaitingPanel);
	}

	private void initOrderButtonPanel() {
		YES_BUTTON.setFont(new Font("arian", Font.BOLD, 70));
		YES_NO_SELECT_PANEL.addItem(YES_BUTTON);
		
		final int PANEL_WIDTH = MIDDLE_PANEL_WIDTH  / 2;
		Component OrderButtonComp = YES_NO_SELECT_PANEL.getPanel();
		OrderButtonComp.setSize(PANEL_WIDTH * 8/7, MIDDLE_PANEL_HEIGHT / 4);
		OrderButtonComp.setLocation((KioskPage.PAGE_WIDTH - PANEL_WIDTH) / 2, KioskPage.PAGE_HEIGHT * 6 / 8);
		
		this.add(OrderButtonComp);
	}
	
	private void setListener() { // ��ư Ŭ���� ���� ȭ������ �Ѿ
		this.YES_BUTTON.addActionListener((args)-> {
			MainFrame.attachPanel(new OrderPage());});
	}
}