//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "region"
 * nodeToken1 -> "("
 * nodeToken2 -> ":"
 * rankEquation -> RankEquation()
 * nodeToken3 -> ")"
 */
public class RegionType implements Node {
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public NodeToken nodeToken2;
   public RankEquation rankEquation;
   public NodeToken nodeToken3;

   public RegionType(NodeToken n0, NodeToken n1, NodeToken n2, RankEquation n3, NodeToken n4) {
      nodeToken = n0;
      nodeToken1 = n1;
      nodeToken2 = n2;
      rankEquation = n3;
      nodeToken3 = n4;
   }

   public RegionType(RankEquation n0) {
      nodeToken = new NodeToken("region");
      nodeToken1 = new NodeToken("(");
      nodeToken2 = new NodeToken(":");
      rankEquation = n0;
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

