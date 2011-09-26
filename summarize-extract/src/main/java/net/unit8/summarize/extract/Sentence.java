package net.unit8.summarize.extract;

public class Sentence {
	private int line;
	private String text;
	private double score;

	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Sentence(int i, String text) {
		this.line = i;
		this.text= text;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
