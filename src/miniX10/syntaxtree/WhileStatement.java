//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "while"
 * nodeToken1 -> "("
 * expression -> Expression()
 * nodeToken2 -> ")"
 * statement -> Statement()
 */
public class WhileStatement implements Node {
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public Expression expression;
   public NodeToken nodeToken2;
   public Statement statement;

   public WhileStatement(NodeToken n0, NodeToken n1, Expression n2, NodeToken n3, Statement n4) {
      nodeToken = n0;
      nodeToken1 = n1;
      expression = n2;
      nodeToken2 = n3;
      statement = n4;
   }

   public WhileStatement(Expression n0, Statement n1) {
      nodeToken = new NodeToken("while");
      nodeToken1 = new NodeToken("(");
      expression = n0;
      nodeToken2 = new NodeToken(")");
      statement = n1;
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

