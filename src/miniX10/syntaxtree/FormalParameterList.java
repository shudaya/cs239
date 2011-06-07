//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * formalParameter -> FormalParameter()
 * nodeListOptional -> ( FormalParameterRest() )*
 */
public class FormalParameterList implements Node {
   public FormalParameter formalParameter;
   public NodeListOptional nodeListOptional;

   public FormalParameterList(FormalParameter n0, NodeListOptional n1) {
      formalParameter = n0;
      nodeListOptional = n1;
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
