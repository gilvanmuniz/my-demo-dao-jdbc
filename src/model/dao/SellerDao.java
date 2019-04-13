package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
  
	void update(Seller obj);
	void insert(Seller obj);
	void debeteById(Integer id);
	Seller findById(Integer id);
	List<Seller>findAll(); 
}
