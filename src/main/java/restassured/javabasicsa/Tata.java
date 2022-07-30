package restassured.javabasicsa;

public class Tata implements Vehicle{

	private String vehicleId;
	private String VehicleColor;
	public Tata(String vehicleId,String VehicleColor)
	{
		super();
		this.vehicleId=vehicleId;
		this.VehicleColor=VehicleColor;
		
	}
	
	@Override
	public String getvehicleDetails()  {
		// TODO Auto-generated method stub
		return "Vehicle ID :" + vehicleId + ", vehicle Color : " + VehicleColor + "" ;

		//return" tata VehicleId=" + VehicleId + ", vehiclecolor=" + vehiclecolor + "";
		
	}
	@Override
	public String  getVehicleId(){
		 return "VehicleId :" +vehicleId;
	}

















}