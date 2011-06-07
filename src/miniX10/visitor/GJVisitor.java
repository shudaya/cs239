//
// Generated by JTB 1.3.2
//

package miniX10.visitor;
import miniX10.syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * nodeListOptional -> ( TopLevelDeclaration() )*
    * nodeToken -> <EOF>
    */
   public R visit(File n, A argu);

   /**
    * nodeChoice -> MainClass()
    *       | ClassDeclaration()
    */
   public R visit(TopLevelDeclaration n, A argu);

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
   public R visit(MainClass n, A argu);

   /**
    * nodeToken -> "class"
    * identifier -> Identifier()
    * nodeToken1 -> "{"
    * nodeListOptional -> ( ClassMember() )*
    * nodeToken2 -> "}"
    */
   public R visit(ClassDeclaration n, A argu);

   /**
    * nodeChoice -> MethodDeclaration()
    *       | ConstantDeclaration()
    *       | UpdatableFieldDeclaration()
    */
   public R visit(ClassMember n, A argu);

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
   public R visit(ConstantDeclaration n, A argu);

   /**
    * nodeToken -> "public"
    * type -> Type()
    * identifier -> Identifier()
    * nodeToken1 -> ";"
    */
   public R visit(UpdatableFieldDeclaration n, A argu);

   /**
    * nodeToken -> "public"
    * returnType -> ReturnType()
    * identifier -> Identifier()
    * nodeToken1 -> "("
    * nodeOptional -> ( FormalParameterList() )?
    * nodeToken2 -> ")"
    * block -> Block()
    */
   public R visit(MethodDeclaration n, A argu);

   /**
    * formalParameter -> FormalParameter()
    * nodeListOptional -> ( FormalParameterRest() )*
    */
   public R visit(FormalParameterList n, A argu);

   /**
    * nodeChoice -> FinalFormalParameter()
    *       | UpdatableFormalParameter()
    */
   public R visit(FormalParameter n, A argu);

   /**
    * nodeToken -> "final"
    * type -> Type()
    * identifier -> Identifier()
    */
   public R visit(FinalFormalParameter n, A argu);

   /**
    * type -> Type()
    * identifier -> Identifier()
    */
   public R visit(UpdatableFormalParameter n, A argu);

   /**
    * nodeToken -> ","
    * formalParameter -> FormalParameter()
    */
   public R visit(FormalParameterRest n, A argu);

   /**
    * nodeChoice -> VoidType()
    *       | Type()
    */
   public R visit(ReturnType n, A argu);

   /**
    * nodeToken -> "void"
    */
   public R visit(VoidType n, A argu);

   /**
    * nodeChoice -> UpdatableArrayType()
    *       | NonArrayType()
    */
   public R visit(Type n, A argu);

   /**
    * nonArrayType -> NonArrayType()
    * nodeToken -> "["
    * nodeToken1 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken2 -> "]"
    */
   public R visit(UpdatableArrayType n, A argu);

   /**
    * nodeToken -> "rank"
    * nodeToken1 -> "=="
    * integerLiteral -> IntegerLiteral()
    */
   public R visit(RankEquation n, A argu);

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
   public R visit(NonArrayType n, A argu);

   /**
    * nodeToken -> "boolean"
    */
   public R visit(BooleanType n, A argu);

   /**
    * nodeToken -> "int"
    */
   public R visit(IntegerType n, A argu);

   /**
    * nodeToken -> "double"
    */
   public R visit(DoubleType n, A argu);

   /**
    * nodeToken -> "String"
    */
   public R visit(StringType n, A argu);

   /**
    * nodeToken -> "place"
    */
   public R visit(PlaceType n, A argu);

   /**
    * nodeToken -> "dist"
    * nodeToken1 -> "("
    * nodeToken2 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken3 -> ")"
    */
   public R visit(DistType n, A argu);

   /**
    * nodeToken -> "region"
    * nodeToken1 -> "("
    * nodeToken2 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken3 -> ")"
    */
   public R visit(RegionType n, A argu);

   /**
    * nodeToken -> "point"
    * nodeToken1 -> "("
    * nodeToken2 -> ":"
    * rankEquation -> RankEquation()
    * nodeToken3 -> ")"
    */
   public R visit(PointType n, A argu);

   /**
    * identifier -> Identifier()
    */
   public R visit(ClassNameType n, A argu);

   /**
    * nodeToken -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu);

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
   public R visit(Statement n, A argu);

   /**
    * expression -> Expression()
    * nodeToken -> "="
    * expression1 -> Expression()
    * nodeToken1 -> ";"
    */
   public R visit(Assignment n, A argu);

   /**
    * nodeToken -> "async"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * block -> Block()
    */
   public R visit(AsyncStatement n, A argu);

   /**
    * nodeToken -> "{"
    * nodeListOptional -> ( BlockStatement() )*
    * nodeToken1 -> "}"
    */
   public R visit(Block n, A argu);

   /**
    * nodeChoice -> FinalVariableDeclaration()
    *       | UpdatableVariableDeclaration()
    *       | Statement()
    */
   public R visit(BlockStatement n, A argu);

   /**
    * nodeToken -> "final"
    * type -> Type()
    * identifier -> Identifier()
    * nodeToken1 -> "="
    * expression -> Expression()
    * nodeToken2 -> ";"
    */
   public R visit(FinalVariableDeclaration n, A argu);

   /**
    * type -> Type()
    * identifier -> Identifier()
    * nodeToken -> "="
    * expression -> Expression()
    * nodeToken1 -> ";"
    */
   public R visit(UpdatableVariableDeclaration n, A argu);

   /**
    * nodeToken -> "finish"
    * statement -> Statement()
    */
   public R visit(FinishStatement n, A argu);

   /**
    * nodeToken -> "if"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * statement -> Statement()
    * nodeOptional -> [ ElseClause() ]
    */
   public R visit(IfStatement n, A argu);

   /**
    * nodeToken -> "else"
    * statement -> Statement()
    */
   public R visit(ElseClause n, A argu);

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
   public R visit(LoopStatement n, A argu);

   /**
    * identifierList -> IdentifierList()
    */
   public R visit(ExplodedSpecification n, A argu);

   /**
    * identifier -> Identifier()
    */
   public R visit(PointName n, A argu);

   /**
    * nodeToken -> "["
    * identifier -> Identifier()
    * nodeListOptional -> ( IdentifierRest() )*
    * nodeToken1 -> "]"
    */
   public R visit(IdentifierList n, A argu);

   /**
    * nodeToken -> ","
    * identifier -> Identifier()
    */
   public R visit(IdentifierRest n, A argu);

   /**
    * expression -> Expression()
    * nodeToken -> ";"
    */
   public R visit(PostfixStatement n, A argu);

   /**
    * nodeToken -> "System.out.println"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * nodeToken3 -> ";"
    */
   public R visit(PrintlnStatement n, A argu);

   /**
    * nodeToken -> "return"
    * nodeOptional -> [ Expression() ]
    * nodeToken1 -> ";"
    */
   public R visit(ReturnStatement n, A argu);

   /**
    * nodeToken -> "throw"
    * nodeToken1 -> "new"
    * nodeToken2 -> "RuntimeException"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    * nodeToken5 -> ";"
    */
   public R visit(ThrowStatement n, A argu);

   /**
    * nodeToken -> "while"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    * statement -> Statement()
    */
   public R visit(WhileStatement n, A argu);

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
   public R visit(Expression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "|"
    * expression -> Expression()
    */
   public R visit(InclusiveOrExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "=="
    * expression -> Expression()
    */
   public R visit(EqualsExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "!="
    * expression -> Expression()
    */
   public R visit(NotEqualsExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> ">"
    * expression -> Expression()
    */
   public R visit(GreaterThanExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "+"
    * expression -> Expression()
    */
   public R visit(PlusExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "-"
    * expression -> Expression()
    */
   public R visit(MinusExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "*"
    * expression -> Expression()
    */
   public R visit(TimesExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "/"
    * expression -> Expression()
    */
   public R visit(DivideExpression n, A argu);

   /**
    * nodeToken -> "Math"
    * nodeToken1 -> "."
    * nodeToken2 -> "sin"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    */
   public R visit(SinExpression n, A argu);

   /**
    * nodeToken -> "Math"
    * nodeToken1 -> "."
    * nodeToken2 -> "cos"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    */
   public R visit(CosExpression n, A argu);

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
   public R visit(PowExpression n, A argu);

   /**
    * nodeToken -> "Math"
    * nodeToken1 -> "."
    * nodeToken2 -> "abs"
    * nodeToken3 -> "("
    * expression -> Expression()
    * nodeToken4 -> ")"
    */
   public R visit(AbsExpression n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "->"
    * primaryExpression1 -> PrimaryExpression()
    */
   public R visit(MapExpression n, A argu);

   /**
    * nodeToken -> "["
    * colonExpression -> ColonExpression()
    * nodeOptional -> ( ColonRest() )?
    * nodeToken1 -> "]"
    */
   public R visit(RegionConstant n, A argu);

   /**
    * nodeToken -> ","
    * colonExpression -> ColonExpression()
    */
   public R visit(ColonRest n, A argu);

   /**
    * nodeChoice -> ColonPair()
    *       | Expression()
    */
   public R visit(ColonExpression n, A argu);

   /**
    * expression -> Expression()
    * nodeToken -> ":"
    * expression1 -> Expression()
    */
   public R visit(ColonPair n, A argu);

   /**
    * nodeToken -> "-"
    * primaryExpression -> PrimaryExpression()
    */
   public R visit(UnaryMinusExpression n, A argu);

   /**
    * nodeToken -> "("
    * nodeToken1 -> "int"
    * nodeToken2 -> ")"
    * expression -> Expression()
    */
   public R visit(CoercionToIntExpression n, A argu);

   /**
    * nodeToken -> "("
    * nodeToken1 -> "double"
    * nodeToken2 -> ")"
    * expression -> Expression()
    */
   public R visit(CoercionToDoubleExpression n, A argu);

   /**
    * nodeToken -> "("
    * typeAnnotation -> TypeAnnotation()
    * nodeToken1 -> ")"
    * expression -> Expression()
    */
   public R visit(TypeAnnotatedExpression n, A argu);

   /**
    * nodeChoice -> UpdatableArrayType()
    *       | DistType()
    */
   public R visit(TypeAnnotation n, A argu);

   /**
    * nodeChoice -> Literal()
    *       | This()
    *       | AllocationExpression()
    *       | Identifier()
    */
   public R visit(PrimaryExpression n, A argu);

   /**
    * nodeToken -> "this"
    */
   public R visit(This n, A argu);

   /**
    * nodeToken -> "dist.factory.block"
    * nodeToken1 -> "("
    * expression -> Expression()
    * nodeToken2 -> ")"
    */
   public R visit(FactoryBlock n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "["
    * expressionList -> ExpressionList()
    * nodeToken1 -> "]"
    */
   public R visit(ArrayAccess n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * identifier -> Identifier()
    * nodeToken1 -> "("
    * nodeOptional -> ( ExpressionList() )?
    * nodeToken2 -> ")"
    */
   public R visit(DotMethodCall n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * nodeToken1 -> "distribution"
    */
   public R visit(DotDistribution n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * nodeToken1 -> "isFirst"
    * nodeToken2 -> "("
    * nodeToken3 -> ")"
    */
   public R visit(DotIsFirst n, A argu);

   /**
    * primaryExpression -> PrimaryExpression()
    * nodeToken -> "."
    * identifier -> Identifier()
    */
   public R visit(DotIdentifier n, A argu);

   /**
    * nodeChoice -> NewObject()
    *       | NewUpdatableArray()
    */
   public R visit(AllocationExpression n, A argu);

   /**
    * nodeToken -> "new"
    * identifier -> Identifier()
    * nodeToken1 -> "("
    * nodeOptional -> [ ExpressionList() ]
    * nodeToken2 -> ")"
    */
   public R visit(NewObject n, A argu);

   /**
    * nodeToken -> "new"
    * nonArrayType -> NonArrayType()
    * nodeToken1 -> "["
    * identifier -> Identifier()
    * nodeToken2 -> "]"
    * nodeOptional -> [ ArrayInitializer() ]
    */
   public R visit(NewUpdatableArray n, A argu);

   /**
    * nodeChoice -> IntegerLiteral()
    *       | FloatingPointLiteral()
    *       | StringLiteral()
    *       | HereLiteral()
    *       | DistUnique()
    */
   public R visit(Literal n, A argu);

   /**
    * nodeToken -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu);

   /**
    * nodeToken -> <FLOATING_POINT_LITERAL>
    */
   public R visit(FloatingPointLiteral n, A argu);

   /**
    * nodeToken -> <STRING_LITERAL>
    */
   public R visit(StringLiteral n, A argu);

   /**
    * nodeToken -> "here"
    */
   public R visit(HereLiteral n, A argu);

   /**
    * nodeToken -> "dist.UNIQUE"
    */
   public R visit(DistUnique n, A argu);

   /**
    * expression -> Expression()
    * nodeListOptional -> ( ArgumentRest() )*
    */
   public R visit(ExpressionList n, A argu);

   /**
    * nodeToken -> ","
    * expression -> Expression()
    */
   public R visit(ArgumentRest n, A argu);

   /**
    * nodeToken -> "("
    * pointType -> PointType()
    * explodedSpecification -> ExplodedSpecification()
    * nodeToken1 -> ")"
    * block -> Block()
    */
   public R visit(ArrayInitializer n, A argu);

}
