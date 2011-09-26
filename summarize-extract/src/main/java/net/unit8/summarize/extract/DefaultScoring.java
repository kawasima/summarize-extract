package net.unit8.summarize.extract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultScoring implements Scoring {
	private int rate = 1;
	public List<Token> scoring(Map<String, Integer> termList) {
		PartInfo partInfo = new PartInfo();
		for(String term : termList.keySet()) {
			String[] words = term.split(" ");
			if(words.length < 2)
				continue;

			for(int i=0; i<words.length-1; i++) {
				partInfo.addPre(words[i]);
				partInfo.addPost(words[i+1]);
			}
		}

		List<Token> tokens = new ArrayList<Token>();
		for(String term : termList.keySet()) {
			double score = 1;
			String[] words = term.split(" ");
			for(String word : words) {
				score = score * (partInfo.getPre(word) + 1);
				score = score * (partInfo.getPost(word) + 1);
			}
			score = Math.pow(score, 1/(2 * rate * ((words.length==0)?1:words.length)));
			score = score * termList.get(term);
			tokens.add(new Token(term, score));
		}

		return tokens;
	}

}
