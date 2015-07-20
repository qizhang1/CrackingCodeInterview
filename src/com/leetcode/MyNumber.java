package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MyNumber {
	public static int reverse(int x) {
		int sign = x > 0 ? 1 : -1;
		int abs_x = x > 0 ? x : -x;
		int result = 0;
		while (abs_x > 0) {
			int digit = abs_x % 10;
			result = result * 10 + digit;
			abs_x = abs_x / 10;
		}
		return result * sign;
	}

	public static int atoi(String str) {
		if (str.equals("")) {
			return 0;
		}
		// remove white space
		str = str.trim();
		int i = 0;
		char c = str.charAt(i);
		// positive or negative
		boolean isnegative = false;
		if (c == '+') {
			i++;
		}
		if (c == '-') {
			isnegative = true;
			i++;
		}
		// numeric
		int result = 0;
		for (; i < str.length(); i++) {
			c = str.charAt(i);
			if (c < '0' || c > '9')
				break; // illegal character
			int digit = (int) (c - '0');
			// overflow
			if (result > Integer.MAX_VALUE / 10
					|| result == Integer.MAX_VALUE / 10
					&& digit > Integer.MAX_VALUE % 10) {
				return isnegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			result = result * 10 + digit;
		}
		return isnegative ? -result : result;
	}

	public static boolean isPalindrome1(int x) {
		if (x < 0) {
			return false;
		}
		String s = Integer.toString(x); // extra space
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome2(int x) {
		if (x < 0) {
			return false;
		}
		int div_left = 1;
		while (x / div_left >= 10) {
			div_left *= 10;
		}

		int div_right = 1;
		while (div_left > div_right) {
			if (x / div_left % 10 != x / div_right % 10) {
				return false;
			}
			div_left = div_left / 10;
			div_right = div_right * 10;
		}
		return true;
	}

	// plus any digit [0 - 9]
	public static int[] plusOne(int[] digits, int n) {
		int carryover = n;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carryover;
			digits[i] = sum % 10;
			carryover = sum / 10;
		}
		// overflow
		if (carryover > 0) {
			int[] result = new int[digits.length + 1];
			result[0] = carryover;
			System.arraycopy(digits, 0, result, 1, digits.length);
			return result;
		}
		return digits;
	}

	public static String addBinary(String a, String b) {
		int len_a = a.length();
		int len_b = b.length();

		// if (len_a == 0 && len_b == 0) return null;
		// if (len_a == 0) return b;
		// if (len_b == 0) return a;

		int len = Math.max(len_a, len_b);
		char[] arr = new char[len];

		int carryover = 0;
		for (int i = len_a - 1, j = len_b - 1, k = len - 1; i >= 0 || j >= 0; i--, j--, k--) {
			int digit_a = i >= 0 ? (int) (a.charAt(i) - '0') : 0;
			int digit_b = j >= 0 ? (int) (b.charAt(j) - '0') : 0;

			int sum = digit_a + digit_b + carryover;
			arr[k] = (char) (sum % 2 + '0');
			carryover = sum / 2;
		}
		String result = new String(arr);
		if (carryover > 0) {
			return new StringBuilder(result).insert(0, '1').toString();
		}
		return result;
	}

	// Given an integer n, generate the nth sequence.
	// 1, 11, 21, 1211, 111221, ...
	public static String countAndSay(int n) {
		if (n < 1) {
			return "";
		}
		String s = "1";
		for (int i = 1; i < n; i++) {
			s = countAndSayNext(s);
		}
		return s;
	}

	private static String countAndSayNext(String s) {
		StringBuilder next = new StringBuilder();
		int count = 0;
		char c = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
				c = s.charAt(i);
				count++;
			} else {
				next.append(count).append(c);
				c = s.charAt(i); // count new number
				count = 1;
			}
		}
		next.append(count).append(c);
		return next.toString();
	}
	
	
	// *****************************************************************************************
	// |no temp variable for char|
	public static String compress(String s){
		if (s.length() == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} else {
				sb.append(s.charAt(i - 1)).append(count);
				count = 1;
			}
		}
		return sb.toString();
	}
	
	

	// Given a roman numeral, convert it to an integer [1, 3999]
	// 从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数
	// IV, IX, XL, XC, CD, CM
	public static int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
	        
		int result = 0;
		int i = 0;
		while (i < s.length()) {
			if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
				result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
				i += 2;
			} else {
				result += map.get(s.charAt(i));
				i++;
			}
		}
		return result;
	}
	
	// Time: O(num)?  Space: O(1)
	public static String intToRoman(int num) {
		int value[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String symbol[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder roman = new StringBuilder();
		for (int i = 0; num != 0; i++) {
			while(num >= value[i])  
            {  
                num = num - value[i];  
                roman.append(symbol[i]);  
            }  
		}
		return roman.toString();
    }
	
	// A happy number is a number defined by the following process: Starting with any positive integer, 
	// replace the number by the sum of the squares of its digits, and repeat the process 
	// until the number equals 1 (where it will stay), 
	// or it loops endlessly in a cycle which does not include 1
	// Time O(1) Space O(1)  because even all digits are 9, the sum is less than 81 * 10 digits
	public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while ( n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSumOfSquareDigits(n);
        } 
        return n == 1;
    }
    
    private static int getSumOfSquareDigits(int n){
        int result = 0;
        while (n > 0){
            int digit = n % 10;
            result += digit * digit;
            n = n / 10;
        }
        return result;
    }

}
