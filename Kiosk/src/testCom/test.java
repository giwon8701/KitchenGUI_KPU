package testCom;

public class test {
	public static void main(String arg[])
	{
		String dd=null;
		String asd="�Ƹ޸�ī��(R)(ICE)*2//ī���(L)(HOT)*3";
		String temp[]=asd.split("//");
		String menu=temp[0];
		if(menu.contains("(R)"))
		{
			int a=menu.indexOf("(R)");
			dd=menu.substring(a+1,a+2);
			
			System.out.println(dd);
		}
		
	}

}
