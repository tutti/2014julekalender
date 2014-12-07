import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import easyIO.Out;

public class Luke7 {
	private static Out ut = new Out();
	
	// Denne oppgaven ble oppdatert etter at jeg hadde l�st den. Dette programmet er n� oppdatert
	// for � l�se den nye oppgaven.
	
	public static void main(String[] args) throws IOException {
		// Opprett et bildeobjekt og hent pikseldata fra det
		// Koden under fant jeg p� internett.
		// Pikselarrayet inneholder 4 bytes for hver piksel; en for hver RGB-farge, og en for alpha.
		BufferedImage bilde = ImageIO.read(new File("Santa.png"));
		byte[] piksler = ((DataBufferByte) bilde.getRaster().getDataBuffer()).getData();
		
		// Hold telling p� antall forekomster av hver piksel.
		// St�rrelsen p� dette arrayet er lik antall mulige piksler (256^3).
		int[] funnetPiksler = new int[256*256*256];
		
		// G� gjennom alle pikslene - husk at hver piksel har fire verdier verdier.
		for (int i=0; i<piksler.length; i+=4) {
			// Konverter hver farge til et hex-tall, sl� dem sammen, og konverter strengen til en int.
			// Merk at byteverdien er unsigned men Java leser den som signed ved konvertering til
			// integer, derfor legger jeg til 128 for � f� en verdi tilsvarende unsigned-verdien.
			// Alphakanalen er alltid den f�rste verdien, men i dette bildet brukes den ikke.
			// Derfor kan jeg hoppe over alphaverdien. Kunne jeg ikke det, ville jeg trengt en st�rre
			// funnetPiksler-array enn det er mulig � ha i 32 bits Java.
			int piksel = Integer.valueOf(
				Integer.toHexString(piksler[i+1]+128)
				+ Integer.toHexString(piksler[i+2]+128)
				+ Integer.toHexString(piksler[i+3]+128)
			, 16);
			// �k telleren for pikselen med 1.
			++funnetPiksler[piksel];
		}
		
		// Sorter arrayen. Ved � gj�re dette mister vi informasjonen om hvilke piksler
		// som forekommer hvor ofte, men det vi er ute etter er bare antall forekomster.
		Arrays.sort(funnetPiksler);
		
		// Skriv ut den 10. siste verdien i arrayet.
		ut.outln("L�sning: "+funnetPiksler[funnetPiksler.length-10]);
	}

}
