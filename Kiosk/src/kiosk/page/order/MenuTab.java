package kiosk.page.order;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import kiosk.Display;
import kiosk.page.order.MenuPanel.BagelPanel;
import kiosk.page.order.MenuPanel.DessertPanel;
import kiosk.page.order.MenuPanel.DrinkPanel;

/**
 * Class Role : �޴����� �����Ѵ�.
 */
public class MenuTab extends JTabbedPane {
	
	String rpath = "Menu.csv";	// �������� ���
	BufferedReader br = null;		// �������� �о���� ���� ���
	// �޴� ��
	private final JPanel COFFEE_TAB = new JPanel();
	private final JPanel DRINK_TAB = new JPanel();
	private final JPanel DESSERT_TAB = new JPanel();
	private final JPanel BAGEL_TAB = new JPanel();
	// �޴� ���̺�
	private MenuTablePanel coffeeTable = new MenuTablePanel(0, 4);
	private MenuTablePanel drinkTable = new MenuTablePanel(0, 4);
	private MenuTablePanel dessertTable = new MenuTablePanel(0, 4);
	private MenuTablePanel bagelTable = new MenuTablePanel(0, 4);
	private DrinkPanel drinkpanel = new DrinkPanel();
	private DessertPanel dessertpanel = new DessertPanel();
	private BagelPanel bagelpanel = new BagelPanel();
	

	public MenuTab() {
		// �÷�
		COFFEE_TAB.setBackground(Color.WHITE);
		DRINK_TAB.setBackground(Color.WHITE);
		DESSERT_TAB.setBackground(Color.WHITE);
		BAGEL_TAB.setBackground(Color.WHITE);
		// ��ġ
		this.setTabPlacement(JTabbedPane.TOP); // �����ġ
		// �߰�
		COFFEE_TAB.add(coffeeTable);
		DRINK_TAB.add(drinkpanel);
		DESSERT_TAB.add(dessertpanel);
		BAGEL_TAB.add(bagelpanel);
		//DRINK_TAB.add(drinkTable);
		//DESSERT_TAB.add(dessertTable);
		//BAGEL_TAB.add(bagelTable);

		this.add(COFFEE_TAB);
		this.add(DRINK_TAB);
		this.add(DESSERT_TAB);
		this.add(BAGEL_TAB);
		
		// �� �̸�
		Font font = new Font("arian", Font.BOLD, 30);
		JLabel coffee = new JLabel("Ŀ��");
		JLabel drink = new JLabel("����&��");
		JLabel dessert = new JLabel("����Ʈ");
		JLabel bagel = new JLabel("���̱�");
		coffee.setFont(font);
		coffee.setPreferredSize(new Dimension(Display.SCREEN_WIDTH * 2/9, 50));
		coffee.setHorizontalAlignment(JLabel.CENTER);
		drink.setFont(font);
		drink.setPreferredSize(new Dimension(Display.SCREEN_WIDTH * 2/9, 50));
		drink.setHorizontalAlignment(JLabel.CENTER);
		dessert.setFont(font);
		dessert.setPreferredSize(new Dimension(Display.SCREEN_WIDTH * 2/9, 50));
		dessert.setHorizontalAlignment(JLabel.CENTER);
		bagel.setFont(font);
		bagel.setPreferredSize(new Dimension(Display.SCREEN_WIDTH * 2/9, 50));
		bagel.setHorizontalAlignment(JLabel.CENTER);
		this.setTabComponentAt(0, coffee);
		this.setTabComponentAt(1, drink);
		this.setTabComponentAt(2, dessert);
		this.setTabComponentAt(3, bagel);

		// �޴� ��ư ����
		resisterMenu();
	}
	
	 private void resisterMenu() {
	 	try {
	 		br = Files.newBufferedReader(Paths.get(rpath));
	 		Charset.forName("UTF-8");
	 		String line = "";
	 		while((line = br.readLine()) != null) {
	 			String array[] = line.split(",");
	 			if(array[0].equals("(Ŀ��)"))
	 				coffeeTable.addMenu(new MenuButton(Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]), Integer.parseInt(array[5])));
	 			if(array[0].equals("(����&��)"))
	 				break;
	// 				drinkTable.addMenu(new MenuButton(Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]), Integer.parseInt(array[5])));
	// 			if(array[0].equals("(����Ʈ)"))
	// 				dessertTable.addMenu(new MenuButton(Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]), Integer.parseInt(array[5])));
	// 			if(array[0].equals("(���̱�)"))
	// 				bagelTable.addMenu(new MenuButton(Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]), Integer.parseInt(array[5])));
	 		}
	 		
	 //		coffeeTable.addMenu(new MenuButton(Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]), Integer.parseInt(array[5])));
	 	} catch (IOException e) {e.printStackTrace();}
	 }
}