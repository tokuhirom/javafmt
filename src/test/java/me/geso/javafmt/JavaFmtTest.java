package me.geso.javafmt;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.javaparser.ParseException;

@RunWith(Parameterized.class)
public class JavaFmtTest {

	private final String file;

	@Parameters(name = "{index}: {0} ")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"src/Foo.java"},
				{"src/SwitchCase.java"},
				{"src/MethodParameters.java"},
				{"src/Field.java"},
				{"src/Wrapping.java"},
				{"src/Visit.java"},
				{"src/ForStmt.java"},
				{"src/JavaFmtVisitor2.java"}
		});
	}

	public JavaFmtTest(String file) {
		this.file = file;
	}

	@Test
	public void test() throws IOException, ParseException {
		final JavaFmt javaFmt = new JavaFmt();

		// get original code
		final InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream(file);
		final String expected = IOUtils.toString(inputStream2);
		Assert.assertNotNull(inputStream2);

		// generate formatted code
		final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
		final String got = javaFmt.format(inputStream);

		// compare these sources
		assertEquals(file, expected, got);
	}
}

