import easyIO.Out;

public class Luke23 {
	private static Out ut = new Out();
	
	public static void main(String[] args) {
		int antall = 0;
		for (int n=1; n<1000000; ++n) {
			// Math.log(n+1) er enten lik eller mindre enn 1
			// større enn antall siffer i n.
			for (int i=1; i<Math.log10(n+1); ++i) {
				// Tallet n mod 10^i gir de i siste sifrene.
				// Tallet n delt på 10^i gir sifrene før (ved integerdivisjon).
				int del1 = n / (int)Math.pow(10, i);
				int del2 = n % (int)Math.pow(10, i);
				if (Math.pow(del1+del2, 2) == n) {
					// Hvis summen av de to delene opphøyd i annen er lik
					// selve tallet, tell med tallet og gå videre til
					// neste tall.
					++antall;
					break;
				}
			}
		}
		
		ut.outln("Antall tall som har den gitte egenskapen: "+antall);
	}

}
