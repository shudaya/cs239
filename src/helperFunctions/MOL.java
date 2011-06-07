package helperFunctions;
import miniX10.syntaxtree.*;

import java.util.HashSet;
import java.util.Set;

public class MOL {
	public Set<Pair <Node, Node>> M;
	public Set<Node> O, L;
	
	public MOL() {
		M = new HashSet<Pair <Node, Node>>();
		O = new HashSet<Node>();
		L = new HashSet<Node>();
	}

	public MOL(HashSet<Pair <Node, Node>> m, HashSet<Node> o, HashSet<Node> l) {
		M = m;
		O = o;
		L = l;
	}
	
}
