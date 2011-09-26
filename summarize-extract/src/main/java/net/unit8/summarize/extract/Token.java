package net.unit8.summarize.extract;

public class Token {
	private String term;
	private double score;

	public Token(String term, double score) {
		this.term = term;
		this.score = score;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
