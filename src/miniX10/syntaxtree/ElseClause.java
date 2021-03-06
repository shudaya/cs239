//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "else"
 * statement -> Statement()
 */
public class ElseClause implements Node {
   public NodeToken nodeToken;
   public Statement statement;

   public ElseClause(NodeToken n0, Statement n1) {
      nodeToken = n0;
      statement = n1;
   }

   public ElseClause(Statement n0) {
      nodeToken = new NodeToken("else");
      statement = n0;
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

