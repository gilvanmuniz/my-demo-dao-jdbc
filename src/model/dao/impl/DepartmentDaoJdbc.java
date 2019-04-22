package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJdbc implements DepartmentDao {
	
	private Connection conn;
	
    public DepartmentDaoJdbc(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		
		PreparedStatement stat = null;
		
		try {
			
			String sql = "INSERT INTO department " +
			             "(Name) " +
			             "VALUES(?)";
			
			stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stat.setString(1, obj.getName());
			
			int rowsAffect = stat.executeUpdate();
			
			if(rowsAffect > 0) {
				ResultSet rs = stat.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected ");
			}
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(stat);
		}
		
	}//fim do Insert

	@Override
	public void update(Department obj) {
				
		PreparedStatement prepare = null;
		
		try {
		String sql = "UPDATE department " +
		             "SET Name = ? " +
		             "WHERE id = ?";
		
			prepare = conn.prepareStatement(sql);
			prepare.setString(1, obj.getName());
			prepare.setInt(2, obj.getId());
			
			prepare.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(prepare);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		
		PreparedStatement st = null;
		
		try {
			String sql = "DELETE FROM Department "+
		                  "WHERE Id = ?";
			
			st = conn.prepareStatement(sql);			
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Department findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM department " +
						 "WHERE Id = ?"	;
		
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if(rs.next()) {
				Department department = new Department(rs.getInt("Id"), rs.getString("Name"));
				return department;
			}
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Department> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			String sql = "SELECT * FROM Department";
			List<Department> list = new ArrayList<Department>();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				Department obj = new Department();				
				list.add(obj);
			}
			return list;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
	}

}
