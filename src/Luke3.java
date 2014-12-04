import easyIO.Out;

public class Luke3 {
	private static Out ut = new Out();
	public static boolean HVIT = false;
	public static boolean SVART = true;
	public static int[][] vektorer = {
		{-1, -2}, {1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}, {-1, 2}, {1, 2}
	};

	public static void main(String[] args) {
		boolean[][] brett = new boolean[10][10];
		int x = 0;
		int y = 0;
		
		for (int i=0; i<200; ++i) {
			int[] funnetVektor = vektorer[0];
			for (int j=0; j<vektorer.length; ++j) {
				if (x+vektorer[j][0]>=0 && x+vektorer[j][0]<10 && y+vektorer[j][1]>=0 && y+vektorer[j][1]<10) {
					funnetVektor = vektorer[j];
					if (brett[x+vektorer[j][0]][y+vektorer[j][1]] == brett[x][y]) {
						break;
					}
				}
			}
			brett[x][y] = !brett[x][y];
			x += funnetVektor[0];
			y += funnetVektor[1];
		}
		
		int antall = 0;
		for (boolean[] rekke : brett) {
			for (boolean rute : rekke) {
				if (rute) ++antall;
			}
		}
		
		ut.outln("Antall svarte ruter: " + antall);
	}

}
