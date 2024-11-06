package com.management.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.management.entities.StudentManagement;

public class StudentManagementDaoImpl extends Dao implements StudentManagementDao {
	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindById;
	private PreparedStatement stmtSave;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtDeleteById;

	public StudentManagementDaoImpl() throws Exception{
		String sqlFindAll = "SELECT * FROM studentmanagement";
		stmtFindAll = con.prepareStatement(sqlFindAll);
		String sqlFindById = "SELECT * FROM studentmanagement WHERE id = ?";
		stmtFindById = con.prepareStatement(sqlFindById);
		String sqlSave = "INSERT INTO studentmanagement(id , first_name, last_name, email , age) VALUES(?, ?, ?,?,?)";
		stmtSave = con.prepareStatement(sqlSave);
		String sqlUpdate = "UPDATE studentmanagement SET first_name=?, last_name=?, email=? , age = ? WHERE id=?";
		stmtUpdate = con.prepareStatement(sqlUpdate);
		String sqlDeleteById = "DELETE FROM studentmanagement WHERE id=?";
		stmtDeleteById = con.prepareStatement(sqlDeleteById);
	}
	
	public void close() throws Exception{
		stmtDeleteById.close();
		stmtUpdate.close();
		stmtSave.close();
		stmtFindById.close();
		stmtFindAll.close();
		super.close();
	}
	
	public List<StudentManagement> findAll() throws Exception {
		List<StudentManagement> list = new ArrayList<StudentManagement>();
		try(ResultSet rs = stmtFindAll.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				StudentManagement s = new StudentManagement(id, first_name,last_name,email,age);
				list.add(s);
			}
		} // rs.close();
		return list;
	}
	
	public StudentManagement findById(int id) throws Exception {
		stmtFindById.setInt(1, id);
		try(ResultSet rs = stmtFindById.executeQuery()) {
			if(rs.next()) {
				id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				StudentManagement s = new StudentManagement(id, first_name,last_name,email,age);
				return s;
			}
		} // rs.close();		
		return null;
	}
	
	public int save(StudentManagement s) throws Exception {
		stmtSave.setInt(1, s.getId());
		stmtSave.setString(2, s.getFirst_name());
		stmtSave.setString(3, s.getLast_name());
		stmtSave.setString(4, s.getEmail());
		stmtSave.setInt(5, s.getAge());
		int count = stmtSave.executeUpdate();
		return count;
	}
	
	public int update(StudentManagement s) throws Exception {
		
		stmtUpdate.setString(1, s.getFirst_name());
		stmtUpdate.setString(2, s.getLast_name());
		stmtUpdate.setString(3, s.getEmail());
		stmtUpdate.setInt(4, s.getAge());
		stmtUpdate.setInt(5, s.getId());
		int count = stmtUpdate.executeUpdate();
		return count;
	}
	
	public int deleteById(int id) throws Exception {
		stmtDeleteById.setInt(1, id);
		int count = stmtDeleteById.executeUpdate();
		return count;
	}
}