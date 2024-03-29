package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import gui.listeners.DataChangeListener;
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
import model.exceptions.ValidationException;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {
	private Departamento entity;
	
	private DepartmentService service;
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

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
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
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
			notifyDataChangeListeners();
			Utils.stageCorrente(event).close();
		}
		catch(ValidationException e) {
			setErrorMessage(e.getErrors());//passa uma colecao de erros(getErrors)
		}
		catch(DbException e) {
			Alerts.showAlert("Erro salvando Obj", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private void notifyDataChangeListeners() {
		for(DataChangeListener listener : dataChangeListeners) {
			listener.ondataChanged();
			
		}
		
	}
	private Departamento getFormData() {
		Departamento obj = new Departamento();
		
		ValidationException exception = new ValidationException("Validacao de erro");
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		
		if(txtNome.getText() == null || txtNome.getText().trim().equals("")) {
			exception.addError("nome", "O campo n�o pode ser vazio");
		}
		obj.setName(txtNome.getText());
		if(exception.getErrors().size() >0 ) {
			throw exception;
		}
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
		Constraints.setTextFieldInteger(txtId);//assim s� aceita digitos inteiros
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}
	public void updateForm() {
		if(entity ==null) {
			throw new IllegalStateException("Entidade estava nula !!");
			
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtNome.setText(entity.getNome());
		
	}
	private void setErrorMessage(Map<String, String> errors) {
	  Set<String> fields = errors.keySet();
	  
	  if(fields.contains("nome")) {
		  labelErroNome.setText(errors.get("nome"));
	  }
	  
	
  }
}
