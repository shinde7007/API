package restassured.pra;

public class Demo  implements Interface {

	
	private String FotballPlayer;
	private String CricketPlayer;
	public Demo(String FotballPlayer,String CricketPlayer) {
		super();
	this.FotballPlayer=FotballPlayer;
	this.CricketPlayer=CricketPlayer;

	}
	
	
	@Override
	public String GetFotballPlayer() {
		// TODO Auto-generated method stub
		return "footballplayer= " +FotballPlayer  ;

	}
	@Override
	public String GetCricketPlayer() {
		// TODO Auto-generated method stub
		return "Cricketplayer=" + CricketPlayer + ", footballplayer=" + FotballPlayer + "" ;

	}







}
