package net.unit8.summarize.extract;

import java.util.List;
import java.util.Map;

public class Extractor {
	private Scoring scoring;
	private Parser parser;
	private SentenceUtil sentenceUtil;
	private int length = 255;

	public Extractor() {
		scoring = new DefaultScoring();
		parser  = new NgramParser();
		sentenceUtil = new DefaultSentenceUtil();
	}

	public Extractor setLength(int length) {
		this.length = length;
		return this;
	}

	public ResultSet extract(String text) {
		List<Sentence> sentences = sentenceUtil.split(text);
		Map<String, Integer> termList = parser.parse(text);
		List<Token> summary = scoring.scoring(termList);
		ResultSet rs =  new ResultSet(summary, sentences);
		rs.setLength(length);
		return rs;
	}
}
