import java.util.ArrayList;

public class DotCom {
	private ArrayList<String> locations;
	private String comName;
	
	String checkYourself(String guess) {
		String result = "miss";
		int index = this.locations.indexOf(guess);
		
		if (index >= 0) {
			result = "hit";
			this.locations.remove(index);
		}
		
		if (this.locations.isEmpty()) {
			result = "kill";
		}

		System.out.println("result = " + result);

		return result;
	}

	public void setLocations(ArrayList<String> x) {
		locations = x;
	}

	public String getComName() {
		return this.comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
}
