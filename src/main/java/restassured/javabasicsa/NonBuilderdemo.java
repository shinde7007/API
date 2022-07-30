package restassured.javabasicsa;

class builde {
	
	    private String imeiID;
	    private String storageCapacity;
	    private String ChipDetails;
	    
	    public void addimeId(String imeiId)
	    {
	        this.imeiID=imeiId;
	        System.out.println("Stetting IMEI ID:" +imeiId);
	       // return this;
	        
	    }
	    public void addStorageCapacity(String storageCapacity)
	    {
	        this.storageCapacity=storageCapacity ;
	        System.out.println("Stetting chip Details:"+storageCapacity);
	       // return this;
	        
	    }
	    public void addchipDetails(String addchipDetails)
	    {
	        this.ChipDetails=addchipDetails ;
	        System.out.println("Setting chip Details:"+ChipDetails);
	       // return this;
	        
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

	public class NonBuilderdemo
	{
	    public static void main(String args[])
	    {
	     /*   builder builderobj=builder.build()
	          System.out.println(builderobj);  
	        builderobj	.addchipDetails("Apple")
	                .addimeId("9823456")
	                .addStorageCapacity("256");*/
	        builder builderobjw= new builder();
            System.out.println(builderobjw);
            builderobjw.addchipDetails("Apdafple");
            builderobjw.addimeId("982345sc6");
            builderobjw.addStorageCapacity("25zs6");
                    
        System.out.println(builderobjw);
                        
	    //System.out.println(builderobjw);
	                
	    }
}
