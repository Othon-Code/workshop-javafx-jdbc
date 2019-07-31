package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entidades.Departamento;
import model.services.DepartmentService;

public class DepartamentoListController implements Initializable {
	
	private DepartmentService service;
	
	
	@FXML
	private TableView<Departamento> tableviewDept;
	@FXML
	private TableColumn<Departamento, Integer> tablecolumnId;

	@FXML
	private TableColumn<Departamento, String> tablecolumnNome;

	@FXML
	private Button btNovo;
	
	private ObservableList<Departamento> obsList;

	@FXML
	public void onBtNovoAcction(ActionEvent event) {// implementação do botao btNovo
		Departamento obj = new Departamento();
		Stage parentStage = Utils.stageCorrente(event);
		createDialogForm(obj, "/gui/DepartmentForm.fxml", parentStage);
	}

	public void setDepartamentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		inicializeNodes();

	}

	private void inicializeNodes() {
		tablecolumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tablecolumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		Stage stage = (Stage) Main.getmainScene().getWindow();
		tableviewDept.prefHeightProperty().bind(stage.heightProperty());

	}
	public void updatetableview() {
		if(service == null) {
			throw new IllegalStateException("O servive estava nulo !!!");
		}
		
		List<Departamento> list = service.findAll();
		
		obsList = FXCollections.observableArrayList(list);
		tableviewDept.setItems(obsList);
		
	}
	private void createDialogForm(Departamento obj, String absoluteNome, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteNome));
			Pane pane = loader.load();
			
			DepartmentFormController controller = loader.getController();
			controller.setDepartamento(obj);
			controller.updateForm();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entre com os dados do Departamento");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "ERRO Loading View", e.getMessage(), AlertType.ERROR);
		}
	}

}
