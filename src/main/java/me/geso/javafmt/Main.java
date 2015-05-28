package me.geso.javafmt;

import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.ParseException;

public class Main {
	public static void main(String[] args) throws ParseException,
			IOException {
		final JavaFmt javaFmt = new JavaFmt();
		if (args.length == 0) {
			System.out.println(javaFmt.format(System.in));
		} else {
			try (FileInputStream fis = new FileInputStream(args[0])) {
				System.out.println(javaFmt.format(fis));
			}
		}
	}
}

