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
	
}
