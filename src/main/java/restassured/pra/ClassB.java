package restassured.pra;

public class ClassB implements Interface{

	
	private String FotballPlayer;
	private String CricketPlayer;
	public ClassB(String FotballPlayer,String CricketPlayer) {
		super();
	this.FotballPlayer=FotballPlayer;
	this.CricketPlayer=CricketPlayer;
	}
	
	@Override
	public String GetFotballPlayer() {
		// TODO Auto-generated method stub
		return "footballplayer=" + FotballPlayer  ;

	}
	@Override
	public String GetCricketPlayer() {
	
		return "Cricketplayer=" + CricketPlayer + ", footballplayer=" + FotballPlayer + "" ;

	}







}
