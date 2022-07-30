package restassured.ReadDataFromExcel;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
public static void main(String[] args) throws IOException {
	
	ReadAllData d=new ReadAllData();
	ArrayList data=d.getdata("bookOne");
	
	System.out.println(data.get(0));
	System.out.println(data.get(1));
	System.out.println(data.get(2));
	System.out.println(data.get(3));
	System.out.println(data.get(4));

//System.out.println(data.);
}
}