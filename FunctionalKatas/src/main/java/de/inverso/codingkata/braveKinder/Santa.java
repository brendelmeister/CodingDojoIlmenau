package de.inverso.codingkata.braveKinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Santa {

	private List<Kind> santasliste = new ArrayList<>();

	public void addKind(Kind kind) {
		this.santasliste.add(kind);
	}

	public void addKinder(Kind... kinder) {
		for (Kind kind : kinder) {
			this.addKind(kind);
		}
	}

	public List<Kind> getKinder() {
		return this.santasliste;
	}

	public List<Kind> getSortedList() {
		Collections.sort(santasliste);
		return santasliste;
	}

	protected int getZehnProzent() {
		return this.santasliste.size() / 10;
	}

	public List<Kind> getBraveKinder() {
		this.getSortedList();
		List<Kind> liste = new ArrayList<Kind>();
		for (int i = 0; i < this.getZehnProzent(); i++) {
			liste.add(this.santasliste.get(i));
		}
		return liste;
	}

	public List<Kind> getNormaleKinder() {
		this.getSortedList();
		List<Kind> liste = new ArrayList<Kind>();
		for (int i = this.getZehnProzent(); i < this.santasliste.size() - this.getZehnProzent(); i++) {
			liste.add(this.santasliste.get(i));
		}
		return liste;
	}

	public List<Kind> getBoeseKinder() {
		this.getSortedList();
		List<Kind> liste = new ArrayList<Kind>();
		for (int i = this.santasliste.size() - this.getZehnProzent(); i < this.santasliste.size(); i++) {
			liste.add(this.santasliste.get(i));
		}
		return liste;
	}
}
