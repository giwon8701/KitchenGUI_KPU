package kiosk.page.order;


/**
 *
 * ��ٱ��Ͽ� ǥ���� ��ϵ��� ����ش�.
 * CartPanel.MenuList�� arraylist�� ����ش�.
 *
 */
public class CartMenu {
	String menuname;
	int menunum;
	int price;
	
	public CartMenu(String menuname, int menunum, int price) {
		this.menuname = menuname;
		this.menunum = menunum;
		this.price = price;
	}
	
	public String getmenuname() {
		return menuname;
	}
	public int getmenunum() {
		return menunum;
	}
	public int getprice() {
		return price;
	}
}
