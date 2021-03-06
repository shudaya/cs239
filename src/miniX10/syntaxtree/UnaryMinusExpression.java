//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "-"
 * primaryExpression -> PrimaryExpression()
 */
public class UnaryMinusExpression implements Node {
   public NodeToken nodeToken;
   public PrimaryExpression primaryExpression;

   public UnaryMinusExpression(NodeToken n0, PrimaryExpression n1) {
      nodeToken = n0;
      primaryExpression = n1;
   }

   public UnaryMinusExpression(PrimaryExpression n0) {
      nodeToken = new NodeToken("-");
      primaryExpression = n0;
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

