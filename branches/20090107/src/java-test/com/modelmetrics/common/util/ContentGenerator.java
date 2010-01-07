package com.modelmetrics.common.util;

import java.util.Random;

public class ContentGenerator {

	public static Random rand = new Random();

 	public static String largeSampleTable = "Create table mytable (myid SMALLINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 3), myname varchar(20), mynumber int, mypicklist varchar(25), mydate date, mytimestamp timestamp, mylongtext long varchar, mylookup varchar(20))";

 	public static String[] names = new String[] { "Reid", "Bob", "Jerry", "Adam", "John",
			"Susan", "Amisha", "Libby", "Alta", "Lauren", "Phineas", "Mike",
			"Lydia", "Arnold", "Betty", "Veronica", "Alec", "Billy" };

 	public static String[] colors = new String[] { "red", "yellow", "beige", "green", "black" };

 	public static String[] words = new String[] { "lorem", "wonderful", "lake", "house",
			"ruse", "model", "game", "dearth", "rabid", "chilly", "surprising",
			"enjoyable", "summer", "ipsum", "cute", "monolithic", "abnormal",
			"rock on", "airplane", "paragraph" };

 	public static String[] lookups = new String[] { "CC001", "CC002" };

	public static int getRandom(int length) {
		return rand.nextInt(length);
	}

	public static String getNonZeroRandomAsZeroPaddedString(int maxvalue, int left) {
		String ret = "" + (1 + getRandom(maxvalue));
		if (ret.length() < left) {
			ret = "0" + ret;
		}
		return ret;
	}

	public static String getLongText() {
		return getLongText(100);
	}

	public static String getLongText(int i) {
		// longtext
		int maxWords = getRandom(i);
		String longText = "";
		for (int j = 0; j < maxWords; j++) {
			longText += words[getRandom(words.length)] + " ";
		}
		return longText;
	}
}
