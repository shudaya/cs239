//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * primaryExpression -> PrimaryExpression()
 * nodeToken -> "."
 * nodeToken1 -> "isFirst"
 * nodeToken2 -> "("
 * nodeToken3 -> ")"
 */
public class DotIsFirst implements Node {
   public PrimaryExpression primaryExpression;
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public NodeToken nodeToken2;
   public NodeToken nodeToken3;

   public DotIsFirst(PrimaryExpression n0, NodeToken n1, NodeToken n2, NodeToken n3, NodeToken n4) {
      primaryExpression = n0;
      nodeToken = n1;
      nodeToken1 = n2;
      nodeToken2 = n3;
      nodeToken3 = n4;
   }

   public DotIsFirst(PrimaryExpression n0) {
      primaryExpression = n0;
      nodeToken = new NodeToken(".");
      nodeToken1 = new NodeToken("isFirst");
      nodeToken2 = new NodeToken("(");
      nodeToken3 = new NodeToken(")");
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

