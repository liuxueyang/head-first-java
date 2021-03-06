
public class SimpleDotComGame {
	public static void main(String[] args) {
		SimpleDotCom sdc = new SimpleDotCom();
		int numOfGuesses = 0;
		GameHelper gi = new GameHelper();
		int startLocation = (int) (Math.random() * 5);
		int[] locations = {startLocation, startLocation + 1, startLocation + 2};

		sdc.setLocations(locations);

		String result = "miss";

		while (!result.equals("kill")) {
			String guess = gi.getUserInput("Enter a number: ");
			numOfGuesses++;
			
			result = sdc.checkYourself(guess);
			System.out.println(result);
		}
		
		System.out.println("You took " + numOfGuesses + " guesses.");
	}
}
