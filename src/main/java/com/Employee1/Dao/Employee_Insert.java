package com.Employee1.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Employee1.bean.Employee;

public class Employee_Insert {
     public static Connection getConnection()throws Exception{
    	 Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","9415");
         return con;
     }
     public static int insert(Employee s) throws Exception {
    	 Connection con=getConnection();
    	 String sql="insert into Student(id,name,email,phone,address) values (?,?,?,?,?)";
    	 PreparedStatement ps=con.prepareStatement(sql);
    	 ps.setInt(1, s.getId());
    	 ps.setString(2, s.getName());
    	 ps.setString(3, s.getEmail());
    	 ps.setString(4, s.getContact());
    	 ps.setString(5, s.getAddress());
    	 int status=ps.executeUpdate();
    	 return status;
    	 
     }
     public static List<Employee> fetch()throws Exception{
    	 Connection con=getConnection();
    	 List<Employee> al=new ArrayList();
    	 String sql="select * from Student";
    	 PreparedStatement ps=con.prepareStatement(sql);
    	 ResultSet rs=ps.executeQuery();
    	 while(rs.next()) {
    		 Employee s=new Employee();
    		 s.setId(rs.getInt(1));
    		 s.setName(rs.getString(2));
    		 s.setEmail(rs.getString(3));
    		 s.setContact(rs.getString(4));
    		 s.setAddress(rs.getString(5));
    		 
    		al.add(s);
    	 }
		return al;
     }
     public static int delete(int id)throws Exception {
    	 Connection con=getConnection();
    	 int status=0;
    	 String sql="delete from Student where id=?";
    	 PreparedStatement ps=con.prepareStatement(sql);
    	 ps.setInt(1, id);
    	 status=ps.executeUpdate();
    	 return status;
     }
     public static Employee getbyid(int id)throws Exception {
    	 Connection con=getConnection();
    	 Employee ob=new Employee();
    	 String sql="select * from Student where id=?";
    	 PreparedStatement ps=con.prepareStatement(sql);
    	 ps.setInt(1,id);
    	 ResultSet rs=ps.executeQuery();
    	 while(rs.next()) {
    		 ob.setId(rs.getInt(1));
    		 ob.setName(rs.getString(2));
    		 ob.setEmail(rs.getString(3));
    		 ob.setContact(rs.getString(4));
    		 ob.setAddress(rs.getString(5));
    	 }
    	 return ob;
     }
     public static int update(Employee s) {
    	 int status=0;
    	 try {
			Connection con=getConnection();
			String sql="update Student set name=?,email=?,phone=?,address=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getContact());
			ps.setString(4,s.getAddress());
			ps.setInt(5, s.getId());
			status=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return status;
    	 
     }
}
