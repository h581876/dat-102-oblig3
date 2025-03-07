package oblig3.mengde;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {
	
	private Set<T> mengde;
	
	public JavaSetToMengde() {
		mengde = new HashSet<>();
	}

	@Override
	public boolean erTom() {
		return mengde.isEmpty();
	}

	@Override
	public boolean inneholder(T element) {
		return mengde.contains(element);
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		return ((JavaSetToMengde<T>) annenMengde).mengde.containsAll(this.mengde);
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		return this.mengde.equals(((JavaSetToMengde<T>) annenMengde).mengde);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		Set<T> disjunkt = new HashSet<>(this.mengde);
		disjunkt.retainAll(((JavaSetToMengde<T>) annenMengde).mengde);
		return disjunkt.isEmpty();
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> snittMengde = new JavaSetToMengde<>();
		snittMengde.mengde.addAll(this.mengde);
		
		snittMengde.mengde.retainAll(((JavaSetToMengde<T>) annenMengde).mengde);
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> unionMengde = new JavaSetToMengde<>();
		unionMengde.mengde.addAll(this.mengde);
		
		unionMengde.mengde.addAll(((JavaSetToMengde<T>) annenMengde).mengde);
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> differanseMengde = new JavaSetToMengde<>();
		differanseMengde.mengde.addAll(this.mengde);
		
		differanseMengde.mengde.removeAll(((JavaSetToMengde<T>) annenMengde).mengde);
		return differanseMengde;
	}

	@Override
	public void leggTil(T element) {
		mengde.add(element);
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		mengde.addAll(((JavaSetToMengde<T>) annenMengde).mengde);
		
	}

	@Override
	public T fjern(T element) {
		if (mengde.remove(element)) {
			return element;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] tilTabell() {
		return (T[]) mengde.toArray();
	}

	@Override
	public int antallElementer() {
		return mengde.size();
	}

}
