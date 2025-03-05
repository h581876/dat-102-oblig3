package oblig3.mengde;

public class TabellMengde<T> implements MengdeADT<T> {

	private T[] mengde;
	private int antall;

	@SuppressWarnings("unchecked")
	public TabellMengde(int kapasitet) {
		mengde = (T[]) new Object[kapasitet];
		antall = 0;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		for (int i = 0; i < antall; i++) {
			if (mengde[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		TabellMengde<T> annen = (TabellMengde<T>) annenMengde;

		for (int i = 0; i < antall; i++) {
			if (annen.inneholder(mengde[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		TabellMengde<T> annen = (TabellMengde<T>) annenMengde;
		if (antall != annen.antall) {
			return false;
		}
		for (int i = 0; i < antall; i++) {
			if (!annen.inneholder(mengde[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		TabellMengde<T> annen = (TabellMengde<T>) annenMengde;

		for (int i = 0; i < antall; i++) {
			if (annen.inneholder(mengde[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == mengde.length) {
				T[] nyMengde = (T[]) new Object[mengde.length * 2];
				
				for (int i = 0; i < antall; i++) {
					nyMengde[i] = mengde[i];
				}
				mengde = nyMengde; 
			}
			mengde[antall] = element; 
			antall++;
		}
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		TabellMengde<T> snittMengde = new TabellMengde<>(mengde.length);

		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(mengde[i])) {
				snittMengde.leggTil(mengde[i]);
			}
		}
		return snittMengde;
	}

	@Override
	public int antallElementer() {
		return antall;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
		T[] resultat = (T[]) new Object[antall];
		for (int i = 0; i < antall; i++) {
			resultat[i] = mengde[i];
		}
		return resultat;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		TabellMengde<T> unionMengde = new TabellMengde<>(mengde.length + annenMengde.antallElementer());

		for (int i = 0; i < antall; i++) {
			unionMengde.leggTil(mengde[i]);
		}
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			T element = annenMengde.tilTabell()[i];
			unionMengde.leggTil(element);
		}
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		TabellMengde<T> differanseMengde = new TabellMengde<>(mengde.length);

		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(mengde[i])) {
				differanseMengde.leggTil(mengde[i]);
			}
		}
		return differanseMengde;
	}
	
	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		for (int i = 0; i < annenMengde.antallElementer(); i++) {
			T element = (T) annenMengde.tilTabell()[i];
			leggTil(element);
		}
	}
	
	@Override
	public T fjern(T element) {
		for (int i = 0; i < antall; i++) {
			if (mengde[i].equals(element)) {
				T fjernElement = mengde[i];
				for (int j = i; j < antall - 1; j++) {
					mengde[j] = mengde[j+1];
				}
				mengde[antall - 1] = null;
				antall--;
				return fjernElement;
			}
		}
		return null;
	}

}
