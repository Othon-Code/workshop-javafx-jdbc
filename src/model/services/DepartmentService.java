package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entidades.Departamento;

public class DepartmentService {
	private DepartmentDao dao = DaoFactory.createDepartmentDao();

	public List<Departamento> findAll() {
//mackar os dados----retornar dados de mentira--nao sao os dados do banco de dados realmente
				return dao.findAll();
		
		
	}
}
