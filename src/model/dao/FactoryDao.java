package model.dao;

import model.dao.impl.SellerDaoJdbc;

public class FactoryDao {

	public static SellerDao createSellerDao() {
		return new SellerDaoJdbc();
	}
	 
}
