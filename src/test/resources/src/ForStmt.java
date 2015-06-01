public class ForStmt {
	private void printTypeArgs(final List<Type> args, final Object arg) {
		if (!isNullOrEmpty(args)) {
			printer.print("<");
			for (final Iterator<Type> i = args.iterator(); i.hasNext();) {
				final Type t = i.next();
				t.accept(this, arg);
				if (i.hasNext()) {
					printer.print(", ");
				}
			}
			printer.print(">");
		}
	}
}
