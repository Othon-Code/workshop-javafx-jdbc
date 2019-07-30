package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entidades.Departamento;

public class DepartmentService {

	public List<Departamento> findAll() {
//mackar os dados----retornar dados de mentira--nao sao os dados do banco de dados realmente
		List<Departamento> list =new ArrayList<>();
		
		list.add(new Departamento(1, "Books"));
		list.add(new Departamento(2, "Computers"));
		list.add(new Departamento(3, "Eletronics"));
		return list;
		
		
	}
}
