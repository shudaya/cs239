//
// Generated by JTB 1.3.2
//

package miniX10.visitor;
import miniX10.syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJVoidDepthFirst<A> implements GJVoidVisitor<A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public void visit(NodeList n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
      }
   }

   public void visit(NodeOptional n, A argu) {
      if ( n.present() )
         n.node.accept(this,argu);
   }

   public void visit(NodeSequence n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeToken n, A argu) {}

   //
   // User-generated visitor methods below
   //

   /**
    * nodeListOptional -> ( TopLevelDeclaration() )*
    * nodeToken -> <EOF>
    */
   public void visit(File n, A argu) {
      n.nodeListOptional.accept(this, argu);
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeChoice -> MainClass()
    *       | ClassDeclaration()
    */
   public void visit(TopLevelDeclaration n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "public"
    * nodeToken1 -> "class"
    * identifier -> Identifier()
    * nodeToken2 -> "{"
    * nodeToken3 -> "public"
    * nodeToken4 -> "static"
    * nodeToken5 -> "void"
    * nodeToken6 -> "main"
    * nodeToken7 -> "("
    * nodeToken8 -> "String"
    * nodeToken9 -> "["
    * nodeToken10 -> "]"
    * identifier1 -> Identifier()
    * nodeToken11 -> ")"
    * nodeToken12 -> "{"
    * statement -> Statement()
    * nodeToken13 -> "}"
    * nodeToken14 -> "}"
    */
   public void visit(MainClass n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.nodeToken4.accept(this, argu);
      n.nodeToken5.accept(this, argu);
      n.nodeToken6.accept(this, argu);
      n.nodeToken7.accept(this, argu);
      n.nodeToken8.accept(this, argu);
      n.nodeToken9.accept(this, argu);
      n.nodeToken10.accept(this, argu);
      n.identifier1.accept(this, argu);
      n.nodeToken11.accept(this, argu);
      n.nodeToken12.accept(this, argu);
      n.statement.accept(this, argu);
      n.nodeToken13.accept(this, argu);
      n.nodeToken14.accept(this, argu);
   }

   /**
    * nodeToken -> "class"
    * identifier -> Identifier()
    * nodeToken1 -> "{"
    * nodeListOptional -> ( ClassMember() )*
    * nodeToken2 -> "}"
    */
   public void visit(ClassDeclaration n, A argu) {
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
   }

   /**
    * nodeChoice -> MethodDeclaration()
    *       | ConstantDeclaration()
    *       | UpdatableFieldDeclaration()
    */
   public void visit(ClassMember n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "public"
    * nodeToken1 -> "static"
    * nodeToken2 -> "final"
    * type -> Type()
    * identifier -> Identifier()
    * nodeToken3 -> "="
    * expression -> Expression()
    * nodeToken4 -> ";"
    */
   public void visit(ConstantDeclaration n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.type.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken4.accept(this, argu);
   }

   /**
    * nodeToken -> "public"
    * type -> Type()
    * identifier -> Identifier()
    * nodeToken1 -> ";"
    */
   public void visit(UpdatableFieldDeclaration n, A argu) {
      n.nodeToken.accept(this, argu);
      n.type.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * nodeToken -> "public"
    * returnType -> ReturnType()
    * identifier -> Identifier()
    * nodeToken1 -> "("
    * nodeOptional -> ( FormalParameterList() )?
    * nodeToken2 -> ")"
    * block -> Block()
    */
   public void visit(MethodDeclaration n, A argu) {
      n.nodeToken.accept(this, argu);
      n.returnType.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.block.accept(this, argu);
   }

   /**
    * formalParameter -> FormalParameter()
    * nodeListOptional -> ( FormalParameterRest() )*
    */
   public void visit(FormalParameterList n, A argu) {
      n.formalParameter.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
   }

   /**
    * nodeChoice -> FinalFormalParameter()
    *       | UpdatableFormalParameter()
    */
   public void visit(FormalParameter n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "final"
    * type -> Type()
    * identifier -> Identifier()
    */
   public void visit(FinalFormalParameter n, A argu) {
      n.nodeToken.accept(this, argu);
      n.type.accept(this, argu);
      n.identifier.accept(this, argu);
   }

   /**
    * type -> Type()
    * identifier -> Identifier()
    */
   public void visit(UpdatableFormalParameter n, A argu) {
      n.type.accept(this, argu);
      n.identifier.accept(this, argu);
   }

   /**
    * nodeToken -> ","
    * formalParameter -> FormalParameter()
    */
   public void visit(FormalParameterRest n, A argu) {
      n.nodeToken.accept(this, argu);
      n.formalParameter.accept(this, argu);
   }

   /**
    * nodeChoice -> VoidType()
    *       | Type()
    */
   public void visit(ReturnType n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "void"
    */
   public void visit(VoidType n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeChoice -> UpdatableArrayType()
    *       | NonArrayType()
    */
   public void visit(Type n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nonArrayType -> NonArrayType()
    * nodeToken -> "["
    * nodeToken1 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken2 -> "]"
    */
   public void visit(UpdatableArrayType n, A argu) {
      n.nonArrayType.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.rankEquation.accept(this, argu);
      n.nodeToken2.accept(this, argu);
   }

   /**
    * nodeToken -> "rank"
    * nodeToken1 -> "=="
    * integerLiteral -> IntegerLiteral()
    */
   public void visit(RankEquation n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.integerLiteral.accept(this, argu);
   }

   /**
    * nodeChoice -> BooleanType()
    *       | IntegerType()
    *       | DoubleType()
    *       | StringType()
    *       | PlaceType()
    *       | DistType()
    *       | RegionType()
    *       | PointType()
    *       | ClassNameType()
    */
   public void visit(NonArrayType n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "boolean"
    */
   public void visit(BooleanType n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "int"
    */
   public void visit(IntegerType n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "double"
    */
   public void visit(DoubleType n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "String"
    */
   public void visit(StringType n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "place"
    */
   public void visit(PlaceType n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "dist"
    * nodeToken1 -> "("
    * nodeToken2 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken3 -> ")"
    */
   public void visit(DistType n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.rankEquation.accept(this, argu);
      n.nodeToken3.accept(this, argu);
   }

   /**
    * nodeToken -> "region"
    * nodeToken1 -> "("
    * nodeToken2 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken3 -> ")"
    */
   public void visit(RegionType n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.rankEquation.accept(this, argu);
      n.nodeToken3.accept(this, argu);
   }

   /**
    * nodeToken -> "point"
    * nodeToken1 -> "("
    * nodeToken2 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken3 -> ")"
    */
   public void visit(PointType n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.rankEquation.accept(this, argu);
      n.nodeToken3.accept(this, argu);
   }

   /**
    * identifier -> Identifier()
    */
   public void visit(ClassNameType n, A argu) {
      n.identifier.accept(this, argu);
   }

   /**
    * nodeToken -> <IDENTIFIER>
    */
   public void visit(Identifier n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeChoice -> Assignment()
    *       | AsyncStatement()
    *       | Block()
    *       | FinishStatement()
    *       | IfStatement()
    *       | LoopStatement()
    *       | PostfixStatement()
    *       | PrintlnStatement()
    *       | ReturnStatement()
    *       | ThrowStatement()
    *       | WhileStatement()
    */
   public void visit(Statement n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * expression -> Expression()
    * nodeToken -> "="
    * expression1 -> Expression()
    * nodeToken1 -> ";"
    */
   public void visit(Assignment n, A argu) {
      n.expression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression1.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * nodeToken -> "async"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * block -> Block()
    */
   public void visit(AsyncStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.block.accept(this, argu);
   }

   /**
    * nodeToken -> "{"
    * nodeListOptional -> ( BlockStatement() )*
    * nodeToken1 -> "}"
    */
   public void visit(Block n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * nodeChoice -> FinalVariableDeclaration()
    *       | UpdatableVariableDeclaration()
    *       | Statement()
    */
   public void visit(BlockStatement n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "final"
    * type -> Type()
    * identifier -> Identifier()
    * nodeToken1 -> "="
    * expression -> Expression()
    * nodeToken2 -> ";"
    */
   public void visit(FinalVariableDeclaration n, A argu) {
      n.nodeToken.accept(this, argu);
      n.type.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken2.accept(this, argu);
   }

   /**
    * type -> Type()
    * identifier -> Identifier()
    * nodeToken -> "="
    * expression -> Expression()
    * nodeToken1 -> ";"
    */
   public void visit(UpdatableVariableDeclaration n, A argu) {
      n.type.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * nodeToken -> "finish"
    * statement -> Statement()
    */
   public void visit(FinishStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.statement.accept(this, argu);
   }

   /**
    * nodeToken -> "if"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * statement -> Statement()
    * nodeOptional -> [ ElseClause() ]
    */
   public void visit(IfStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.statement.accept(this, argu);
      n.nodeOptional.accept(this, argu);
   }

   /**
    * nodeToken -> "else"
    * statement -> Statement()
    */
   public void visit(ElseClause n, A argu) {
      n.nodeToken.accept(this, argu);
      n.statement.accept(this, argu);
   }

   /**
    * nodeToken -> "for"
    * nodeToken1 -> "("
    * pointType -> PointType()
    * explodedSpecification -> ExplodedSpecification()
    * nodeToken2 -> ":"
    * expression -> Expression()
    * nodeToken3 -> ")"
    * statement -> Statement()
    */
   public void visit(LoopStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.pointType.accept(this, argu);
      n.explodedSpecification.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.statement.accept(this, argu);
   }

   /**
    * identifierList -> IdentifierList()
    */
   public void visit(ExplodedSpecification n, A argu) {
      n.identifierList.accept(this, argu);
   }

   /**
    * identifier -> Identifier()
    */
   public void visit(PointName n, A argu) {
      n.identifier.accept(this, argu);
   }

   /**
    * nodeToken -> "["
    * identifier -> Identifier()
    * nodeListOptional -> ( IdentifierRest() )*
    * nodeToken1 -> "]"
    */
   public void visit(IdentifierList n, A argu) {
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * nodeToken -> ","
    * identifier -> Identifier()
    */
   public void visit(IdentifierRest n, A argu) {
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
   }

   /**
    * expression -> Expression()
    * nodeToken -> ";"
    */
   public void visit(PostfixStatement n, A argu) {
      n.expression.accept(this, argu);
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "System.out.println"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * nodeToken3 -> ";"
    */
   public void visit(PrintlnStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
   }

   /**
    * nodeToken -> "return"
    * nodeOptional -> [ Expression() ]
    * nodeToken1 -> ";"
    */
   public void visit(ReturnStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * nodeToken -> "throw"
    * nodeToken1 -> "new"
    * nodeToken2 -> "RuntimeException"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    * nodeToken5 -> ";"
    */
   public void visit(ThrowStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken4.accept(this, argu);
      n.nodeToken5.accept(this, argu);
   }

   /**
    * nodeToken -> "while"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * statement -> Statement()
    */
   public void visit(WhileStatement n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.statement.accept(this, argu);
   }

   /**
    * nodeChoice -> InclusiveOrExpression()
    *       | EqualsExpression()
    *       | NotEqualsExpression()
    *       | GreaterThanExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | DivideExpression()
    *       | SinExpression()
    *       | CosExpression()
    *       | PowExpression()
    *       | AbsExpression()
    *       | MapExpression()
    *       | RegionConstant()
    *       | UnaryMinusExpression()
    *       | CoercionToIntExpression()
    *       | CoercionToDoubleExpression()
    *       | TypeAnnotatedExpression()
    *       | FactoryBlock()
    *       | ArrayAccess()
    *       | DotDistribution()
    *       | DotIsFirst()
    *       | DotMethodCall()
    *       | DotIdentifier()
    *       | PrimaryExpression()
    */
   public void visit(Expression n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "|"
    * expression -> Expression()
    */
   public void visit(InclusiveOrExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "=="
    * expression -> Expression()
    */
   public void visit(EqualsExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "!="
    * expression -> Expression()
    */
   public void visit(NotEqualsExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> ">"
    * expression -> Expression()
    */
   public void visit(GreaterThanExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "+"
    * expression -> Expression()
    */
   public void visit(PlusExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "-"
    * expression -> Expression()
    */
   public void visit(MinusExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "*"
    * expression -> Expression()
    */
   public void visit(TimesExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "/"
    * expression -> Expression()
    */
   public void visit(DivideExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * nodeToken -> "Math"
    * nodeToken1 -> "."
    * nodeToken2 -> "sin"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    */
   public void visit(SinExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken4.accept(this, argu);
   }

   /**
    * nodeToken -> "Math"
    * nodeToken1 -> "."
    * nodeToken2 -> "cos"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    */
   public void visit(CosExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken4.accept(this, argu);
   }

   /**
    * nodeToken -> "Math"
    * nodeToken1 -> "."
    * nodeToken2 -> "pow"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ","
    * expression1 -> Expression()
    * nodeToken5 -> ")"
    */
   public void visit(PowExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken4.accept(this, argu);
      n.expression1.accept(this, argu);
      n.nodeToken5.accept(this, argu);
   }

   /**
    * nodeToken -> "Math"
    * nodeToken1 -> "."
    * nodeToken2 -> "abs"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    */
   public void visit(AbsExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken4.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "->"
    * primaryExpression1 -> PrimaryExpression()
    */
   public void visit(MapExpression n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.primaryExpression1.accept(this, argu);
   }

   /**
    * nodeToken -> "["
    * colonExpression -> ColonExpression()
    * nodeOptional -> ( ColonRest() )?
    * nodeToken1 -> "]"
    */
   public void visit(RegionConstant n, A argu) {
      n.nodeToken.accept(this, argu);
      n.colonExpression.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * nodeToken -> ","
    * colonExpression -> ColonExpression()
    */
   public void visit(ColonRest n, A argu) {
      n.nodeToken.accept(this, argu);
      n.colonExpression.accept(this, argu);
   }

   /**
    * nodeChoice -> ColonPair()
    *       | Expression()
    */
   public void visit(ColonExpression n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * expression -> Expression()
    * nodeToken -> ":"
    * expression1 -> Expression()
    */
   public void visit(ColonPair n, A argu) {
      n.expression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expression1.accept(this, argu);
   }

   /**
    * nodeToken -> "-"
    * primaryExpression -> PrimaryExpression()
    */
   public void visit(UnaryMinusExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.primaryExpression.accept(this, argu);
   }

   /**
    * nodeToken -> "("
    * nodeToken1 -> "int"
    * nodeToken2 -> ")"
    * expression -> Expression()
    */
   public void visit(CoercionToIntExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * nodeToken -> "("
    * nodeToken1 -> "double"
    * nodeToken2 -> ")"
    * expression -> Expression()
    */
   public void visit(CoercionToDoubleExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * nodeToken -> "("
    * typeAnnotation -> TypeAnnotation()
    * nodeToken1 -> ")"
    * expression -> Expression()
    */
   public void visit(TypeAnnotatedExpression n, A argu) {
      n.nodeToken.accept(this, argu);
      n.typeAnnotation.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * nodeChoice -> UpdatableArrayType()
    *       | DistType()
    */
   public void visit(TypeAnnotation n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeChoice -> Literal()
    *       | This()
    *       | AllocationExpression()
    *       | Identifier()
    */
   public void visit(PrimaryExpression n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "this"
    */
   public void visit(This n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "dist.factory.block"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    */
   public void visit(FactoryBlock n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.expression.accept(this, argu);
      n.nodeToken2.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "["
    * expressionList -> ExpressionList()
    * nodeToken1 -> "]"
    */
   public void visit(ArrayAccess n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.expressionList.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * identifier -> Identifier()
    * nodeToken1 -> "("
    * nodeOptional -> ( ExpressionList() )?
    * nodeToken2 -> ")"
    */
   public void visit(DotMethodCall n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * nodeToken1 -> "distribution"
    */
   public void visit(DotDistribution n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * nodeToken1 -> "isFirst"
    * nodeToken2 -> "("
    * nodeToken3 -> ")"
    */
   public void visit(DotIsFirst n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeToken3.accept(this, argu);
   }

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * identifier -> Identifier()
    */
   public void visit(DotIdentifier n, A argu) {
      n.primaryExpression.accept(this, argu);
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
   }

   /**
    * nodeChoice -> NewObject()
    *       | NewUpdatableArray()
    */
   public void visit(AllocationExpression n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> "new"
    * identifier -> Identifier()
    * nodeToken1 -> "("
    * nodeOptional -> [ ExpressionList() ]
    * nodeToken2 -> ")"
    */
   public void visit(NewObject n, A argu) {
      n.nodeToken.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.nodeOptional.accept(this, argu);
      n.nodeToken2.accept(this, argu);
   }

   /**
    * nodeToken -> "new"
    * nonArrayType -> NonArrayType()
    * nodeToken1 -> "["
    * identifier -> Identifier()
    * nodeToken2 -> "]"
    * nodeOptional -> [ ArrayInitializer() ]
    */
   public void visit(NewUpdatableArray n, A argu) {
      n.nodeToken.accept(this, argu);
      n.nonArrayType.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.identifier.accept(this, argu);
      n.nodeToken2.accept(this, argu);
      n.nodeOptional.accept(this, argu);
   }

   /**
    * nodeChoice -> IntegerLiteral()
    *       | FloatingPointLiteral()
    *       | StringLiteral()
    *       | HereLiteral()
    *       | DistUnique()
    */
   public void visit(Literal n, A argu) {
      n.nodeChoice.accept(this, argu);
   }

   /**
    * nodeToken -> <INTEGER_LITERAL>
    */
   public void visit(IntegerLiteral n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> <FLOATING_POINT_LITERAL>
    */
   public void visit(FloatingPointLiteral n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> <STRING_LITERAL>
    */
   public void visit(StringLiteral n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "here"
    */
   public void visit(HereLiteral n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * nodeToken -> "dist.UNIQUE"
    */
   public void visit(DistUnique n, A argu) {
      n.nodeToken.accept(this, argu);
   }

   /**
    * expression -> Expression()
    * nodeListOptional -> ( ArgumentRest() )*
    */
   public void visit(ExpressionList n, A argu) {
      n.expression.accept(this, argu);
      n.nodeListOptional.accept(this, argu);
   }

   /**
    * nodeToken -> ","
    * expression -> Expression()
    */
   public void visit(ArgumentRest n, A argu) {
      n.nodeToken.accept(this, argu);
      n.expression.accept(this, argu);
   }

   /**
    * nodeToken -> "("
    * pointType -> PointType()
    * explodedSpecification -> ExplodedSpecification()
    * nodeToken1 -> ")"
    * block -> Block()
    */
   public void visit(ArrayInitializer n, A argu) {
      n.nodeToken.accept(this, argu);
      n.pointType.accept(this, argu);
      n.explodedSpecification.accept(this, argu);
      n.nodeToken1.accept(this, argu);
      n.block.accept(this, argu);
   }

}