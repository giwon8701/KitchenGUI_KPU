package kiosk.page.confirm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.page.eatplace.EatPlace;
import kiosk.page.order.CartPanel;
import kiosk.page.order.MenuButton;
import kiosk.page.order.SelectedMenu;

public class OrderTotalDataPanel extends JPanel {
	
	private final EatPlace eatPlace;
	public static ArrayList<OrderData> orderDataArray;
	
	String header[] = { "�޴�", "����", "����" };
	
	OrderTotalDataPanel(EatPlace eatPlace, ArrayList<OrderData> orderDataArray) {
		this.eatPlace = eatPlace;
		
		this.orderDataArray = orderDataArray;
		
		
		initPanel();
	}
	
	// �г� �ʱ�ȭ
	private void initPanel() {
		this.setLayout(new BorderLayout());
//		this.add(new JScrollPane(new JList<Object>(orderDataArray.toArray())), BorderLayout.CENTER);
		this.add(createTotalListPanel(), BorderLayout.SOUTH);
		this.add(CartPanel.CartTable);
	}
	
	// factory ����, ����� ����.
	private JPanel createTotalListPanel() {
		Font font = new Font("arian", Font.BOLD, 30);
		JPanel totalListPanel = new JPanel();
		totalListPanel.setLayout(new GridLayout(3, 2));
		JLabel numLabel = new JLabel("�ֹ����� : ", JLabel.CENTER);
		JLabel priceLabel = new JLabel("�ֹ��ݾ� : ", JLabel.CENTER);
		
		JLabel kcalLabel = new JLabel("�� Į�θ� : ", JLabel.CENTER);
		JLabel num = new JLabel( SelectedMenu.orderAmount + " EA", JLabel.CENTER);
		JLabel price = new JLabel(SelectedMenu.orderPrice + " ��", JLabel.CENTER);
		JLabel kcal = new JLabel(SelectedMenu.totalKCal + " Kcal", JLabel.CENTER);
		numLabel.setFont(font);		num.setFont(font);
		priceLabel.setFont(font);	price.setFont(font);
		kcalLabel.setFont(font);	kcal.setFont(font);
		totalListPanel.add(numLabel);	totalListPanel.add(num);
		totalListPanel.add(priceLabel);	totalListPanel.add(price);
		totalListPanel.add(kcalLabel);	totalListPanel.add(kcal);
		
		return totalListPanel;
	}
	public static int menunum() {
		return orderDataArray.size();
	}

}