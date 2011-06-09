package helperFunctions;

public class Pair<L, R> {
	public L left;
	public R right;

	public Pair(L l, R r) {
		left = l;
		right = r;
	}

	@Override
	public boolean equals(Object o){
		if (o == null) return false;
		if(!(o instanceof Pair)) return false;
		Pair<?,?> p = (Pair<?,?>) o;
		return 	( left.equals(p.left) && right.equals(p.right) ) || 
				( left.equals(p.right) && right.equals(p.left) ); 		
	}
	
}

