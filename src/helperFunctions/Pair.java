package helperFunctions;

import miniX10.syntaxtree.Node;

public class Pair<L, R> {
	public L left;
	public R right;

	public Pair(L l, R r) {
		left = l;
		right = r;
	}

	public int hashCode(){return left.hashCode() ^ right.hashCode();}
	
	@Override
	public boolean equals(Object o){
		if (o == null) return false;
		if(!(o instanceof Pair)) return false;
		Pair<Node, Node> p = (Pair<Node, Node>) o;
		return 	( left.equals(p.left) && right.equals(p.right) ) || 
				( left.equals(p.right) && right.equals(p.left) ); 		
	}
	
}

