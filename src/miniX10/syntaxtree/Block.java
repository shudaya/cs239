//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "{"
 * nodeListOptional -> ( BlockStatement() )*
 * nodeToken1 -> "}"
 */
public class Block implements Node {
   public NodeToken nodeToken;
   public NodeListOptional nodeListOptional;
   public NodeToken nodeToken1;

   public Block(NodeToken n0, NodeListOptional n1, NodeToken n2) {
      nodeToken = n0;
      nodeListOptional = n1;
      nodeToken1 = n2;
   }

   public Block(NodeListOptional n0) {
      nodeToken = new NodeToken("{");
      nodeListOptional = n0;
      nodeToken1 = new NodeToken("}");
   }

   public void accept(miniX10.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(miniX10.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(miniX10.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(miniX10.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

