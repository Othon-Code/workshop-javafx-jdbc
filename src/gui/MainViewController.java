package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemVend;
	@FXML
	private MenuItem menuItemDepart;
	@FXML
	private MenuItem menuItemSobre;
	
	@FXML
	public void onMenuItemVendAction() {
		System.out.println("onMenuItemVendAction");
		
	}
	
	
	@FXML
	public void onMenuItemDepartAction() {
		System.out.println("onMenuItemDepartAction");
		
	}
	
	@FXML
	public void onMenuItemSobreAction() {
		System.out.println("onMenuItemSobreAction");
		
	}
	
	
	
	
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
		
	}

}
