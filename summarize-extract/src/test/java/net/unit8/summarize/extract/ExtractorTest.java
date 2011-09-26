package net.unit8.summarize.extract;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class ExtractorTest extends Extractor {

	@Test
	public void testSample1() throws IOException {
		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("sample2.txt");
		String text = StringUtils.join(IOUtils.readLines(input, "UTF-8"), "\n");
		ResultSet rs = new Extractor().setLength(10).extract(text);
		System.out.println(rs.toString());
	}

}
