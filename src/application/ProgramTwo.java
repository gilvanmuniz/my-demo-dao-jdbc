package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramTwo {

	public static void main(String[] args) {
		/*
		System.out.println(" ==== INSERIR ====");
		Department dep = new Department(null, "DepartJovam");
		DepartmentDao depDao = DaoFactory.createDepartmentDao();	
		depDao.insert(dep);
		
		System.out.println("Insert Feito com id = " + dep.getId());
		*/
		System.out.println(" ==== FIND_by_ID ====");
		DepartmentDao depDao2 = DaoFactory.createDepartmentDao();
		Department dep2 = new Department();
		dep2 = depDao2.findById(3);
		System.out.println(dep2);
		
		
		System.out.println(" ==== FIND_ALL ====");
		List<Department> list = new ArrayList<Department>();
		list = depDao2.findAll();
		System.out.println(list);
		
		System.out.println(" ==== UPDATE ====");
		Department dep = new Department();
		dep = depDao2.findById(3);
		dep.setName("Fashion");
		depDao2.update(dep);
		System.out.println(dep);
		
		System.out.println(" ==== DELETE ====");
		depDao2.deleteById(7);
		System.out.println("DELETE!");
		
	}//FIM DO MAIN

}
