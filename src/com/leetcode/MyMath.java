package com.leetcode;

import java.util.regex.Pattern;

public class MyMath {

	// Given an unsorted integer array, find the first missing positive integer.
	// O(n) time and constant space
	// Refer to simpleBucketSort
	public static int firstMissingPositive(int[] A) {
		int n = A.length;
		int i = 0;
		while (i < n) {
			if (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
				// swap A[i] and A[A[i] - 1]
				int temp = A[A[i] - 1];
				A[A[i] - 1] = A[i];
				A[i] = temp;
			} else {
				i++;
			}
		}

		for (i = 0; i < n; i++) {
			if (A[i] != i + 1)
				break;
		}
		return i + 1;
	}

	// *****************************************************************************************
	// O(n)
	public static double pow1(double x, int n) {
		if (n < 0) {
			return 1.0 / pow1Helper(x, -n);
		}
		return pow1Helper(x, n);
	}

	public static double pow1Helper(double x, int n) {

		double[] doubleArray = new double[32];
		doubleArray[0] = x;
		for (int i = 1; i < 32; i++) {
			doubleArray[i] = doubleArray[i - 1] * doubleArray[i - 1];
		}

		double result = 1;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				result *= doubleArray[i];
			}
			mask <<= 1;
		}
		return result;
	}

	// O(logn)
	public static double pow2(double x, int n) {
		if (n < 0) {
			return 1.0 / pow2Helper(x, -n);
		}
		return pow2Helper(x, n);
	}

	public static double pow2Helper(double x, int n) {

		if (n == 0)
			return 1;
		double temp = pow2Helper(x, n / 2);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			return temp * temp * x;
		}
	}

	// Computation by powers of 2
	// http://en.wikipedia.org/wiki/Exponentiation_by_squaring
	public double pow3Helper(double x, int n) {

		double result = 1.0;
		while (n > 0) {
			if ((n & 1) != 0) { // odd exp
				result *= x;
			}
			n >>= 1; // n = n / 2;
			x *= x;
		}
		return result;
	}

	public static boolean isNumber1(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		int i = 0;

		// Sign
		if (s.charAt(i) == '+' || s.charAt(i) == '-') {
			i++;
		}
		// Integer
		boolean hasInteger = false;
		while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
			i++;
			hasInteger = true;
		}
		// Decimal
		if (i < s.length() && s.charAt(i) == '.') {
			i++;
			if (i == s.length() && !hasInteger) {
				return false;
			}
		}
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			i++;
			hasInteger = true;
		}

		// Exponent
		if (i < s.length() && s.charAt(i) == 'e') {
			if (!hasInteger)
				return false;
			i++;
			if (i == s.length()) {
				return false;
			}
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				i++;
			}
			boolean hasExponent = false;
			while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				i++;
				hasExponent = true;
			}
			return i == s.length() && hasExponent;
		}
		while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
			i++;
		}
		return i == s.length();
	}

	public static boolean isNumber2(String s) {
		if (s == null) {
			return false;
		}
		return Pattern.matches("^(?! *$) *(|\\+|-)(?!(e|\\.e|\\. *$))" // negative
																		// lookup
				+ "\\d*(|\\.\\d*)" + "(|e(|\\+|-)\\d+) *$", s);
	}

	public static boolean isNumber3(String s) {
		s = s.trim();
		return Pattern.matches("^*(|\\+|-)(?!(e|\\.e|\\.$|$))"
				+ "\\d*(|\\.\\d*)" + "(|e(|\\+|-)\\d+)$", s);
	}

	// Given an integer n, return the number of trailing zeroes in n!
	//
	public static int trailingZeroes1(int n) {
		long factor = 5;
		int result = 0;
		while (factor <= n) {
			result += (n / factor);
			factor *= 5;
		}
		return result;
	}

	// optimal
	// Time O(log5 n) Space O(1)
	public static int trailingZeroes2(int n) {
		int result = 0;
		int temp = 0;
		while (n / 5 > 0) {
			temp = n / 5;
			result += temp;
			n = temp;
		}
		return result;
	}

	// Multiply two integers
	// Time O(32)
	public static long multiply(int n1, int n2) {
		boolean isPositive = ((n1 > 0 && n2 > 0) || (n1 < 0 && n2 < 0));
		long a = (long) n1;
		long b = (long) n2;
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;

		long result = 0;
		for (int i = 0; i < 32; i++) { // 4 bytes
			if (((b >>> i) & 1) == 1) {
				result += (a << i);
			}
		}
		return isPositive ? result : -result;
	}

	// Divide two integers
	// Divide two integers without using multiplication, division and mod
	// operator.
	// Time O(32)
	public static long divide1(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException();
		}
		boolean isPositive = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0));

		long a = (long) dividend;
		long b = (long) divisor;
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;

		long result = 0;
		for (int i = 31; i >= 0; i--) {
			if ((a >>> i) >= b) {
				result += ((long) 1 << i);
				a = a - (b << i);
			}
		}
		return isPositive ? result : -result;
	}

	// *****************************************************************************************
	// Compute and return the square root of x
	public int sqrt1(int x) {
		if (x < 0) {
			throw new IllegalArgumentException();
		}
		// һ���Ǹ�����ƽ�����������n / 2 + 1
		long start = 0, end = x / 2 + 1;
		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return (int) end;
	}

	public int sqrt2(int x) {
		long result = 0;
		for (int i = 15; i >= 0; i--) { // for 32 bit integer, highest bit of
										// result must between [0,15]
			long test = result | (1 << i);
			if (test * test <= (long) x) {
				result = test; // set one bit at a time
			}
		}
		return (int) result;
	}

	// *****************************************************************************************
	// Does Rectangle A and B overlap (1 is bottom left point and 2 is top right
	// point)
	public static boolean isRectOverlap(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		return !(C < E || G < A || D < F || H < B);
	}

	// *****************************************************************************************
	// compute Rectangle total area
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int totalArea = (C - A) * (D -B) + (G - E) * (H - F);
        if (!isRectOverlap(A, B, C, D, E, F, G, H)) {
            return totalArea;
        }
        
        // overlap area
        int left = Math.max(A, E);
        int bottom = Math.max(B, F);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
 
        return totalArea - (right - left) * (top - bottom);
    }
}
