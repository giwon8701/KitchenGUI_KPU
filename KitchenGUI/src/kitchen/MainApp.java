package kitchen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import kitchen.model.DataList;
import kitchen.model.ReceiveOrder;
import kitchen.view.KitchenOverviewController;
import kitchen.view.NoOptionDialogController;
import kitchen.view.OrderAddDialogController;
import kitchen.view.OrderEditDialogController;
import kitchen.view.OrderOptionDialogController;
import kitchen.view.TempOptionDialogController;

public class MainApp extends Application {
	public static ObservableList<DataList> orderData = FXCollections.observableArrayList();
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane KitchenOverview;
    
    static Socket socket=null;
	static OutputStream os=null;
	static Writer writer=null;
	public static BufferedWriter bw=null;
	static InputStream is=null;
	static Reader reader=null;
	public static int ordernum = 1;
	
	public static BufferedReader br=null;
	
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("�ֹ� GUI");

        initRootLayout();
        showOrderOverview();
        
        primaryStage.setOnCloseRequest(event->System.exit(0));
    }
    
    public boolean showOrderEditDialog(DataList selectedOrder) {
    	try {
    		// fxml ������ �ε��ϰ� ���� ���ο� ���������� �����.
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/OrderEditDialog.fxml"));
    		
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		// ���̾�α� ���������� �����.
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("�޴� ����");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		
    		// order�� ��Ʈ�ѷ��� �����Ѵ�.
    		OrderEditDialogController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
    		controller.setOrder(selectedOrder);
    		// ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
    		dialogStage.showAndWait();
    		
    		return controller.isOkClicked();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public boolean showOrderAddDialog(DataList selectedOrder) {
    	
    	try {
    		// fxml ������ �ε��ϰ� ���� ���ο� ���������� �����.
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/OrderAddDialog.fxml"));
    		
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		// ���̾�α� ���������� �����.
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("�ֹ� �߰�");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		
    		// order�� ��Ʈ�ѷ��� �����Ѵ�.
    		OrderAddDialogController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
 //   		controller.setOrder(selectedOrder);
    		// ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
    		dialogStage.showAndWait();
    		return controller.isOkClicked();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public boolean showAllOptionDialog() {
    	try {
    		// fxml ������ �ε��ϰ� ���� ���ο� ���������� �����.
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/OrderOptionDialog.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		// ���̾�α� ���������� �����.
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("�ɼ� ����");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		
    		// order�� ��Ʈ�ѷ��� �����Ѵ�.
    		OrderOptionDialogController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
    		// ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
    		dialogStage.showAndWait();
    		OrderAddDialogController.Size = controller.getSize();
    		OrderAddDialogController.Temp = controller.getTemp();
    		OrderAddDialogController.Menunum = Integer.parseInt(controller.getMenunum());
    		OrderEditDialogController.Size = controller.getSize();
    		OrderEditDialogController.Temp = controller.getTemp();
    		OrderEditDialogController.Menunum = Integer.parseInt(controller.getMenunum());
    		
    		return controller.isOkClicked();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public boolean showTempOptionDialog() {
    	try {
    		
    		// fxml ������ �ε��ϰ� ���� ���ο� ���������� �����.
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/TempOptionDialog.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		// ���̾�α� ���������� �����.
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("�ɼ� ����");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		// order�� ��Ʈ�ѷ��� �����Ѵ�.
    		TempOptionDialogController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
    		// ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
    		dialogStage.showAndWait();
    		OrderAddDialogController.Size = controller.getSize();
    		OrderAddDialogController.Temp = controller.getTemp();
    		OrderAddDialogController.Menunum = Integer.parseInt(controller.getMenunum());
    		OrderEditDialogController.Size = controller.getSize();
    		OrderEditDialogController.Temp = controller.getTemp();
    		OrderEditDialogController.Menunum = Integer.parseInt(controller.getMenunum());
    		return controller.isOkClicked();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public boolean showNoOptionDialog() {
    	try {
    		
    		// fxml ������ �ε��ϰ� ���� ���ο� ���������� �����.
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("view/NoOptionDialog.fxml"));
    		AnchorPane page = (AnchorPane) loader.load();
    		
    		// ���̾�α� ���������� �����.
    		Stage dialogStage = new Stage();
    		dialogStage.setTitle("�ɼ� ����");
    		dialogStage.initModality(Modality.WINDOW_MODAL);
    		dialogStage.initOwner(primaryStage);
    		Scene scene = new Scene(page);
    		dialogStage.setScene(scene);
    		// order�� ��Ʈ�ѷ��� �����Ѵ�.
    		NoOptionDialogController controller = loader.getController();
    		controller.setDialogStage(dialogStage);
    		// ���̾�α׸� �����ְ� ����ڰ� ���� ������ ��ٸ���.
    		dialogStage.showAndWait();
    		OrderAddDialogController.Size = controller.getSize();
    		OrderAddDialogController.Temp = controller.getTemp();
    		OrderAddDialogController.Menunum = Integer.parseInt(controller.getMenunum());
    		OrderEditDialogController.Size = controller.getSize();
    		OrderEditDialogController.Temp = controller.getTemp();
    		OrderEditDialogController.Menunum = Integer.parseInt(controller.getMenunum());
    		return controller.isOkClicked();
    	} catch (IOException e) {
    		e.printStackTrace();
    		return false;
    	}
    }


    /**
     * ���� ���̾ƿ��� �ʱ�ȭ�Ѵ�.
     */
    public void initRootLayout() {
        try {
            // fxml ���Ͽ��� ���� ���̾ƿ��� �����´�.
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // ���� ���̾ƿ��� �����ϴ� scene�� �����ش�.
        	Scene scene = new Scene(rootLayout);
        	primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���� ���̾ƿ� �ȿ� ����ó ���(person overview)�� �����ش�.
     */
    public void showOrderOverview() {
        try {
            // ����ó ����� �����´�.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/KitchenOverview.fxml"));
            AnchorPane kitchenOverview = (AnchorPane) loader.load();

            // ����ó ����� ���� ���̾ƿ� ����� �����Ѵ�.
            rootLayout.setCenter(kitchenOverview);
            
            // ���� ���ø����̼��� ��Ʈ�ѷ��� �̿��� �� �ְ� �Ѵ�.
            KitchenOverviewController controller = loader.getController();
             controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ������
     */
    public MainApp() {}

    /**
     * ����ó�� ���� observable ����Ʈ�� ��ȯ�Ѵ�.
     * @return
     */
   public ObservableList<DataList> getDataList() {
        return orderData;
    }
    
    /**
     * ���� ���������� ��ȯ�Ѵ�.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
    	Receive recieve=null;
    	  
         try {
        	 InetAddress local = InetAddress.getLocalHost();
        	   String ip = local.getHostAddress();
               socket=new Socket();
               socket.connect(new InetSocketAddress(ip,9001));
//             socket.connect(new InetSocketAddress("192.168.1.100",9001));
			os=socket.getOutputStream();
			 System.out.println("Server ���� ����");
	         os=socket.getOutputStream();
	         writer=new OutputStreamWriter(os);
	         recieve=new Receive(socket);
	    	 recieve.start();
	         bw=new BufferedWriter(writer);
	         bw.write("0001"+"\n");
	         bw.flush();
		} catch (IOException e) {System.out.println(e.getMessage());}
        launch(args);
    }
    public static class Receive extends Thread{
    	public static ArrayList<DataList> dataarray=new ArrayList<DataList>();
    	ReceiveOrder receiveorder=new ReceiveOrder();
		Socket socket=null;
		InputStream is=null;
		 Reader reader=null;
		 BufferedReader br=null;
		 String Msg=null;

		 public Receive(Socket socket)
		 {
			 this.socket=socket;
			 try{
				 is=socket.getInputStream();
					reader=new InputStreamReader(is);
					br=new BufferedReader(reader);
			 }catch(Exception e){System.out.println(e.getMessage());}
		 }
		 public void run()
		 {
			 try{
			 while(true)
			 {
				Msg=br.readLine();
				System.out.println("Receive Server: "+ Msg);
			 	dataarray.add(receiveorder.receive_data(Msg));
			 	orderData.add(dataarray.get(dataarray.size()-1));
			 }
		 }catch(Exception e){}
	}
	}
    
}