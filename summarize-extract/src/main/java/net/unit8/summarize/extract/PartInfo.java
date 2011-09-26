package net.unit8.summarize.extract;

import java.util.HashMap;
import java.util.Map;

public class PartInfo {
	private Map<String, Integer> pre;
	private Map<String, Integer> post;

	public PartInfo() {
		pre = new HashMap<String, Integer>();
		post = new HashMap<String, Integer>();
	}

	public void addPre(String word) {
		Integer n = pre.get(word);
		if(n == null)
			n = 0;
		pre.put(word, n+1);
	}
	public void addPost(String word) {
		Integer n = post.get(word);
		if(n == null)
			n = 0;
		post.put(word, n+1);
	}

	public int getPre(String word) {
		Integer n = pre.get(word);
		return (n==null)? 0 : n;
	}

	public int getPost(String word) {
		Integer n =  post.get(word);
		return (n==null)? 0 : n;
	}
}
