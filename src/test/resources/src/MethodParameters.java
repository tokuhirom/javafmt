import com.github.javaparser.ast.TypeParameter;

public class Foo {
	private void printTypeParameters(final List<TypeParameter> args,
			final Object arg) {
	}

	private void printTypeParameters(final List<TypeParameter> args,
			final List<TypeParameter> foo,
			final Object arg) {
	}

	private void printTypeParameters(final List<TypeParameter> args,
			final List<TypeParameter> foo,
			final Object arg,
			int i,
			long j) {
	}
}
