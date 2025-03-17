package oblig3.mengde;

import java.util.*;

public class Soketid {
	
	public static void main(String[] args) {
		int antElement = 100_000;
		int maxVerdi = 1_000_000;
		int tall = 376; 
		int steg = 45713; 
		
		HashSet<Integer> hashSet = new HashSet<>();
		Integer[] tabell = new Integer[antElement];

		// Legg inn elementer
		for (int i = 0; i < antElement; i++) {
			hashSet.add(tall);
			tabell[i] = tall;
			tall = (tall + steg) % maxVerdi;
		}

		// Sorter tabellen
		Arrays.sort(tabell);
		
        int antSok = 10_000;
        Random random = new Random();
        int[] sokTall = new int[antSok];
        
        for (int i = 0; i < antSok; i++) {
            sokTall[i] = random.nextInt(maxVerdi);
        }
        
        //Søk hashSet
        int funnetHashSet = 0;
        long startHashSet = System.nanoTime();
        
        for (int i = 0; i < antSok; i++) {
            if (hashSet.contains(sokTall[i])) {
                funnetHashSet++;
            }
        }
        
        long sluttHashSet = System.nanoTime();
        double tidHashSetMs = (sluttHashSet - startHashSet) / 1_000_000.0;
        
        //Søk binærtabell
        int funnetTabell = 0;
        long startTabell = System.nanoTime();
        
        for (int i = 0; i < antSok; i++) {
            if (Arrays.binarySearch(tabell, sokTall[i]) >= 0) {
                funnetTabell++;
            }
        }
        
        long sluttTabell = System.nanoTime();
        double tidTabellMs = (sluttTabell - startTabell) / 1_000_000.0;
        
        System.out.println("HashSet: fant " + funnetHashSet + " av " + antSok + " tall på " + tidHashSetMs + " ms");
        System.out.println("Tabell:  fant " + funnetTabell + " av " + antSok + " tall på " + tidTabellMs + " ms");
    }
}

        



