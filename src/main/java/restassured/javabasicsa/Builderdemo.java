package restassured.javabasicsa;

class builder {
	
	    private String imeiID;
	    private String storageCapacity;
	    private String ChipDetails;
	    
	    public builder addimeId(String imeiId)
	    {
	        this.imeiID=imeiId;
	        System.out.println("Stetting IMEI ID:" +imeiId);
	        return this;
	        
	    }
	    public builder addStorageCapacity(String storageCapacity)
	    {
	        this.storageCapacity=storageCapacity ;
	        System.out.println("Stetting chip Details:"+storageCapacity);
	        return this;
	        
	    }
	    public builder addchipDetails(String addchipDetails)
	    {
	        this.ChipDetails=addchipDetails ;
	        System.out.println("Setting chip Details:"+ChipDetails);
	        return this;
	        
	    }

	    @Override
	    public String toString() {
	        return "builder [imeiID=" + imeiID + ", storageCapacity=" + storageCapacity + ", ChipDetails=" + ChipDetails
	                + "]";
	    }
	    public  static builder build() {
	        // TODO Auto-generated method stub
	        return new builder();
	    }
	}

	public class Builderdemo
	{
	    public static void main(String args[])
	    {
	        builder builderobj=builder.build()
	                .addchipDetails("Apple")
	                .addimeId("9823456")
	                .addStorageCapacity("256");
	                
	    System.out.println(builderobj);
	                
	    }
}
