import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import easyIO.Out;

public class Luke7 {
	private static Out ut = new Out();
	
	// Denne oppgaven ble oppdatert etter at jeg hadde løst den. Dette programmet er nå oppdatert
	// for å løse den nye oppgaven.
	
	public static void main(String[] args) throws IOException {
		// Opprett et bildeobjekt og hent pikseldata fra det
		// Koden under fant jeg på internett.
		// Pikselarrayet inneholder 4 bytes for hver piksel; en for hver RGB-farge, og en for alpha.
		BufferedImage bilde = ImageIO.read(new File("Santa.png"));
		byte[] piksler = ((DataBufferByte) bilde.getRaster().getDataBuffer()).getData();
		
		// Hold telling på antall forekomster av hver piksel.
		// Størrelsen på dette arrayet er lik antall mulige piksler (256^3).
		int[] funnetPiksler = new int[256*256*256];
		
		// Gå gjennom alle pikslene - husk at hver piksel har fire verdier verdier.
		for (int i=0; i<piksler.length; i+=4) {
			// Konverter hver farge til et hex-tall, slå dem sammen, og konverter strengen til en int.
			// Merk at byteverdien er unsigned men Java leser den som signed ved konvertering til
			// integer, derfor legger jeg til 128 for å få en verdi tilsvarende unsigned-verdien.
			// Alphakanalen er alltid den første verdien, men i dette bildet brukes den ikke.
			// Derfor kan jeg hoppe over alphaverdien. Kunne jeg ikke det, ville jeg trengt en større
			// funnetPiksler-array enn det er mulig å ha i 32 bits Java.
			int piksel = Integer.valueOf(
				Integer.toHexString(piksler[i+1]+128)
				+ Integer.toHexString(piksler[i+2]+128)
				+ Integer.toHexString(piksler[i+3]+128)
			, 16);
			// Øk telleren for pikselen med 1.
			++funnetPiksler[piksel];
		}
		
		// Sorter arrayen. Ved å gjøre dette mister vi informasjonen om hvilke piksler
		// som forekommer hvor ofte, men det vi er ute etter er bare antall forekomster.
		Arrays.sort(funnetPiksler);
		
		// Skriv ut den 10. siste verdien i arrayet.
		ut.outln("Løsning: "+funnetPiksler[funnetPiksler.length-10]);
	}

}
