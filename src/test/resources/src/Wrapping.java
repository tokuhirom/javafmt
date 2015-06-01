public class Wrapping {
	@Override
	public void visit(final ArrayInitializerExpr n, final Object arg) {
		printJavaComment(n.getComment(), arg);
		printer.print("{");
		if (n.getValues() != null) {
			printer.print(" ");
			for (final Iterator<Expression> i = n.getValues().iterator(); i
					.hasNext();) {
				final Expression expr = i.next();
				expr.accept(this, arg);
				if (i.hasNext()) {
					printer.print(", ");
				}
			}
			printer.print(" ");
		}
		printer.print("}");
	}
}
