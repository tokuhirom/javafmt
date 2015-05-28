package me.geso.javafmt;

import java.io.InputStream;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;

public class JavaFmt {
	public String format(InputStream is) throws ParseException {
		CompilationUnit cu = JavaParser.parse(is);
		final JavaFmtVisitor visitor = new JavaFmtVisitor();
		cu.accept(visitor, null);
		return visitor.getSource();
	}
}

