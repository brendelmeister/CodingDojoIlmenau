package de.inverso.codingkata.braveKinder;

import java.util.Random;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

import static org.junit.Assert.assertThat;

public class SantaTest {
	@Test
	public void testSanta() {
		Santa santa = new Santa();

		assertThat(santa.getKinder(), hasSize(0));

		santa.addKind(new Kind("Kevin"));
		santa.addKind(new Kind("Schandall"));
		assertThat(santa.getKinder(), hasSize(2));
	}

	@Test
	public void sortiereKinder() {
		Santa santa = new Santa();

		Kind sehrboese = new Kind("Sehr Boese");
		sehrboese.warBoese();
		sehrboese.warBoese();
		sehrboese.warBoese();
		sehrboese.warBoese();
		Kind sehrsehrboese = new Kind("Sehr sehr böser Chris");
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		sehrsehrboese.warBoese();
		Kind engel = new Kind("Andreas");
		engel.warBrav();
		engel.warBrav();
		engel.warBrav();
		engel.warBrav();
		Kind liebling = new Kind("Andreas");
		liebling.warBrav();
		Kind kevin = new Kind("Kevin");
		kevin.warBoese();
		Kind chris = new Kind("Chris");

		Kind tim = new Kind("Tim");

		Kind andreas = new Kind("Andreas");

		santa.addKinder(andreas, chris, engel, kevin, liebling, sehrboese, sehrsehrboese, tim);

		assertThat(santa.getSortedList(),
				contains(engel, liebling, andreas, chris, tim, kevin, sehrboese, sehrsehrboese));
	}

	@Test
	public void reward() {
		Santa santa = new Santa();
		for (int i = 0; i < 10; i++) {
			Kind kind = new Kind(String.valueOf(i));
			Random rand = new Random();
			int n = rand.nextInt(10);
			for (int j = 0; j < n; j++) {
				kind.warBrav();
			}
			santa.addKind(kind);
		}
		assertThat(santa.getBraveKinder(), hasSize(1));
		assertThat(santa.getNormaleKinder(), hasSize(8));
		assertThat(santa.getBoeseKinder(), hasSize(1));

	}
}
