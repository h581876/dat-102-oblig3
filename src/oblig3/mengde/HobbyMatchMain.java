package oblig3.mengde;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {
	
	public static double match(Person a, Person b) {
		Set<String> aHobbyer = a.getHobbyer();
		Set<String> bHobbyer = b.getHobbyer();
		
		//felles hobbyer
		Set<String> felles = new HashSet<>(aHobbyer);
		felles.retainAll(bHobbyer);
		int antallFelles = felles.size();
		
		// kun a, kun b og totalt
		int antallKunA = aHobbyer.size() - antallFelles;
		int antallKunB = bHobbyer.size() - antallFelles;
		int antallTotalt = aHobbyer.size() + bHobbyer.size() - antallFelles;
		
		if (antallTotalt == 0) {
			return 0.0;
		}
		
		double match = antallFelles - ((antallKunA + antallKunB) / (double) antallTotalt);
		return match;
	}
	
	

	public static void main(String[] args) {
		
		Person arne = new Person("Arne", "jakt", "sykling", "data", "musikk");
		Person bente = new Person("Bente", "data", "sykling", "håndarbeid", "hund");
		Person ole = new Person("Ole", "lesing", "gaming", "matlaging", "sykling");
		
		double arneBente = match(arne, bente);
		double arneOle = match(arne, ole);
		double benteOle = match(bente, ole);
		double benteArne = match(bente, arne);
		double arneArne = match(arne, arne);
		
		System.out.println("Arne og Bente: " + arneBente);
		System.out.println("Arne og Ole: " + arneOle);
		System.out.println("Bente og Ole: " + benteOle);
		System.out.println("Bente og Arne: " + benteArne);
		System.out.println("Arne selvmatch: " + arneArne);
		
		//beste match
		if (arneOle > arneBente && arneOle > benteOle) {
			System.out.println("Beste match: Arne og Ole");
		} else if (benteOle > arneBente) {
			System.out.println("Beste match: Bente og Ole");
		} else {
			System.out.println("Beste match: Arne og Bente");
		}
	}
	

}
