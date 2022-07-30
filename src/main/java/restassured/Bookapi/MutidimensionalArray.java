package restassured.Bookapi;

public class MutidimensionalArray {

	public static void main(String[] args) {
		
		String[] genreArray = {"Education", "Personal Development", "Fiction"};
		String[] authorArray = {"ABC", "DEF", "GHI"};
		
		System.out.println(authorArray[1]);
		System.out.println(genreArray[2]);
		
		String[][] arrayOfArray = {authorArray, genreArray};
		//[0] -> authorArray [0]ABC [1]DEF [2]GHI
		//[1] -> genreArray
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Author : " + arrayOfArray[0][i] + " has written some book with genre : " + 
							arrayOfArray[1][i]);
		}
	}

}
