package restassured.pra;

import static restassured.javabasicsa.object.getTataObject;
import static restassured.javabasicsa.object.getTeslaObject;
import static restassured.pra.Object.*;

import restassured.javabasicsa.Tata;
import restassured.javabasicsa.Tesla;
public class Execute {

	public static void main(String[] args) {
		
		
		
		Demo ca =(Demo) GetDemo();
	    ClassB cb =(ClassB) GetClassB() ;
				
		
		System.out.println(ca.GetCricketPlayer());
		// System.out.println(ca.GetFotballPlayer());
	//	System.out.println(cb.GetFotballPlayer());
		System.out.println(cb.GetCricketPlayer());
		
		
		
	}
		
	}
	
	
	/*	
Tesla ts= (Tesla)getTeslaObject();
Tata ta= (Tata)getTataObject();

System.out.println(ts.getvehicleDetails());
System.out.println(ta.getVehicleId());*/



	
	
	
	
	
	
	
	
	
	

