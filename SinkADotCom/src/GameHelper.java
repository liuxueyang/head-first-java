import java.util.ArrayList;

public class GameHelper {
	private int gridSizeX = 7;
	private int gridSizeY = 7;
	private boolean[] used = new boolean[49];
	
	public void placeDotCom(ArrayList<DotCom> dotComList) {
		for (int i = 0; i < dotComList.size(); ++i) {
			int x1, x2, x3;
			boolean mark = false;
			
			do {
				// center position [1, 5]
				int cpx = (int) (Math.random() * 5 + 1);
				int cpy = (int) (Math.random() * 5 + 1);
				int cp = cpx * gridSizeY + cpy;
				
				// direction [0, 1], 0 is horizontal, 1 is vertical
				int d = (int) (Math.random() * 2);
				
				if (d == 0) {
					// Horizontal
					x1 = cp - 1;
					x2 = cp;
					x3 = cp + 1;
				}
				else {
					// vertical
					x1 = cp - this.gridSizeY;
					x2 = cp;
					x3 = cp + this.gridSizeY;
				}
				
				if (!canHold()) {
					break;
				}
				
				mark = this.used[x1] || this.used[x2] || this.used[x3]; 
			} while (mark);
			
			if (mark) {
				System.out.println("can not place dot coms on the board" + 
										" anymore.");
			}
			else {
				DotCom a = dotComList.get(i);
				addLocationToDotCom(a, x1, x2, x3);
				this.used[x1] = this.used[x2] = this.used[x3] = true;
			}
		}
		
		return;
	}
	
	private void addLocationToDotCom(DotCom dc, int x1, int x2, int x3) {
		ArrayList<String> locations = new ArrayList<String>();
		
		locations.add(convertIntToLocation(x1));
		locations.add(convertIntToLocation(x2));
		locations.add(convertIntToLocation(x3));
		
		dc.setLocations(locations);
	}

	private String convertIntToLocation(int x) {
		int j = x % this.gridSizeY;
		int i = (x - j) / this.gridSizeY;
		String result = (char) ('a' + i) + "" + j;
		
		return result;
	}
	public String getUserInput(String prompt) {
		String result = "";
		
		// TODO: to be implemented
		return result;
	}
	
	public void showGrid() {
		System.out.println("============================");
		
		for (int i = 0; i < gridSizeX; ++i) {
			for (int j = 0; j < gridSizeY; ++j) {
				if (used[i * gridSizeY + j]) {
					System.out.print("x ");
				}
				else {
					System.out.print("o ");
				}
			}
			System.out.println();
		}
		
		System.out.println("============================");
	}
	
	private boolean canHold() {
		/*
		 * check whether the board can hold a dot com
		 */
		for (int i = 1; i < this.gridSizeX - 1; ++i) {
			for (int j = 1; j < this.gridSizeY - 1; ++j) {
				int x = i * this.gridSizeY + j;
				
				// horizontal
				if (checkTriplePlot(x - 1, x, x + 1)) {
					return true;
				}
				
				// vertical
				if (checkTriplePlot(x - this.gridSizeY, x,
										x + this.gridSizeY)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkTriplePlot(int x1, int x2, int x3) {
		/*
		 * check whether all of those three positions are empty
		 */
		return !(this.used[x1] || this.used[x2] || this.used[x3]);
	}
}
