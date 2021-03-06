//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Represents a grammar choice, e.g. ( A | B )
 */
public class NodeChoice implements Node {
   public NodeChoice(Node node) {
      this(node, -1);
   }

   public NodeChoice(Node node, int whichChoice) {
      choice = node;
      which = whichChoice;
   }

   public void accept(miniX10.visitor.Visitor v) {
      choice.accept(v);
   }
   public <R,A> R accept(miniX10.visitor.GJVisitor<R,A> v, A argu) {
      return choice.accept(v,argu);
   }
   public <R> R accept(miniX10.visitor.GJNoArguVisitor<R> v) {
      return choice.accept(v);
   }
   public <A> void accept(miniX10.visitor.GJVoidVisitor<A> v, A argu) {
      choice.accept(v,argu);
   }

   public Node choice;
   public int which;
}

