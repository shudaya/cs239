//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * primaryExpression -> PrimaryExpression()
 * nodeToken -> "."
 * identifier -> Identifier()
 */
public class DotIdentifier implements Node {
   public PrimaryExpression primaryExpression;
   public NodeToken nodeToken;
   public Identifier identifier;

   public DotIdentifier(PrimaryExpression n0, NodeToken n1, Identifier n2) {
      primaryExpression = n0;
      nodeToken = n1;
      identifier = n2;
   }

   public DotIdentifier(PrimaryExpression n0, Identifier n1) {
      primaryExpression = n0;
      nodeToken = new NodeToken(".");
      identifier = n1;
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
