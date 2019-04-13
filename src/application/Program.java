package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		Seller sell = new Seller(10, "João", "joao@teste.com", new Date(), 3000.10, obj);
		
		System.out.println(sell);

	}

}
