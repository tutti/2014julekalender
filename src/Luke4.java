import easyIO.In;
import easyIO.Out;

/**
 * Filen "kilma_data_blindern.txt" h�rer til denne oppgaven.
 * Jeg har redigert filen slik at kun dataene er igjen; beskrivende tekst
 * er fjernet. Overskrifter til hver kolonne gjenst�r.
 */

public class Luke4 {
	private static In fil = new In("kilma_data_blindern.txt");
	private static Out ut = new Out();
	
	public static void main(String[] args) {
		// Hopp over f�rste linje med kolonneoverskrifter.
		fil.inLine();
		
		// Start med en "minste" temperatur p� 999. Dette er en urealistisk h�y
		// temperatur som er garantert � v�re st�rre enn den minste m�lte.
		double minste = 999.0;
		String dato = "";
		
		// Fortsett � lese til filen ikke har mer data
		while (!fil.endOfFile()) {
			// Les inn en linje fra filen
			String linje = fil.inLine();
			
			// Del opp filen etter whitespace
			// Regex-strengen "\\s+" finner alle tilfeller av whitespace med lengde 1 eller mer.
			String[] data = linje.split("\\s+");
			
			// Hvis den m�lte temperaturen ikke var i desember, hopp over den.
			int m�ned = Integer.parseInt(data[2].split("\\.")[1]);
			if (m�ned != 12) continue;
			
			// Bytt ut kommaet i tallet med et punktum s� Java kan lese det som et tall.
			double dagensTemperatur = Double.parseDouble(data[4].replace(",", "."));
			
			// Hvis temperaturen er mindre enn den minste funnet s� langt,
			// skriv over og lagre ogs� hvilken dato som ble funnet.
			if (dagensTemperatur < minste) {
				minste = dagensTemperatur;
				dato = data[2];
			}
		}
		
		// Skriv ut minste temperatur og datoen den ble funnet p�.
		ut.outln("Laveste temperatur: " + minste);
		ut.outln("Dato: " + dato);
	}
}
