/*
 * Date: Mon Feb 19 18:58:24 CST 2018
 */

public class Player {
    int number;

    void guess() {
	number = (int) (Math.random() * 10);
    }

    boolean win(int n) {
	return n == number;
    }
}
