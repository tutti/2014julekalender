import easyIO.Out;

public class Luke6 {
	private static Out ut = new Out();
	private static final int STØRRELSE = 8000;

	public static void main(String[] args) {
		boolean[] produkter = new boolean[STØRRELSE*STØRRELSE+1];
		int antall = 0;
		for (int i=1; i<=STØRRELSE; ++i) {
			for (int j=1; j<=STØRRELSE; ++j) {
				if (!produkter[i*j]) ++antall;
				produkter[i*j] = true;
			}
		}
		ut.outln("Antall unike produkter: "+antall);
	}
}
