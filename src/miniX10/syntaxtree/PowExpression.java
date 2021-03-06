//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "Math"
 * nodeToken1 -> "."
 * nodeToken2 -> "pow"
 * nodeToken3 -> "("
 * expression -> Expression()
 * nodeToken4 -> ","
 * expression1 -> Expression()
 * nodeToken5 -> ")"
 */
public class PowExpression implements Node {
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public NodeToken nodeToken2;
   public NodeToken nodeToken3;
   public Expression expression;
   public NodeToken nodeToken4;
   public Expression expression1;
   public NodeToken nodeToken5;

   public PowExpression(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3, Expression n4, NodeToken n5, Expression n6, NodeToken n7) {
      nodeToken = n0;
      nodeToken1 = n1;
      nodeToken2 = n2;
      nodeToken3 = n3;
      expression = n4;
      nodeToken4 = n5;
      expression1 = n6;
      nodeToken5 = n7;
   }

   public PowExpression(Expression n0, Expression n1) {
      nodeToken = new NodeToken("Math");
      nodeToken1 = new NodeToken(".");
      nodeToken2 = new NodeToken("pow");
      nodeToken3 = new NodeToken("(");
      expression = n0;
      nodeToken4 = new NodeToken(",");
      expression1 = n1;
      nodeToken5 = new NodeToken(")");
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

