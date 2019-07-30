package model.dao;

import java.util.List;

import model.entidades.Departamento;
import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Departamento> findAll();
}
