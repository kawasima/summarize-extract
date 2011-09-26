package net.unit8.summarize.extract;

import java.util.List;
import java.util.Map;

public interface Scoring {
	public List<Token> scoring(Map<String, Integer> termList);
}
