/*
 * Date: Tue Feb 20 18:13:57 CST 2018
 */


public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		int[] locations = {3, 4, 5};
		SimpleDotCom a = new SimpleDotCom();

		a.setLocations(locations);

		a.checkYourself("3");
		a.checkYourself("10");
		a.checkYourself("a");
	}
}
