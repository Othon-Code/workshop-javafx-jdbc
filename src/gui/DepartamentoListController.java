package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	public void onBtNovoAcction() {// implementação do botao btNovo
		System.out.println("onBtNovoAction");

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

}
