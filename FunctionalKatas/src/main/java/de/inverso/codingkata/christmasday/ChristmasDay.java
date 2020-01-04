package de.inverso.codingkata.christmasday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class ChristmasDay {

	private ChristmasDay() {
		// Nope
	}

	public static String findChristmasWeekday(String pDatum) throws ParseException {
		Date lDatum;
		if (pDatum.matches("\\d{4}-\\d{2}-\\d{2}")) {
			lDatum = new SimpleDateFormat("yyyy-MM-dd").parse(pDatum);
		} else if (pDatum.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
			lDatum = new SimpleDateFormat("dd.MM.yyyy").parse(pDatum);
		} else if (pDatum.matches("\\d{2} \\d{2} \\d{4}")) {
			lDatum = new SimpleDateFormat("MM dd yyyy").parse(pDatum);
		} else if (pDatum.matches("\\d{2}\\. Dezember \\d{4}")) {
			pDatum = pDatum.replaceAll("Dezember", "12");
			lDatum = new SimpleDateFormat("dd. MM yyyy").parse(pDatum);
		} else {
			return null;
		}

		if (!isChristmas(lDatum))
			return null;
		return getWeekday(lDatum);
	}

	protected static boolean isChristmas(Date datum) {
		Calendar calendar = ChristmasDay.date2Calendar(datum);

		if (calendar.get(Calendar.MONTH) != Calendar.DECEMBER)
			return false;
		int tag = calendar.get(Calendar.DAY_OF_MONTH);
		return (tag >= 24 && tag <= 26);
	}

	private static Calendar date2Calendar(Date datum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datum);
		return calendar;
	}

	protected static String getWeekday(Date datum) {
		Calendar calendar = ChristmasDay.date2Calendar(datum);
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			return "Montag";
		case Calendar.TUESDAY:
			return "Dienstag";
		case Calendar.WEDNESDAY:
			return "Mittwoch";
		case Calendar.THURSDAY:
			return "Donnerstag";
		case Calendar.FRIDAY:
			return "Freitag";
		case Calendar.SATURDAY:
			return "Samstag";
		default:
			return "Sonntag";
		}
	}
}
