package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		callMethod();
	}

	public static void callMethod() {
		String result1 = mergeAlternately("b", "f");
		int[] candies = { 12, 1, 12 };
		List<Boolean> result2 = kidsWithCandies(candies, 10);
		int[] flowerbed = { 0 };
		boolean result3 = canPlaceFlowers(flowerbed, 1);
		String result4 = reverseVowels("leetcode");
		String result5 = reverseWords("  hello    world  ");
		int[] nums = { 6, 7, 1, 2 };
		boolean result6 = increasingTriplet(nums);
		System.out.println("Result: " + result6);
	}

	public static String mergeAlternately(String word1, String word2) {
		StringBuilder finalValue = new StringBuilder();
		if (word1.length() >= 1 && word1.length() <= 100 && word2.length() >= 1 && word2.length() <= 100) {
			int largestLength = word1.length() > word2.length() ? word1.length() : word2.length();

			for (int i = 0; i < largestLength; i++) {
				if (i < word1.length()) {
					finalValue.append(word1.charAt(i));
				}

				if (i < word2.length()) {
					finalValue.append(word2.charAt(i));
				}
			}
		}

		return finalValue.toString();
	}

	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> finalResult = new ArrayList<>();
		int largestCandies = 0;

		for (int candy : candies) {
			if (candy > largestCandies) {
				largestCandies = candy;
			}
		}

		for (int candy : candies) {
			int totalCandy = candy + extraCandies;

			if (totalCandy >= largestCandies) {
				finalResult.add(true);
			} else {
				finalResult.add(false);

			}
		}

		return finalResult;
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int skippedPlot = -1;
		boolean result = false;
		int totalAvailablePlot = 0;

		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] != 1 && i != skippedPlot) {
				if (flowerbed.length == 1 && flowerbed[i] == 0) {
					totalAvailablePlot++;
				} else if (i == 0 && flowerbed[i + 1] == 0) {
					totalAvailablePlot++;
					skippedPlot = i + 1;
				} else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
					totalAvailablePlot++;
					skippedPlot = i + 1;
				} else if (i != 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
					totalAvailablePlot++;
					skippedPlot = i + 1;
				}
			}
		}

		if (n <= totalAvailablePlot) {
			result = true;
		}

		return result;
	}

	public static String reverseVowels(String s) {
		int start = 0;
		int end = s.length() - 1;
		char[] finalValue = s.toCharArray();

		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
		while (start < end) {
			if (vowels.contains(Character.toString(finalValue[start]))
					&& vowels.contains(Character.toString(finalValue[end]))) {
				char tempStart = finalValue[start];
				finalValue[start] = finalValue[end];
				finalValue[end] = tempStart;
				start++;
				end--;
			} else if (!vowels.contains(Character.toString(finalValue[start]))) {
				start++;
			} else if (!vowels.contains(Character.toString(finalValue[end]))) {
				end--;
			}
		}

		return String.valueOf(finalValue);
	}

	public static String reverseWords(String s) {
		// remove any subsequence space, first \ means split \s+, if no first \ when be
		// split by s+ which is incorrect
		// \s means the space and + means treat all space together as one
		String[] splitStrings = s.split("\\s+");
		StringBuilder finalString = new StringBuilder();

		for (int i = splitStrings.length - 1; i > -1; i--) {
			finalString.append(splitStrings[i]);
			if (i != 0) {
				finalString.append(" ");
			}
		}

		return finalString.toString();
	}

	public static boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE;
		int mid = Integer.MAX_VALUE;

		for (int value : nums) {
			if (small >= value) {
				small = value;
			} else if (mid >= value) {
				mid = value;
			} else {
				return true;
			}
		}

		return false;
	}

	// public static int compress(char[] chars) {
    //     // only one character no need show count
	// 	// if count is more than 10 then will be 1,0


    // }

}
