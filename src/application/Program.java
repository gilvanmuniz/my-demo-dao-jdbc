package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//Department obj = new Department(1, "Books");
		//Seller sell = new Seller(10, "Jo�o", "joao@teste.com", new Date(), 3000.10, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println(" ==== TESTE N� 01 findById ====");
		Seller seller = sellerDao.findById(5);
		
		System.out.println(seller);

	}

}
