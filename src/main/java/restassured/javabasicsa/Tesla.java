package restassured.javabasicsa;

public class Tesla implements Vehicle{
private static String vehicleId;
private static String VehicleColor;

	

public Tesla (String vehicleId,String vehicleColor) {
	super();
this.vehicleId=vehicleId;
 this.VehicleColor=VehicleColor;
}

@Override
public String getvehicleDetails() {
return "Vehicle ID :" + vehicleId + ", vehicle Color : " + VehicleColor ;
}

@Override
public String getVehicleId(){
	return "Vehicle ID :" + vehicleId ;
}
}
