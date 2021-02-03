package kiosk.page.order;

/**
 * Class Role : ���ø޴� �����͸� �����Ѵ�.
 */
public class SelectedMenu {
	public static int orderPrice = 0;	// �ֹ��ݾ�
	public static int orderAmount = 0;	// �ֹ�����
	public static int totalKCal = 0;	// �� Į�θ�
	
	private SelectedMenu() {
		
	}
	
	public static void addOrder(int price, int amount, int kCal) {
		orderPrice += price;
		orderAmount += amount;
		totalKCal += kCal;
	}
	
	public static void init() {
		orderPrice = 0;
		orderAmount = 0;
		totalKCal = 0;
	}
}