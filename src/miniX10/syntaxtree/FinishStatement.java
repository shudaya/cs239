//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "finish"
 * statement -> Statement()
 */
public class FinishStatement implements Node {
   public NodeToken nodeToken;
   public Statement statement;

   public FinishStatement(NodeToken n0, Statement n1) {
      nodeToken = n0;
      statement = n1;
   }

   public FinishStatement(Statement n0) {
      nodeToken = new NodeToken("finish");
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

