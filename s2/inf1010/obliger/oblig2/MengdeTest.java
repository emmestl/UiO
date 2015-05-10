public class MengdeTest {
	public static void main (String[] args) {
		boolean suksess = true;
		String[] alfabet = new String[26];
		for (int i=0 ; i<26 ; i++ ) {
			alfabet[i] = (char)('a' + i) + "";
		}

		Mengde<String> alfa = new Mengde<>();
		
		if (! alfa.tom() ) {
			System.out.println("Feil! Nyopprettet Mengde skal være tom");
			suksess = false;
		}

		for (String s: alfabet ) {
			alfa.leggTil(s);
		}

		if (alfa.tom() ) {
			System.out.println("Feil! Fyllt Mengde skal ikke være tom");
			suksess = false;
		}

		String test = alfa.fjernNyeste();
		int i = 25;
		while (test != null) {
			if (test != alfabet[i]) {
				System.out.println("FEIL! - Element " + test + "skulle vært "+
						alfabet[i]);
				suksess = false;
			}
			if ( i != 0 ) {
				i--;
			}
			//System.out.println (i);
			test = alfa.fjernNyeste();
		}

		if (! alfa.tom() ) {
			System.out.println("Feil! toemt Mengde skal være tom");
			suksess = false;
		}

		for (String s: alfabet ) {
			alfa.leggTil(s);
		}
		//System.out.println();
		//System.out.println("Alfabetet: ");
		//
		test = alfa.fjernEldste();
		while (test != null) {
			if (test != alfabet[i]) {
				System.out.println("FEIL! - Element " + test + "skulle vært "+
						alfabet[i]);
				suksess = false;
			}
			if ( i != 25 ) {
				i++;
			}
			test = alfa.fjernEldste();
		}

		for (String s: alfabet ) {
			if ( ! alfa.leggTil(s) ) {
				System.out.println("FEIL! - Innleggelse av " + s + "feilet");
				suksess = false;
			}
			if ( alfa.leggTil(s) ) {
				System.out.println("FEIL! - Innleggelse av " + s + "skulle feilet");
				suksess = false;
			}
		}
		i = 0;
		test = alfa.fjernEldste();
		while (test != null) {
			if (test != alfabet[i]) {
				System.out.println("FEIL! - Element " + test + "skulle vært "+
						alfabet[i]);
				suksess = false;
			}
			if ( i != 25 ) {
				i++;
			}
			test = alfa.fjernEldste();
		}

		if (suksess) {
			System.out.println("Suksess! Alle tester OK!");
		}

	}
}
