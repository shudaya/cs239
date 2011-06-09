package helperFunctions;
import miniX10.syntaxtree.*;

import java.util.HashSet;
import java.util.Set;

public class MOL {
	public HashSet<Pair <Node, Node>> M;
	public HashSet<Node> O, L;
	
	public MOL() {
		M = new HashSet<Pair <Node, Node>>();
		O = new HashSet<Node>();
		L = new HashSet<Node>();
	}

	public MOL(MOL copy){
		M = copy.M;
		O = copy.O;
		L = copy.L;
	}
	
	public MOL(HashSet<Pair <Node, Node>> m, HashSet<Node> o, HashSet<Node> l) {
		M = m;
		O = o;
		L = l;
	}
	
	public int hashCode(){return M.hashCode() ^ O.hashCode() ^ L.hashCode();}

	@Override
	public boolean equals(Object o){
		if (o == null) return false;
		if(!(o instanceof MOL)) return false;
		MOL p = (MOL) o;
		return 	( M.equals(p.M) && O.equals(p.O) && L.equals(p.L) ); 		
	}
	
}
