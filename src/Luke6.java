import easyIO.Out;

public class Luke6 {
	private static Out ut = new Out();
	private static final int ST�RRELSE = 8000;

	public static void main(String[] args) {
		boolean[] produkter = new boolean[ST�RRELSE*ST�RRELSE+1];
		int antall = 0;
		for (int i=1; i<=ST�RRELSE; ++i) {
			for (int j=1; j<=ST�RRELSE; ++j) {
				if (!produkter[i*j]) ++antall;
				produkter[i*j] = true;
			}
		}
		ut.outln("Antall unike produkter: "+antall);
	}
}
