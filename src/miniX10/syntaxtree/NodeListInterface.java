//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * The interface which NodeList, NodeListOptional, and NodeSequence
 * implement.
 */
public interface NodeListInterface extends Node {
   public void addNode(Node n);
   public Node elementAt(int i);
   public java.util.Enumeration<Node> elements();
   public int size();

   public void accept(miniX10.visitor.Visitor v);
   public <R,A> R accept(miniX10.visitor.GJVisitor<R,A> v, A argu);
   public <R> R accept(miniX10.visitor.GJNoArguVisitor<R> v);
   public <A> void accept(miniX10.visitor.GJVoidVisitor<A> v, A argu);
}

