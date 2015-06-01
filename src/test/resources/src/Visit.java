public class Visit {
	@Override
	public void visit(final TryStmt n, final Object arg) {
		printJavaComment(n.getComment(), arg);
		printer.print("try ");
		if (!n.getResources().isEmpty()) {
			printer.print("(");
			Iterator<VariableDeclarationExpr> resources = n.getResources()
					.iterator();
		}
	}
}
