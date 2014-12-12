import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import easyIO.Out;

public class Luke12 {
	private static Out ut = new Out();

	public static void main(String[] args) {
		// Her brukes Javas GregorianCalendar-klasse. Den gregorianske kalenderen ble opprinnelig
		// innført i 1582, og klassen bruker en juliansk kalender før dette tidspunktet;
		// den andre linjen her endrer dette punktet, og bruker gregoriansk
		// kalender hele veien.
		GregorianCalendar kalender = new GregorianCalendar(1337, 0, 13);
		kalender.setGregorianChange(new Date(Long.MIN_VALUE));
		
		// Antall måneder mellom 13. januar 1337 og 13. desember 2014.
		// Prorammet starter fra den 13. siden det er kun den 13. i hver
		// måned som skal sjekkes.
		int antallMåneder = (2015-1337)*12-1;
		
		int antallFredager = 0;
		
		for (int i=0; i<=antallMåneder; ++i) {
			// Hvis den 13. denne måneden er en fredag, tell opp antall fredager.
			if (kalender.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				++antallFredager;
			}
			
			// Gå 1 måned fremover
			kalender.add(Calendar.MONTH, 1);
		}
		
		ut.outln("Antall fredag den 13.: "+antallFredager);
	}

}
