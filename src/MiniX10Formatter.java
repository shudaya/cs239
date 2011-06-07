import miniX10.syntaxtree.*;
import miniX10.visitor.*;

public class MiniX10Formatter extends TreeFormatter {
	public MiniX10Formatter() {
		super(4, 0);
	}
//	protected void processList(NodeListInterface n) {
//		processList(n, force());
//	}
	public void visit(Type t) {
		super.visit(t);
		add(space());
	}
	public void visit(Block b) {
		b.nodeToken.accept(this);
		add(indent());
		b.nodeListOptional.accept(this);
		add(outdent());
		add(force());
		b.nodeToken1.accept(this);
	}
	public void visit(ReturnStatement rs) {
		rs.nodeToken.accept(this);
		add(space());
		rs.nodeOptional.accept(this);
		rs.nodeToken1.accept(this);
	}
	public void visit(BlockStatement bs) {
		add(force());
		bs.nodeChoice.accept(this);
	}
	public void visit(FinalVariableDeclaration fvd) {
		fvd.nodeToken.accept(this);
		add(space());
		fvd.type.accept(this);
		fvd.identifier.accept(this);
		add(space());
		fvd.nodeToken1.accept(this);
		add(space());
		fvd.expression.accept(this);
		fvd.nodeToken2.accept(this);
	}
	public void visit(UpdatableVariableDeclaration uvd) {
		uvd.type.accept(this);
		uvd.identifier.accept(this);
		add(space());
		uvd.nodeToken.accept(this);
		add(space());
		uvd.expression.accept(this);
		uvd.nodeToken1.accept(this);
	}
	public void visit(UpdatableFieldDeclaration ufd) {
		ufd.nodeToken.accept(this);
		add(space());
		ufd.type.accept(this);
		ufd.identifier.accept(this);
		ufd.nodeToken1.accept(this);
		add(force());
	}
	public void visit(ClassDeclaration cd) {
		cd.nodeToken.accept(this);
		add(space());
		cd.identifier.accept(this);
		cd.nodeToken1.accept(this);
		add(indent());
		add(force());
		cd.nodeListOptional.accept(this);
		add(force());
		cd.nodeToken2.accept(this);
		add(outdent());
		add(force());
	}
	public void visit(MethodDeclaration md) {
		md.nodeToken.accept(this);
		add(space());
		md.returnType.accept(this);
		add(space());
		md.identifier.accept(this);
		md.nodeToken1.accept(this);
		md.nodeOptional.accept(this);
		md.nodeToken2.accept(this);
		md.block.accept(this);
		add(force());
	}
	public void visit(Assignment a) {
		a.expression.accept(this);
		add(space());
		a.nodeToken.accept(this);
		add(space());
		a.expression1.accept(this);
		a.nodeToken1.accept(this);
	}
	public void visit(MainClass mc) {
		visit(mc.nodeToken);
		add(space());
		visit(mc.nodeToken1);
		add(space());
		visit(mc.identifier);
		add(space());
		visit(mc.nodeToken2);
		add(indent());
		add(force());
		visit(mc.nodeToken3);
		add(space());
		visit(mc.nodeToken4);
		add(space());
		visit(mc.nodeToken5);
		add(space());
		visit(mc.nodeToken6);
		visit(mc.nodeToken7);
		visit(mc.nodeToken8);
		visit(mc.nodeToken9);
		visit(mc.nodeToken10);
		add(space());
		visit(mc.identifier1);
		visit(mc.nodeToken11);
		add(space());
		visit(mc.nodeToken12);
		add(indent());
		add(force());
		visit(mc.statement);
		add(outdent());
		add(force());
		visit(mc.nodeToken13);
		add(outdent());
		add(force());
		visit(mc.nodeToken14);
		add(force());
	}
}
