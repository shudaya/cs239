import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import miniX10.syntaxtree.*;
import miniX10.visitor.*;
import helperFunctions.*;

public class MHP extends DepthFirstVisitor{

	private HashMap<Node, MOL> molSet;
	private HashMap<String, Node> nameSet;
	
	//public MHP(Node file) {
	public MHP() {
		molSet = new HashMap<Node, MOL>();
	}
	
	public HashMap<Node, MOL> getMolSet(){return molSet;}
	public HashMap<String, Node> getNameSet(){return nameSet;}
	
	//get MOL
	public MOL getMOL(Node n){

		if( molSet.containsKey(n.hashCode()) )
			return (MOL)molSet.get(n.hashCode());
		else
			return null;
	}
	
	//helper for crossproduct
	public HashSet<Pair <Node, Node>> crossProduct(HashSet<Node> l, HashSet<Node> r){
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
	
	//helper function for MOL
	public MOL nodeVectorMOL(Vector<Node> v){
		MOL result = new MOL();
		Iterator<Node> iter = v.iterator();
		while(iter.hasNext()){
			
			Node temp = iter.next();
			temp.accept(this);

			MOL tempMOL = getMOL(temp);

			if( tempMOL != null ){	
				result.M.addAll(tempMOL.M);
				result.O.addAll(tempMOL.O);
				result.L.addAll(tempMOL.L);
			
				result.M.addAll(crossProduct(result.O, tempMOL.L));		
			}
			
		}
		
		return result;
	}
	
	//helper function for sequence
	public MOL sequenceMOL(Node l, Node r){
		MOL result = new MOL();
		MOL left = getMOL(l);
		MOL right = getMOL(r);

		result.M.addAll(left.M);
		result.M.addAll(right.M);
		result.M.addAll(crossProduct(left.O,right.L));
		
		result.O.addAll(left.O);
		result.O.addAll(right.O);
		
		result.L.addAll(left.L);
		result.L.addAll(right.L);
		
		return result;
	}

	@Override
	public void visit(Assignment n) {
		
		super.visit(n);
		
		MOL result = sequenceMOL(n.expression, n.expression1);
		result.L.add(n);
		molSet.put(n,result);
		
		/*
		MOL left = getMOL(n.expression);
		MOL right = getMOL(n.expression1);
		
		HashSet<Pair <Node,Node>> M = new HashSet<Pair <Node, Node>>();
		HashSet<Node> O = new HashSet<Node>();
		HashSet<Node> L = new HashSet<Node>();

		//union left.M, right.M, crossproduct s1.0, s2.L
		if( left != null ){
			M.addAll(left.M);
			O.addAll(left.O);
			L.addAll(left.L);
		}
		
		if( right != null){
			M.addAll(right.M);
			O.addAll(right.O);
			L.addAll(right.L);
		}
		
		L.add(n); //add your own label
				
		MOL assignment = new MOL(M,O,L);
		molSet.put(n,assignment);
		*/
		
	}

	@Override
	public void visit(AsyncStatement n) {
		
		super.visit(n);
		
		MOL result = new MOL();
		MOL expression = getMOL(n.expression);
		MOL block = getMOL(n.block);
		
		result.M.addAll(expression.M);
		result.M.addAll(block.M);
		result.M.addAll(crossProduct(expression.O, block.L));
		
		result.O.addAll(expression.O);
		result.O.addAll(block.L);

		result.L.addAll(expression.L);
		result.L.addAll(block.L);
		result.L.add(n);
		
		molSet.put(n,result);		
	}

	@Override
	public void visit(FinishStatement n) {
		
		super.visit(n);
		
		MOL result = new MOL();
		MOL statement= getMOL(n.statement);
		
		result.M.addAll(statement.M);
		//Empty O
		result.L.addAll(statement.L);
		result.L.add(n);
		
		molSet.put(n,result);
		
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
