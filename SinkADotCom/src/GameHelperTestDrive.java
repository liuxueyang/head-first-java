import java.util.ArrayList;

public class GameHelperTestDrive {
	public static void main(String[] args) {
		GameHelper gh = new GameHelper();
		ArrayList<DotCom> dc = new ArrayList<DotCom>();
		
		for (int i = 0; i < 3; ++i) {
			DotCom x = new DotCom();
			x.setComName("Com " + i);
			dc.add(x);
		}
		
		gh.showGrid();
		gh.placeDotCom(dc);
		gh.showGrid();
		
//		ArrayList<int> a = new ArrayList<int>();
//		a.add(3);
	}
}