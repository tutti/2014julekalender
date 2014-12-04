import easyIO.Out;

public class Luke1 {
	private static Out ut = new Out();
	
	private static boolean erPalindrom(String tall) {
		StringBuilder sb = new StringBuilder(tall);
		return sb.reverse().toString().equals(tall);
	}

	public static void main(String[] args) {
		int antall = 0;
		for (int i=1; i<=1000000; ++i) {
			String base10 = Integer.toString(i);
			String base8 = Integer.toString(i, 8);
			if (erPalindrom(base10) && erPalindrom(base8)) ++antall;
		}
		ut.outln("Antall palindromer: " + antall);
	}

}
