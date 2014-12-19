import easyIO.Out;

public class Luke19 {
	// Kombiner alle linjene til en lang streng
	private static String lang_streng = "Jegtroringenkanleveetheltlivutenkj�rlighetMenkj�rlighetenharmange"+
		"ansikterIh�stkomdetutenboksomheterErlikKj�rlighetDenbest�ravsamtaler"+
		"medselgereavgatemagasinetsomn�eretablertimangenorskebyerAlleharde"+
		"enhistorie�fortelleomkj�rlighetsomnoeavgj�rendeEntendetertilen"+
		"partneretfamiliemedlemenvennelleretkj�ledyrMangeharopplevd�bli"+
		"sveketogselv�svikteMenutrolignokblirikkekj�rlighetsevnen�delagt"+
		"allikevelDenbyggesoppigjengangp�gangKj�rligheteneretsted�feste"+
		"blikketDengirossretningognoe�styreetterDengirossverdisommennesker"+
		"ognoe�leveforP�sammem�tesomkj�rligheteneretfundamentimenneskelivet"+
		"erGrunnlovenetfundamentfornasjonenNorgeFor200�rsidensamletengruppe"+
		"mennsegp�Eidsvollfor�lagelovensomskullebligrunnlagettildetselvstendige"+
		"NorgeGrunnlovensomdengangblevedtattharutvikletsegipaktmedtidenog"+
		"sikreridagdetnorskefolkrettigheterviletttarforgittihverdagenRettighetersom"+
		"menneskerimangeandrelandbarekandr�mmeomogsomdeslossformedlivet"+
		"sominnsatsJegh�peratvigjennomjubileumsfeiringeni2014vilbliminnetom"+
		"hvaGrunnlovenegentligbetyrforosss�vikanfortsette�arbeideforverdiene"+
		"v�reb�deherhjemmeoginternasjonaltJegharlysttil�nevnenoeneksempler"+
		"p�hvordanGrunnlovenvirkerinnp�enkeltmenneskerslivTenkdegatduskriver"+
		"etkritiskinnleggomlandetsstyrep�sosialemedier";
	
	private static Out ut = new Out();
	
	// Bruker erPalindrom() fra luke 1
	private static boolean erPalindrom(String tall) {
		// Sjekker om en streng er et palindrom
		// Metoden reverse() i StringBuilder blir brukt.
		StringBuilder sb = new StringBuilder(tall);
		return sb.reverse().toString().equals(tall);
	}
	
	public static void main(String[] args) {
		// Behold den lengste strengen s� langt etter hver steg
		String lengste = "";
		// G� gjennom alle mulige startposisjoner
		for (int i=0; i<lang_streng.length(); ++i) {
			// For hver startposisjon, g� gjennom alle mulige strenger som starter der
			// (dvs med slutt helt fra neste tegn til slutten av ordet)
			for (int j=i+1; j<=lang_streng.length(); ++j) {
				// Hvis strengen er et palindrom og lengre enn det forrige palindromet, behold den.
				String s = lang_streng.substring(i, j);
				if (erPalindrom(s) && s.length() > lengste.length()) {
					lengste = s;
				}
			}
		}
		ut.outln("Lengste palindrom: "+lengste);
	}
}
