package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entidades.Departamento;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {
	private Departamento entity;
	
	private DepartmentService service;

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
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@FXML
	public void onBtSalvarAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entidade estava nula!!");
		}
		if(service == null) {
			throw new IllegalStateException("Service estava nula!!");
		}
		try {
			entity = getFormData();
			service.salvarOuUpdate(entity);
			Utils.stageCorrente(event).close();
		}
		catch(DbException e) {
			Alerts.showAlert("Erro salvando Obj", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private Departamento getFormData() {
		Departamento obj = new Departamento();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtNome.getText());
		
		return obj;
	}
	@FXML
	public void onBtCancelarAction(ActionEvent event) {
		Utils.stageCorrente(event).close();
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
