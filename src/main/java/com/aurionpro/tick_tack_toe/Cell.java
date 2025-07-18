package com.aurionpro.tick_tack_toe;

public class Cell {

	private MarkType mark;

	public Cell() {
		this.mark = MarkType.EMPTY;
	}

	public MarkType getMark() {
		return mark;
	}

	public void setMark(MarkType mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return mark == MarkType.EMPTY ? " " : mark.toString();
	}

}
