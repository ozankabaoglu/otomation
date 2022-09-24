package com.bulutmd.otomation.util;

public class Utilities {

	public static boolean verifyNumber(String nationalityNumberStr) {
		try {
			String tmp = nationalityNumberStr;

			if (tmp.toCharArray()[0] != '0') {
				// cannot start with 0
				if (tmp.length() == 11) {
					// should be 11 digits
					int totalOdd = 0;

					int totalEven = 0;

					for (int i = 0; i < 9; i++) {
						int val = Integer.valueOf(tmp.substring(i, i + 1));

						if (i % 2 == 0) {
							totalOdd += val;
						} else {
							totalEven += val;
						}
					}

					int total = totalOdd + totalEven + Integer.valueOf(tmp.substring(9, 10));

					int lastDigit = total % 10;

					if (tmp.substring(10).equals(String.valueOf(lastDigit))) {
						int check = (totalOdd * 7 - totalEven) % 10;

						if (tmp.substring(9, 10).equals(String.valueOf(check))) {
							return true;
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
