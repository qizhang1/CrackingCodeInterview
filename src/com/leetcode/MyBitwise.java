package com.leetcode;

public class MyBitwise {
	// Counts the number of bits that is 1
	// x is an unsigned integer (a.k.a the Hamming weight).
	// Brian Kernighan��s Algorithm
	public static int bitCount(int x) {
		int count = 0;
		while (x != 0) {
			// Subtraction of 1 from a number toggles all the bits (from right
			// to left)
			// till the rightmost set bit(including the rightmost set bit)
			x = x & (x - 1);
			count++;
		}
		return count;
	}

	public int hammingWeight1(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >>> 1;
		}
		return count;
	}

	public int hammingWeight2(int n) {
		return Integer.bitCount(n);
	}

	// *****************************************************************************************
	// bitwise complement operator
	public static int inverse(int i) {
		return ~i;
	}

	// bitwise AND operation
	// 1 & 0 = 0 turn it off
	public static boolean isEven(int n) {
		int bitmask = 0X00000001;
		return !((n & bitmask) == 1);
	}

	// bitwise XOR operation
	// 0 ^ 1 = 1, 1 ^ 1 = 0 flip the bit
	// two identical numbers in an expression involving XOR will "cancel out".
	// use C++
	public static void swap(int[] a, int[] b) {
		a[0] = a[0] ^ b[0]; // returns a number which has all the bits as 1
							// wherever bits of a and b differ
		b[0] = a[0] ^ b[0];
		a[0] = a[0] ^ b[0];
	}

	// bitwise inclusive OR operation
	// 0 | 1 = 1 turn it on

	// if a > b return 1, otherwise return 0
	// unsigned right shift operator ">>>" shifts a zero into the leftmost
	// position
	// Note: >> is arithmetic right shift that replaces the first few bits with
	// a copy of the first bit
	public static int compare(int a, int b) {
		return (b - a) >>> 31;
	}

	// compute 2^x
	public static int power2(int x) {
		return 1 << x;
	}

	// determine whether a number is a power of 2
	public static boolean isPower2(int n) {
		if (n <= 0) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}

	// *****************************************************************************************
	// Reverse Bits
	// Time O(n), n is the total number of bits in an unsigned integer.
	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result << 1;
			if ((n & 1) == 1) {
				result = result | 1;
			}
			n = n >>> 1;
		}
		return result;
	}

	// *****************************************************************************************
	// Bitwise AND of Numbers Range
	// Given a range [m, n] where 0 <= m <= n <= 2147483647,
	// return the bitwise AND of all numbers in this range, inclusive.
	public static int rangeBitwiseAnd1(int m, int n) {
		int i = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			i++;
		}
		return m << i;
	}
	
    public static int rangeBitwiseAnd2(int m, int n) {
        int d =  Integer.MAX_VALUE;
        while ((m & d) != (n & d)) {
            d <<= 1;
        }
        return m & d; 
    }
}
