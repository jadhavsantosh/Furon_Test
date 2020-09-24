package com.test.utlis;

import java.util.ArrayList;

import Naveen_util.Xls_Reader;



public class TestUtility {
	
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader(
					"C:\\Users\\pratmesh\\eclipse-workspace\\new\\Amazon_Account\\src\\test\\java\\com\\testdata\\Details.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int rownum=2;rownum<=reader.getRowCount("sheet1");rownum++) 
		{
			String Name=reader.getCellData("sheet1", "Name", rownum);
			String Mobile=reader.getCellData("sheet1", "Mobile", rownum);
			String Email=reader.getCellData("sheet1", "Email", rownum);
			String Password=reader.getCellData("sheet1", "Password", rownum);
			
			Object ob[]= {Name,Mobile,Email,Password};
			mydata.add(ob);
		
		
	}
		return mydata;
	}
		
	}
	



