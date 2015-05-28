package me.geso.javafmt;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.github.javaparser.ParseException;

public class JavaFmtTest {
	@Test
	public void test() throws IOException, ParseException {
		final String[] files = {
				"src/Foo.java",
				"src/JavaFmtVisitor.java"
		};
		final JavaFmt javaFmt = new JavaFmt();
		for (final String file : files) {
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
}

