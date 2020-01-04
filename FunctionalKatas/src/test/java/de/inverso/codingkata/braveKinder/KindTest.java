package de.inverso.codingkata.braveKinder;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;

public class KindTest {

	@Test
	public void testKind() {
		Kind maxi = new Kind("Maxi");
		assertThat(maxi.getName(), equalTo("Maxi"));
		assertThat(maxi.getScore(), is(0));
		maxi.warBoese();
		assertThat(maxi.getScore(), is(-1));
		maxi.warBrav();
		assertThat(maxi.getScore(), is(0));
	}

	@Test
	public void testReset() {
		Kind maxi = new Kind("Maxi");
		maxi.warBoese();
		maxi.reset();
		assertThat(maxi.getScore(), is(0));
	}

	@Test
	public void testOverflow() {
		Kind kevin = new Kind("Kevin");
		kevin.score = Integer.MIN_VALUE;
		kevin.warBoese();

		assertThat(kevin.getScore(), is(Integer.MIN_VALUE));

		Kind chris = new Kind("Chris");
		chris.score = Integer.MAX_VALUE;
		chris.warBrav();

		assertThat(chris.getScore(), is(Integer.MAX_VALUE));
	}
}
