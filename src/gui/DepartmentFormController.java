package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private Label labelErroNome;
	
	@FXML
	private Button btsalvar;
	
	@FXML
	private Button btCAncelar;
	
	@FXML
	public void onBtSalvarAction() {
		System.out.println("onBtSalvarAction");
	}
	
	@FXML
	public void onBtCancelarAction() {
		System.out.println("onBtCancelarAction");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializarNodes();
		
	}
	
	private void inicializarNodes() {
		Constraints.setTextFieldInteger(txtId);//assim s� aceita digitos inteiros
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}

}
