//
// Generated by JTB 1.3.2
//

package miniX10.syntaxtree;

/**
 * Grammar production:
 * nodeToken -> "class"
 * identifier -> Identifier()
 * nodeToken1 -> "{"
 * nodeListOptional -> ( ClassMember() )*
 * nodeToken2 -> "}"
 */
public class ClassDeclaration implements Node {
   public NodeToken nodeToken;
   public Identifier identifier;
   public NodeToken nodeToken1;
   public NodeListOptional nodeListOptional;
   public NodeToken nodeToken2;

   public ClassDeclaration(NodeToken n0, Identifier n1, NodeToken n2, NodeListOptional n3, NodeToken n4) {
      nodeToken = n0;
      identifier = n1;
      nodeToken1 = n2;
      nodeListOptional = n3;
      nodeToken2 = n4;
   }

   public ClassDeclaration(Identifier n0, NodeListOptional n1) {
      nodeToken = new NodeToken("class");
      identifier = n0;
      nodeToken1 = new NodeToken("{");
      nodeListOptional = n1;
      nodeToken2 = new NodeToken("}");
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

