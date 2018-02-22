
public class SimpleDotCom {
	private int[] locations;
	private boolean[] destroyedLocations;
	private int guessedCnt = 0;
	
	String checkYourself(String guess) throws NumberFormatException {
		String result = "miss";
		int guessNum;
		
		try {
			guessNum = Integer.parseInt(guess);
			
			for (int i = 0; i < locations.length; ++i) {
				if (locations[i] == guessNum && !destroyedLocations[i]) {
					guessedCnt++;
					result = "hit";
					destroyedLocations[i] = true;

					break;
				}
			}
			
			if (guessedCnt == locations.length) {
				result = "kill";
			}
		}
		catch (NumberFormatException e) {
			System.out.println("guess is NOT a number!");
		}
		
		System.out.println("result = " + result);
		return result;
	}
	
	void setLocations(int[] x) {
		locations = x;
		
		for (int i = 0; i < destroyedLocations.length; ++i) {
			destroyedLocations[i] = false;
		}
	}
}
