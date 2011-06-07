import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import miniX10.syntaxtree.*;
import miniX10.visitor.*;
import helperFunctions.*;

public class MHP extends DepthFirstVisitor{

	private HashMap<Node, MOL> molSet;
	
	public MHP(Node file) {
		molSet = new HashMap<Node, MOL>();
	}
	
	public HashMap<Node, MOL> getMolSet(){return molSet;}
	
	//get MOL
	public MOL getMOL(Node n){

		if( molSet.containsKey(n.hashCode()) )
			return (MOL)molSet.get(n.hashCode());
		else
			return null;
	}
	
	//helper function for MOL
	public MOL nodeVectorMOL(Vector<Node> v){
		MOL result = new MOL();
		Iterator<Node> iter = v.iterator();
		while(iter.hasNext()){
			
			Node temp = iter.next();
			temp.accept(this);

			MOL tempMOL = getMOL(temp);

			result.L.addAll(tempMOL.L);
			result.O.addAll(tempMOL.O);
			result.M.addAll(tempMOL.M);
			
			//crossproduct previous O x current L
			//result.M.addAll(crossProduct(result.O, tempMOL.L);
		}
		
		return result;
	}
	
	//helper for crossproduct
	public HashSet<Pair <Node, Node>> crossProductM(HashSet<Node> l, HashSet<Node> r){
		HashSet<Pair <Node, Node>> result = new HashSet<Pair <Node, Node>>();
				
		Iterator<Node> lIter = l.iterator();
		while(lIter.hasNext()){
			
			Node lNode = lIter.next();
			Iterator<Node> rIter = r.iterator();
			while(rIter.hasNext()){
				
				Node rNode = rIter.next();
				result.add(new Pair<Node, Node>(lNode, rNode));
				
			}
		
		}
		
		return result;
	}
	
	@Override
	public void visit(Assignment n) {
		
		super.visit(n);

		//Assume lhs is a variable, rhs can be a code
		
		MOL left = getMOL(n.expression);
		MOL right = getMOL(n.expression1);
		
		HashSet<Node> O = new HashSet<Node>();
		O.addAll(left.O);
		O.addAll(right.O);
		
		HashSet<Node> L = new HashSet<Node>();
		L.addAll(left.L);
		L.addAll(right.L);
		L.add(n); //add your own label
		
		HashSet<Pair <Node,Node>> M = new HashSet<Pair <Node, Node>>();
		//union left.M, right.M, crossproduct right.O and left.L
		M.addAll(left.M);
		M.addAll(right.M);
		
		MOL assignment = new MOL(M,O,L);
		molSet.put(n,assignment);
		
	}

	@Override
	public void visit(AsyncStatement n) {
		
		super.visit(n);
	
		MOL expression = getMOL(n.expression);
		MOL block = getMOL(n.block);
		
		HashSet<Node> O = new HashSet<Node>();
		O.addAll(block.O);
		O.addAll(block.L);
		
		HashSet<Node> L = new HashSet<Node>();
		L.addAll(block.L);
		L.add(n);  // add your own label
		
		HashSet<Pair <Node, Node>> M = new HashSet<Pair <Node, Node>>();
		M.addAll(expression.M);
		M.addAll(block.M);
		
		//union expression.M and block.M
		//expression.O x block.L
		
		MOL assignment = new MOL(M,O,L);
		molSet.put(n,assignment);
		
	}

	@Override
	public void visit(FinishStatement n) {
		
		super.visit(n);
		
		MOL statement= getMOL(n.statement);
		
		HashSet<Node> L = new HashSet<Node>();
		L.addAll(statement.L);
		L.add(n); //add yourself
		
		HashSet<Node> O = new HashSet<Node>();
		
		HashSet<Pair <Node, Node>> M = new HashSet<Pair <Node, Node>>();
		M.addAll(statement.M);
		
		MOL assignment = new MOL(M,O,L);
		molSet.put(n,assignment);
		
	}

	@Override
	public void visit(Block n) {
		
		super.visit(n);	
		MOL result = nodeVectorMOL(n.nodeListOptional.nodes);
		molSet.put(n,result);
	}

	@Override
	public void visit(ReturnStatement n) {
		// TODO Auto-generated method stub
		super.visit(n);
	}

	
	
}
