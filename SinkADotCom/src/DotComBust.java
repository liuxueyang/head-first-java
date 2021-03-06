import java.util.ArrayList;

public class DotComBust {
	ArrayList<DotCom> dotComs = new ArrayList<DotCom>();
	
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	private GameHelper helper = new GameHelper();
	
	private void setUpGame() {
		for (int i = 0; i < 3; ++i) {
			DotCom a = new DotCom();
			a.setComName("com" + i);
			this.dotComList.add(a);
		}
		
		// place dot com and set their locations
		this.helper.placeDotCom(this.dotComList);
	}
	
	private void startPlaying() {
		while (!this.dotComList.isEmpty()) {
			this.numOfGuesses++;
			String guess = this.helper.getUserInput("Enter a guess");
			checkUserGuess(guess);
		}
		
		finishGame();
	}
	
	private void checkUserGuess(String guess) {
		String result = "";
		
		for (DotCom x : this.dotComList) {
			result = x.checkYourself(guess);
			
			if (result.equals("kill")) {
				this.dotComList.remove(x);
				break;
			}
			
			if (result.equals("hit")) {
				break;
			}
		}
	}
	
	private void finishGame() {
		System.out.println(	"All Coms are dead!");
		
		if (this.numOfGuesses <= 18) {
			System.out.println("It only took you " + 
									this.numOfGuesses + " guesses.");
		}
		else {
			System.out.println("Took you long enough. " + 
									this.numOfGuesses + " guesses.");
		}
	}

	public static void main(String[] args) {
		DotComBust dcb = new DotComBust();
		
		dcb.setUpGame();
		dcb.startPlaying();
	}
	
	
}
