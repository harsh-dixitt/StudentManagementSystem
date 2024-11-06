package com.management.daos;

import java.sql.Connection;

import com.management.utils.DbUtil;

public abstract class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = DbUtil.getConnection();
	}
	
	public void close() throws Exception{
		con.close();
	}

	

}