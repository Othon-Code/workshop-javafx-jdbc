package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entidades.Departamento;

public class DepartamentoListController implements Initializable {
	@FXML
	private TableView<Departamento> tableviewDept;
	@FXML
	private TableColumn<Departamento, Integer> tablecolumnId;

	@FXML
	private TableColumn<Departamento, String> tablecolumnNome;

	@FXML
	private Button btNovo;

	@FXML
	public void onBtNovoAcction() {// implementação do botao btNovo
		System.out.println("onBtNovoAction");

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

}
