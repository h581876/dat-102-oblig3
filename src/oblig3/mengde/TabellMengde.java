package oblig3.mengde;

public class TabellMengde<T> implements MengdeADT<T> {
	
	private T[] mengde;
	private int antall;
	
	@SuppressWarnings("unchecked")
	public TabellMengde(int kapasitet) {
		mengde = (T[]) new Object [kapasitet];
		antall = 0;
	}
	
	public boolean erTom() {
		return antall == 0;
	}
	
	public boolean inneholder(T element) {
		for (int i = 0; i < antall; i++) {
			if (mengde[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		TabellMengde<T> annen = (TabellMengde<T>) annenMengde;
		
		for (int i = 0; i < antall; i++) {
			if (annen.inneholder(mengde[i])) {
				return true;
			}
		}
		return false;
	}

}
