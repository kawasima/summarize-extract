package net.unit8.summarize.extract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class NgramParser implements Parser{
	private int latinGram = 2;
	private int kanaGram = 3;
	private int hanGram = 2;

	public Map<String, Integer> parse(String text) {
		Map<String, Integer> termList = new HashMap<String, Integer>();
		gram(termList, text, "InBasicLatin", latinGram);
		gram(termList, text, "InKatakana", kanaGram);
		gram(termList, text, "InCJKUnifiedIdeographs", hanGram);
		return termList;
	}

	private void gram(Map<String, Integer> termList, String text, String block, int gram) {
		Pattern ptn = Pattern.compile("(\\p{" + block + "}+)");
		Matcher m = ptn.matcher(text);
		while(m.find()) {
			String word = m.group(1);
			List<String> part = new ArrayList<String>();
			for(int i=0; i + gram <= word.length(); i++){
				part.add(word.substring(i, i+gram));
			}
			String term = StringUtils.join(part, " ");
			if(termList.containsKey(term)) {
				termList.put(term, termList.get(term) + 1);
			} else {
				termList.put(term, 1);
			}
		}


	}
}
