package restassured.javabasicsa;

import static restassured.javabasicsa.object.*;

public class VehicleExecution {
public static void main(String[] args) {
//object.	getTeslaObject().getvehicleDetails();
//object.	getTataObject().getvehicleDetails();

	
Tesla ts= (Tesla)getTeslaObject();
Tata ta= (Tata)getTataObject();

System.out.println(ts.getvehicleDetails());
System.out.println(ta.getVehicleId());







}
}
