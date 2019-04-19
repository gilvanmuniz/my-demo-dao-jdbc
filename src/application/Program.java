package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//Department obj = new Department(1, "Books");
		//Seller sell = new Seller(10, "João", "joao@teste.com", new Date(), 3000.10, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println(" ==== TESTE Nº 01 findById ==== ");
		Seller seller = sellerDao.findById(5);
		
		System.out.println(seller);
		
		System.out.println("\n ==== TESTE Nº 02 findById ====");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj+"\n");
		}
		
		System.out.println("\n ==== TESTE Nº 03 findByAll ====");		
		 list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj+"\n");
		}
		

	}//fim do main

}
