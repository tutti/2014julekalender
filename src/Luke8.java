import easyIO.Out;

public class Luke8 {
	private static Out ut = new Out();
	
	public static void main(String[] args) {
		// Ikke skriv ut komma foran første tall
		boolean komma = false;
		
		// Gå gjennom alle tall fra 1 til 10000
		for (int i=1; i<=10000; ++i) {
			// Tell summen av alle divisorene
			int sum = 0;
			
			// For hvert tall, gå gjennom alle tall opp til halvparten av tallet.
			// Tall over halvparten kan ikke være divisorer.
			for (int j=1; j<=i/2; ++j) {
				if (i%j == 0) {
					// Hvis tallet er en divisor, legg det til summen
					sum += j;
				}
			}
			
			// Hvis tallet er lik summen av sine egne divisorer, skriv det ut.
			if (i==sum) {
				// Skriv et komma før tallet (utenom før første tall).
				if (komma) {
					ut.out(",");
				} else {
					komma = true;
				}
				ut.out(i);
			}
		}
	}
}
