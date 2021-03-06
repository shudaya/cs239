//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "Math"
 * nodeToken1 -> "."
 * nodeToken2 -> "abs"
 * nodeToken3 -> "("
 * expression -> Expression()
 * nodeToken4 -> ")"
 */
public class AbsExpression implements Node {
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public NodeToken nodeToken2;
   public NodeToken nodeToken3;
   public Expression expression;
   public NodeToken nodeToken4;

   public AbsExpression(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3, Expression n4, NodeToken n5) {
      nodeToken = n0;
      nodeToken1 = n1;
      nodeToken2 = n2;
      nodeToken3 = n3;
      expression = n4;
      nodeToken4 = n5;
   }

   public AbsExpression(Expression n0) {
      nodeToken = new NodeToken("Math");
      nodeToken1 = new NodeToken(".");
      nodeToken2 = new NodeToken("abs");
      nodeToken3 = new NodeToken("(");
      expression = n0;
      nodeToken4 = new NodeToken(")");
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

