package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Run {
	@DataProvider (name="data")
   public Object[][] getdata()
   {
	   return  new Object[][]
			   {
		   {"data","data1"},
		   {"data2","data2"},
		   
		   };
   }
	@Test (dataProvider="data")
	public static void read(String s1, String s2) 
	{
		System.out.println(s1+s2);
	}
	
	

}
