package com.management;

import java.util.List;
import java.util.Scanner;

import com.management.daos.StudentManagementDao;
import com.management.daos.StudentManagementDaoImpl;
import com.management.entities.StudentManagement;

public class JdbcTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try (StudentManagementDao studentDao = new StudentManagementDaoImpl()) {
			List<StudentManagement> list = studentDao.findAll();
			list.forEach(System.out::println);
		} // studentDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
		
//----------------------------------------------------------------------	
		
		try(StudentManagementDao studentDao = new StudentManagementDaoImpl()) {
			System.out.print("Enter Candidate Id to find: ");
			int id = sc.nextInt();
			StudentManagement c = studentDao.findById(id);
			if(c != null)
				System.out.println("Found " + c);
			else
				System.out.println("Student Not Found.");
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}

//----------------------------------------------------------------------	
		
		try(StudentManagementDao studentDao = new StudentManagementDaoImpl()) {
			System.out.print("Enter Id: ");
			int id = sc.nextInt();
			System.out.print("Enter First Name: ");
			String first_name = sc.next();
			System.out.print("Enter Last Name: ");
			String last_name = sc.next();
			System.out.print("Enter Email: ");
			String email = sc.next();
			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			StudentManagement c = new StudentManagement(id, first_name, last_name, email , age);
			int cnt = studentDao.save(c);
			System.out.println("Students Saved: " + cnt);
		} // candDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}	

//----------------------------------------------------------------------			
		
		try(StudentManagementDao studentDao = new StudentManagementDaoImpl()) {
			System.out.print("Enter Id (to update): ");
			int id = sc.nextInt();
			System.out.print("Enter First Name: ");
			String first_name = sc.next();
			System.out.print("Enter Last Name: ");
			String last_name = sc.next();
			System.out.print("Enter Email: ");
			String email = sc.next();
			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			StudentManagement s = new StudentManagement(id , first_name, last_name, email , age);
			int cnt = studentDao.update(s);
			System.out.println("Student Updated: " + cnt);
		} // studentDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	
//----------------------------------------------------------------------	
		
		try(StudentManagementDao studentDao = new StudentManagementDaoImpl()) {
			System.out.print("Enter Id (to delete): ");
			int id = sc.nextInt();
			int cnt = studentDao.deleteById(id);
			System.out.println("Student Deleted: " + cnt);
		} // studentDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}

//----------------------------------------------------------------------			
		

		
}
}