package net.unit8.summarize.extract;

import java.util.Map;

import org.junit.Test;

public class NgramParserTest extends NgramParser {
	@Test
	public void test() {
		NgramParser parser = new NgramParser();
		Map<String, Integer> termList = parser.parse("日本語の文章を適当に書く。Japanese sentence テキトウにカキまーす。");
		System.out.println(termList);
	}

}
