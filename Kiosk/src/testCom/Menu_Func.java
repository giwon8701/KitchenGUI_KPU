package testCom;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu_Func {
   static int n = 0;
   static String path = "E:\\Menu.csv";
   public static Info_Menu[] info = new Info_Menu[100];
}

/************�������޴� �߰�************/
class Add {					// �޴� �߰� �޼ҵ�
   BufferedReader br = null;
   public Add() {}
   public void add() throws IOException {
	  br = Files.newBufferedReader(Paths.get(Menu_Func.path));
      String line = "";
      Scanner add = new Scanner(System.in);
      System.out.print("� �޴��� �߰��Ͻðڽ��ϱ�?: ");
      String addmenu = add.nextLine();
      while((line = br.readLine()) != null) {	//���������� ������ ����
          String array[] = line.split(",");			// ,�� ������ �迭�� ����
          if(addmenu.equals(array[0])) {
            Menu_Func.info[Menu_Func.n] = new Info_Menu();	//n��° �޴� �迭�� ����
            Menu_Func.info[Menu_Func.n].setMenu(addmenu);	//�� �迭�� ��û�� �޴��� �־���
            System.out.println((Menu_Func.n+1) + "���� '" + addmenu + "'�� �߰��Ǿ����ϴ�.");
            System.out.print("������� �ֹ� : ");
            for(int i=0; i<Menu_Func.n+1; i++)	//ù��° ���޴����� ������ ���޴����� ���
               System.out.print((i+1) + "." + Menu_Func.info[i].getMenu() + "  ");	
            System.out.println();
            Menu_Func.n++;		//���� �޴��� �ޱ����� n�� ����������
          }
      }
   }
}

/************�������޴� ����************/
class Remove {
   public Remove() {
   }
   public void remove() {
	   Scanner input = new Scanner(System.in);
      while(true) {
         System.out.print("����� �����Ͻðڽ��ϱ�?: ");
         int del = input.nextInt();		//������ ��ȣ del�� �Է¹���
         if(del > Menu_Func.n || del <= 0)	//del�� ���� �ֹ���ⰳ��(=n)���� ũ�ų� ������� ����
            System.out.println("�߸��� �ֹ���ȣ�Դϴ�. �ٽ� �Է����ּ���.");
         else if(del <= Menu_Func.n && del > 0) {
            for(int i=del; i<Menu_Func.n; i++)
            	Menu_Func.info[i-1] = Menu_Func.info[i];
            Menu_Func.n--;
            break;
         }
      }
      System.out.print("������� �ֹ� : ");
      for(int i=0; i<Menu_Func.n; i++)
            System.out.print((i+1) + "." + Menu_Func.info[i].getMenu() + "  ");
      System.out.println();  
   }
}

/************�������޴�, �ֹ����¸޴� ���************/
class Printmenu {
	String Msg;
	BufferedReader br = null;
	
	public Printmenu(String Msg) {
		this.Msg = Msg;
	}
	
	public void printmenu() throws IOException {
		br = Files.newBufferedReader(Paths.get(Menu_Func.path));	//����Ŭ������ ����� ��θ� �ҷ��´�.
        Charset.forName("UTF-8");
        String line = "";
        while ((line = br.readLine()) != null) {
                 String array[] = line.split(",");
                 if(Msg.equals(array[0])) { //������ �޴��� �Է°��� ������ ���ڿ���(=�ֹ��� �޴��� �޴��ǿ� ������ ����)
                    System.out.println();
                    System.out.println("---------���� �ֹ�----------");
                    System.out.println("�޴� : " + array[0]);
                    System.out.println("���� : " + array[1] + "��");
                    System.out.println("--------------------------");
                    System.out.print("������� �ֹ� : ");
                    Menu_Func.info[Menu_Func.n] = new Info_Menu();
                    Menu_Func.info[Menu_Func.n].setMenu(array[0]);
                    for(int i=0; i<(Menu_Func.n+1); i++)
                       System.out.print((i+1) + "." + Menu_Func.info[i].getMenu() + "  ");
                    System.out.println();
                    System.out.print("Send Client(���->�߰�,����): ");
                    Menu_Func.n++;
                 }
	}
	}
}
