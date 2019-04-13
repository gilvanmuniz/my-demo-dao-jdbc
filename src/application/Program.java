package application;

import java.util.Date;

import model.dao.FactoryDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		Seller sell = new Seller(10, "João", "joao@teste.com", new Date(), 3000.10, obj);
		
		SellerDao sellerDao = FactoryDao.createSellerDao();
		
		System.out.println(sell);

	}

}
