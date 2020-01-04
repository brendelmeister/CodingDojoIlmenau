package de.inverso.codingkata.braveKinder;

public class Kind implements Comparable<Kind> {

	private String name;
	protected int score;

	public Kind(String name) {
		this.name = name;
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void warBrav() {
		if (this.score < Integer.MAX_VALUE)
			this.score++;
	}

	public void warBoese() {
		if (this.score > Integer.MIN_VALUE)
			this.score--;
	}

	public void reset() {
		this.score = 0;
	}

	@Override
	public int compareTo(Kind o) {
		return o.score - this.score;
	}

}
