package net.unit8.summarize.extract;

import java.util.ArrayList;
import java.util.List;

public class DefaultSentenceUtil implements SentenceUtil {

	public List<Sentence> split(String text) {
		text = text.replaceAll("[ \u3000]+", " ");
		text = text.replaceAll("。", "。\n");
		text = text.replaceAll("[\\r\\n]+", "\n");

		List<Sentence> sentences = new ArrayList<Sentence>();
		String[] lines = text.split("\n");
		int i=1;
		for(String line : lines) {
			if(line.length() > 0)
				sentences.add(new Sentence(i++, line));
		}

		return sentences;
	}

}
