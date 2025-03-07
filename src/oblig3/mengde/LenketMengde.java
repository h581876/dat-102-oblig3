package oblig3.mengde;

public class LenketMengde<T> implements MengdeADT<T> {
	
	public class Node <T>{
		public T data;
		public Node <T> neste;
		
		public Node (T data) {
			this.data = data;
			this.neste = null;
		}
	}
	
	private Node<T> forste;
	private int antall;

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(T element) {
		Node<T> node = forste;
		while (node != null) {
			if(node.data.equals(element)) {
				return true;
			}
			node = node.neste;
		}
		return false;
		
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		LenketMengde<T> mengde = (LenketMengde<T>) annenMengde;
		Node<T> node = forste;
		
		while (node != null) {
			if (!mengde.inneholder(node.data)) {
				return false;
			}
			node = node.neste;
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		LenketMengde<T> mengde = (LenketMengde<T>) annenMengde;
		if (antall != mengde.antall ) {
			return false;
		}
		Node<T> node = forste;
		while (node != null) {
			if (mengde.inneholder(node.data)) {
				return true;
			}
			node = node.neste;
		}
		return false;
		
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		LenketMengde<T> mengde = (LenketMengde<T>) annenMengde;
		Node<T> node = forste;
		
		while (node != null) {
			if (mengde.inneholder(node.data)) {
				return false;
			}
			node = node.neste;
		}
		return true;
		
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		LenketMengde<T> snittMengde = new LenketMengde<>();
		Node<T> node = forste;
		
		while (node != null) {
			if(annenMengde.inneholder(node.data)) {
				snittMengde.leggTil(node.data);
			}
			node = node.neste;
		}
		return snittMengde;
		
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		LenketMengde<T> unionMengde = new LenketMengde<>();
		Node<T> node = forste;
		while (node != null) {
			unionMengde.leggTil(node.data);
			node = node.neste;
		}
		LenketMengde<T> annen = (LenketMengde<T>) annenMengde;
		Node<T> nyNode = annen.forste;
		while(nyNode != null) {
			unionMengde.leggTil(nyNode.data);
			nyNode = nyNode.neste;
		}
		return unionMengde;
		
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		LenketMengde<T> differanseMengde = new LenketMengde<>();
		Node<T> node = forste;
		
		while(node != null) {
			if (!annenMengde.inneholder(node.data)) {
				differanseMengde.leggTil(node.data);
			}
			node = node.neste;
		}
		return differanseMengde;
		
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			Node<T> nyNode = new Node<>(element);
			nyNode.neste = forste;
			forste = nyNode;
			antall++;
			}
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		LenketMengde<T> mengde = (LenketMengde<T>) annenMengde;
		Node<T> node = mengde.forste;
		
		while (node != null) {
			leggTil(node.data);
			node = node.neste;
		}
		
	}

	@Override
	public T fjern(T element) {
		Node<T> mengde = forste, forrige = null;
		
		while (mengde != null) {
			if (mengde.data.equals(element)) {
				if (forrige == null) {
					forste = mengde.neste;
				}
				else {
					forrige.neste = mengde.neste;
				}
				antall--;
				return mengde.data;
			}
			forrige = mengde;
			mengde = mengde.neste;
		}
		return null;
	}

	@Override
	public T[] tilTabell() {
		T[] tabell = (T[]) new Object[antall];
		Node<T> node = forste;
		
		for (int i = 0; i < antall; i++) {
			tabell[i] = node.data;
			node = node.neste;
		}
		return tabell;
	}

	@Override
	public int antallElementer() {
		return antall;
	}
	

}
