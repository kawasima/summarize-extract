package net.unit8.summarize.extract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class ResultSet {
	private List<Sentence> summarySentences;
	private int length = 255;
	private String sort = "score";

	public ResultSet(List<Token> tokens, List<Sentence> sentences) {
		summarySentences = new ArrayList<Sentence>();
		for(Sentence sentence : sentences) {
			double score = 0;
			for(Token token : tokens) {
				String[] words = token.getTerm().split("\\s");
				Map<String, Integer> tmp = new HashMap<String, Integer>();
				double tmpScore = 0;
				for(String word : words){
					Pattern ptn = Pattern.compile("("+Pattern.quote(word)+")");
					Matcher m = ptn.matcher(sentence.getText());
					while(m.find()) {
						tmpScore += token.getScore();
						tmp.put(word, 1);
					}
				}
				if(words.length == tmp.size())
					score += tmpScore;
			}
			sentence.setScore(score);
			summarySentences.add(sentence);
		}
		Collections.sort(summarySentences, new Comparator<Sentence>() {
			public int compare(Sentence s1, Sentence s2) {
				return (int)Math.round(s2.getScore() - s1.getScore());
			}
		});
	}

	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		List<Sentence> result = new ArrayList<Sentence>();
		for(Sentence sentence : summarySentences){
			result.add(sentence);
			text.append(sentence.getText()).append("\n");
			if(text.length() > length)
				break;
		}

		if(!StringUtils.equals(sort, "score")) {
			text.setLength(0);
			Collections.sort(result, new Comparator<Sentence>() {
				public int compare(Sentence s1, Sentence s2) {
					return s1.getLine() - s2.getLine();
				}
			});
			for(Sentence sentence : result) {
				text.append(sentence.getText()).append("\n");
			}
		}
		return text.toString();
	}
}
