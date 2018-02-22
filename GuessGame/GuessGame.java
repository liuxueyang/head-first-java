/*
 * Date: Mon Feb 19 19:00:34 CST 2018
 */

public class GuessGame {
    Player[] players;
    int number;

    void startGame() {
	players = new Player[3];
	number = (int) (Math.random() * 10);

	for (int i = 0; i < players.length; ++i) {
	    players[i] = new Player();
	}

	System.out.println("Target number is: " + number);

	boolean mark = false;

	while (true) {
	    System.out.println("\n=======================");

	    for (int i = 0; i < players.length; ++i) {
		players[i].guess();
		mark = mark || players[i].win(number);
		System.out.println("Player " + (i + 1) + " guesses " +
				   players[i].number);
	    }

	    if (mark) {
		System.out.println("Someone win the game!");

		for (int i = 0; i < players.length; ++i) {
		    System.out.print("Player " + (i + 1) + " ");

		    if (players[i].win(number)) {
			System.out.println("wins!");
		    }
		    else {
			System.out.println("DOES NOT win!");
		    }
		}

		break;
	    }
	    else {
		System.out.println("Next Game Loop.");
	    }
	}
    }
}
