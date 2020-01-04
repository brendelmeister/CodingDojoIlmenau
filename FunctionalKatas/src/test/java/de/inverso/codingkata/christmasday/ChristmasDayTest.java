package de.inverso.codingkata.christmasday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChristmasDayTest {
	@Test
	public void testIsChristmas() throws ParseException {
		Date falsch01 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-29");
		Date falsch02 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-23");
		Date falsch03 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-27");
		Date richtig01 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-24");
		Date richtig02 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-25");
		Date richtig03 = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-26");

		assertFalse(ChristmasDay.isChristmas(falsch01));
		assertFalse(ChristmasDay.isChristmas(falsch02));
		assertFalse(ChristmasDay.isChristmas(falsch03));
		assertTrue(ChristmasDay.isChristmas(richtig01));
		assertTrue(ChristmasDay.isChristmas(richtig02));
		assertTrue(ChristmasDay.isChristmas(richtig03));
	}

	@Test
	public void testWeekDay() throws ParseException {
		Date dienstag = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-24");
		Date mittwoch = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-25");
		Date donnerstag = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-26");
		Date freitag = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-27");
		Date samstag = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-28");
		Date sonntag = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-29");
		Date montag = new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-30");

		assertThat(ChristmasDay.getWeekday(dienstag), equalTo("Dienstag"));
		assertThat(ChristmasDay.getWeekday(mittwoch), equalTo("Mittwoch"));
		assertThat(ChristmasDay.getWeekday(donnerstag), equalTo("Donnerstag"));
		assertThat(ChristmasDay.getWeekday(freitag), equalTo("Freitag"));
		assertThat(ChristmasDay.getWeekday(samstag), equalTo("Samstag"));
		assertThat(ChristmasDay.getWeekday(sonntag), equalTo("Sonntag"));
		assertThat(ChristmasDay.getWeekday(montag), equalTo("Montag"));
	}

	@Test
	public void testGetChristmasDay() throws ParseException {
		assertThat(ChristmasDay.findChristmasWeekday("2019-12-25"), equalTo("Mittwoch"));
		assertThat(ChristmasDay.findChristmasWeekday("25.12.2019"), equalTo("Mittwoch"));
		assertThat(ChristmasDay.findChristmasWeekday("12 25 2019"), equalTo("Mittwoch"));
		assertThat(ChristmasDay.findChristmasWeekday("25. Dezember 2019"), equalTo("Mittwoch"));
		assertThat(ChristmasDay.findChristmasWeekday("01.01.2020"), is(nullValue()));
		assertThat(ChristmasDay.findChristmasWeekday("Heute"), is(nullValue()));
	}
}
