package com.bizarrecode.urlshortener.util;

import java.util.Random;

public class URLShortener {
		
	private char myChars[];
	private Random myRand;

	public URLShortener() {
		myRand = new Random();
		myChars = new char[62];
		for (int i = 0; i < 62; i++) {
			int j = 0;
			if (i < 10) {
				j = i + 48;
			} else if (i > 9 && i <= 35) {
				j = i + 55;
			} else {
				j = i + 61;
			}
			myChars[i] = (char) j;
		}
	}

	public String generateShortURL() {
		String key = "";
		for (int i = 0; i < 7; i++) {
			key += myChars[myRand.nextInt(62)];
		}
		return Constants.DOMAIN + key;
	}

	public static void main(String args[]) {
		URLShortener u = new URLShortener();
		System.out.println("URL:" + u.generateShortURL());
		
	}
}
