package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

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
		loadView("/gui/DepartmentList.fxml", (DepartamentoListController controller) -> {
			controller.setDepartamentService(new DepartmentService());
			controller.updatetableview();
		});

	}

	@FXML
	public void onMenuItemSobreAction() {
		loadView("/gui/About.fxml", x -> {});

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	}

	private synchronized <T> void loadView(String nomeAbsoluto, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
			VBox novoVBox = loader.load();
			
			Scene mainScene = Main.getmainScene();
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(novoVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
			
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro ao carregar a view", e.getMessage(), AlertType.ERROR);
		}

	}
	
	
	
}