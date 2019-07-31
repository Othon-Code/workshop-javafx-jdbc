package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entidades.Departamento;

public class DepartmentFormController implements Initializable {
	private Departamento entity;

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
	
	public void setDepartamento(Departamento entity) {
		this.entity = entity;
	}
	
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
		Constraints.setTextFieldInteger(txtId);//assim só aceita digitos inteiros
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}
	public void updateForm() {
		if(entity ==null) {
			throw new IllegalStateException("Entidade estava nula !!");
			
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtNome.setText(entity.getNome());
		
	}
	

}
