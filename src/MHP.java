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
		result.M.addAll(crossProduct(left.O, right.L));
		
		result.O.addAll(left.O);
		result.O.addAll(right.O);
		
		result.L.addAll(left.L);
		result.L.addAll(right.L);
		
		return result;
	}
	
	@Override
	public void visit(Statement n) {
		super.visit(n);
		molSet.put(n, getMOL(n.nodeChoice.choice));
	}

	@Override
	public void visit(Assignment n) {
		
		super.visit(n);
		
		MOL result = sequenceMOL(n.expression, n.expression1);
		result.L.add(n);
		molSet.put(n, result);
		
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
		
		molSet.put(n, result);		
	}

	@Override
	public void visit(Block n) {
		
		super.visit(n);	
		MOL result = nodeVectorMOL(n.nodeListOptional.nodes);
	
		molSet.put(n, result);
	
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
		
		molSet.put(n, result);
		
	}	
	
	@Override
	public void visit(IfStatement n) {
		super.visit(n);
					
		MOL result = sequenceMOL(n.expression, n.statement);
		MOL expression = getMOL(n.expression);
		
		//node optional could be empty
		if( n.nodeOptional != null ){
			
			MOL tempNode = getMOL(n.nodeOptional.node);
			result.M.addAll(tempNode.M);
			result.M.addAll(crossProduct(expression.O, tempNode.L));
			
			result.O.addAll(tempNode.O);
			result.L.addAll(tempNode.L);
		}
		
		molSet.put(n, result);
	}

	@Override
	public void visit(LoopStatement n) {
		super.visit(n);
		
		MOL expression = getMOL(n.expression);
		MOL statement = getMOL(n.statement);
		
		MOL result = sequenceMOL(n.expression, n.statement);		
		result.M.addAll(crossProduct(statement.O, expression.L));
		
		result.L.add(n);
		
		molSet.put(n, result);
		
	}

	@Override
	public void visit(PostfixStatement n) {
		super.visit(n);
		molSet.put(n, getMOL(n.expression));
	}

	@Override
	public void visit(PrintlnStatement n) {
		super.visit(n);
		molSet.put(n, getMOL(n.expression));
	}

	@Override
	public void visit(ReturnStatement n) {

		super.visit(n);
		//node is optional, it could be null 
		if( n.nodeOptional != null ){
			molSet.put(n, getMOL(n.nodeOptional.node));
		}
		
	}

	@Override
	public void visit(ThrowStatement n) {
		super.visit(n);
		molSet.put(n, getMOL(n.expression));
	}

	@Override
	public void visit(WhileStatement n) {
		super.visit(n);
		
		MOL result = new MOL();
		MOL expression = getMOL(n.expression);
		MOL statement = getMOL(n.statement);
		
		result.M.addAll(expression.M);
		result.M.addAll(statement.M);
	
		result.O.addAll(expression.O);
		result.O.addAll(statement.O);
		
		result.L.addAll(expression.L);
		result.L.addAll(statement.L);
		
		//because expression and statement are executed repeatedly
		result.M.addAll(crossProduct(result.O, result.L));
		
		result.L.add(n);
		
		molSet.put(n, result);

		
	}
	
		
}
