package com.leetcode;

import java.util.*;

public class MyString {

	// find the longest common prefix string amongst an array of strings.
	// compare vertically
	// optimal method O(n)
	public static String longestCommonPrefix1(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length()
						|| strs[j].charAt(i) != strs[0].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}

	// compare horizontally
	public static String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int endIndex = strs[0].length() - 1;

		for (int i = 1; i < strs.length; i++) {
			for (int src = 0; src <= endIndex; src++) {
				if (src >= strs[i].length()
						|| strs[i].charAt(src) != strs[0].charAt(src)) {
					endIndex = src - 1;
				}
			}
		}
		return strs[0].substring(0, endIndex + 1);
	}

	// Returns a pointer to the first occurrence of needle in haystack,
	// or null if needle is not part of haystack.
	// not optimal O(mn)
	public static int strStr1(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		for (int i = 0; i + needle.length() <= haystack.length(); i++) {
			int j = 0; // reset
			// compare substring
			while (i + j < haystack.length() && j < needle.length()
					&& haystack.charAt(i + j) == needle.charAt(j)) {
				j++;
			}

			if (j == needle.length()) { // found
				return i;
			}
		}
		return -1;
	}

	public static int strStr2(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() <= haystack.length()
					&& haystack.substring(i, i + needle.length())
							.equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	// Given a string s consists of upper/lower-case alphabets and empty space
	// characters ' '
	// return the length of last word in the string.
	// If the last word does not exist, return 0.
	public static int lengthOfLastWord2(String s) {
		// s.trim()
		int i;
		for (i = s.length() - 1; i >= 0 && s.charAt(i) == ' '; i--)
			;

		// loop backwards
		int lengthOfLastWord = 0;
		for (; i >= 0 && s.charAt(i) != ' '; i--) {
			lengthOfLastWord++;
		}
		return lengthOfLastWord;
	}

	// *****************************************************************************************
	// LC-205. Isomorphic Strings
	// Two words are called isomorphic if the letters in one word can be
	// remapped to get the second word. 
	// Time O(n^2), Space O(n) 
	public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)) {
                    return false;
                }
            } else if (map.containsValue(c2)) { // No two characters may map to the same character 
                return false;
            } else {
                map.put(c1, c2);
            }
        }
        return true;
	}
	
	// Time O(n), Space O(n), Optimal
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>(), tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if ((sMap.containsKey(c1) && sMap.get(c1) != c2) 
                || (tMap.containsKey(c2) && tMap.get(c2) != c1)){
                return false;
            } else {
                sMap.put(c1, c2);
                tMap.put(c2, c1);
            }
        }
        return true;
    }

	// *****************************************************************************************
	// LC-242. Valid Anagram
	// assume the string contains only lowercase alphabets
	// Time O(n), Space O(a+b) 
	// General optimal solution
	public static boolean isAnagrams(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (count.containsKey(c) && count.get(c) != 0) {
                count.put(c, count.get(c)-1);
            } else {
                return false;
            } 
        }
        return true;
	}

	// use int[256] to mimic Hashmap, optional
	public static boolean isAnagrams1(String a, String b) {
		int[] letters = new int[256]; // ANSI
		for (char c : a.toCharArray()) {
			letters[c]++;
		}
		for (char c : b.toCharArray()) {
			if (letters[c] == 0) {
				return false;
			}
			letters[c]--;
		}
		for (int l : letters) {
			if (l != 0) {
				return false;
			}
		}
		return true;
	}

	// Time O(nlogn), Space O(1) suboptimal
	public static boolean isAnagrams2(String a, String b) {
		char[] arr_a = a.toCharArray();
		char[] arr_b = b.toCharArray();
		Arrays.sort(arr_a);
		Arrays.sort(arr_b);
		return Arrays.equals(arr_a, arr_b);
	}

	// *****************************************************************************************
	// Given an array of strings, return all groups of strings that are
	// anagrams.
	// Time O(n * mlogm) Space O(nm)
	public static List<String> anagrams1(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] arr_s = s.toCharArray();
			Arrays.sort(arr_s);
			String key = new String(arr_s);
			if (map.containsKey(key)) {
				map.get(key).add(s);
			} else {
				List<String> value = new ArrayList<>();
				value.add(s);
				map.put(key, value);
			}
		}

		List<String> result = new ArrayList<String>();
		for (String s : map.keySet()) {
			List<String> anagramsGroup = map.get(s);
			if (anagramsGroup.size() > 1) {
				result.addAll(anagramsGroup);
			}
		}
		return result;
	}

	// use arrayList
	// Time O(nm)
	public static List<String> anagrams2(String[] strs) {
		HashMap<List<Integer>, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] arr_s = s.toCharArray();
			List<Integer> key = new ArrayList<Integer>(Collections.nCopies(26,
					0));
			for (char c : arr_s) {
				int i = c - 'a';
				key.set(i, key.get(i).intValue() + 1);
			}
			if (map.containsKey(key)) {
				map.get(key).add(s);
			} else {
				List<String> value = new ArrayList<>();
				value.add(s);
				map.put(key, value);
			}
		}

		List<String> result = new ArrayList<String>();
		for (List<Integer> key : map.keySet()) {
			List<String> anagramsGroup = map.get(key);
			if (anagramsGroup.size() > 1) {
				result.addAll(anagramsGroup);
			}
		}
		return result;
	}

	// use int[], override equals(), hashcode()
	static class LetterFrequency {
		private int[] arr = new int[26];

		public LetterFrequency(String s) {
			char[] arr_s = s.toCharArray();
			for (char c : arr_s) {
				arr[c - 'a'] += 1;
			}
		}

		@Override
		public boolean equals(Object o) {
			if (o == null)
				return false;
			if (!(o instanceof LetterFrequency))
				return false;
			LetterFrequency a = (LetterFrequency) o;
			return Arrays.equals(this.arr, a.arr);
		}

		@Override
		public int hashCode() {
			return Arrays.hashCode(arr);
		}
	}

	public static List<String> anagrams3(String[] strs) {
		HashMap<LetterFrequency, List<String>> map = new HashMap<>();
		for (String s : strs) {
			LetterFrequency key = new LetterFrequency(s);
			if (map.containsKey(key)) {
				map.get(key).add(s);
			} else {
				List<String> value = new ArrayList<>();
				value.add(s);
				map.put(key, value);
			}
		}
		List<String> result = new ArrayList<String>();
		for (LetterFrequency key : map.keySet()) {
			List<String> anagramsGroup = map.get(key);
			if (anagramsGroup.size() > 1) {
				result.addAll(anagramsGroup);
			}
		}
		return result;
	}

	// *****************************************************************************************
	// LC-151. Reverse Words in a String
	// Time: O(n) space: O(n)
	public static String reverseWords1(String s) {
		StringBuilder reverse = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			// skip trailing spaces if any
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			int end = i;
			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			int start = i + 1;
			if (start != end + 1) {
				reverse.append(s.substring(start, end + 1));
				reverse.append(" "); // one space in between words
			}
		}
		if (reverse.length() > 0)
			reverse.setLength(reverse.length() - 1); // remove last " "
		return reverse.toString();
	}

	// s.trim() trailing space
	public static String reverseWords2(String s) {
		StringBuilder reverse = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			int end = i;
			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			int start = i + 1;
			reverse.append(s.substring(start, end + 1)).append(" ");
		}
		return reverse.toString().trim();
	}
	
	// Time: O(n) space: O(n)
	public static String reverseWords3(String s) {
		// trim() to remove leading (and trailing) whitespace before the split
		String[] splitedStr = s.trim().split(" +"); 
		StringBuilder reverse = new StringBuilder();
		for (int i = splitedStr.length - 1; i >=0; i--) {
			reverse.append(splitedStr[i]);
			if(i != 0) {
				reverse.append(" ");
			}
		}
		return reverse.toString();
	}

	// *****************************************************************************************
	// Given a string, determine if it is a Palindrome;
	// return true for empty string
	// considering only alphanumeric characters and ignoring cases.
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("\\W", ""); // remove all non characters [^a-zA-Z_0-9]
		s = s.toLowerCase();
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	// LC- 409. Longest Palindrome
	// Time O(n), Space O(n) 
    public static int longestPalindromeLen(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        int len = 0;
        boolean hasOdd = false;
        for (int n : count.values())  {
            if ( n % 2 == 0) {
               len += n;
            } else {
               len += n - 1;
               hasOdd = true;
            }
        }
        return hasOdd ? len + 1 : len;
    }
	
	// find the longest palindromic substring in S
	// assume that the maximum length of S is 1000, and there exists one unique
	public static String longestPalindrome(String s) {

		return null;
	}

	// The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	// number of rows
	// And then read line by line: "PAHNAPLSIIGYIR"
	public static String convert(String s, int nRows) {
		if (s.length() < nRows || nRows == 1) {
			return s;
		}
		StringBuilder[] sb = new StringBuilder[nRows];
		for (int i = 0; i < nRows; i++) {
			sb[i] = new StringBuilder();
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int j = i % (2 * nRows - 2);
			int pos = j < nRows ? (j % nRows) : ((2 * nRows - 2) - j);
			sb[pos].append(c);
		}
		for (int i = 1; i < nRows; i++) {
			sb[0].append(sb[i].toString());
		}
		return sb[0].toString();
	}

	// return the number of times that the char c appears in the string s
	public static int numCount(char c, String s) {
		if (s.isEmpty()) {
			return 0;
		}
		if (s.charAt(0) == c) {
			return 1 + numCount(c, s.substring(1));
		} else {
			return numCount(c, s.substring(1));
		}
	}

	public static String removeVowels(String s) {
		Set<Character> vowel = new HashSet<>();
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');
		return removeVowelsHelper(s, vowel);
	}

	private static String removeVowelsHelper(String s, Set<Character> vowel) {
		if (s.isEmpty()) {
			return "";
		} else if (vowel.contains(s.charAt(0))) {
			return removeVowelsHelper(s.substring(1), vowel);
		} else {
			return s.substring(0, 1).concat(
					removeVowelsHelper(s.substring(1), vowel));
		}
	}

	// Given a positive integer, return its corresponding column title as appear
	// in an Excel sheet
	// 1 -> A, 2 -> B, 3 -> C
	// 26 -> Z, 27 -> AA, 28 -> AB
	public static String convertToTitle1(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int remainder = n % 26;
			if (remainder == 0) {
				sb.append('Z');
				n = n / 26 - 1;
			} else {
				sb.append((char) ('A' + remainder - 1));
				n = n / 26;
			}
		}
		return sb.reverse().toString();
	}

	// Given a column title as appear in an Excel sheet, return its
	// corresponding column number.
	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int col = s.charAt(i) - 'A' + 1;
			result = result * 26 + col;
		}
		return result;
	}

	// Compare two version numbers version1 and version1.
	// If version1 > version2 return 1, if version1 < version2 return -1,
	// otherwise return 0.
	// Assume that the version strings are non-empty and contain only digits and
	// the . character.
	public static int compareVersion1(String version1, String version2) {
		int i = 0;
		int j = 0;
		while (i < version1.length() || j < version2.length()) {
			int v1 = 0;
			while (i < version1.length() && version1.charAt(i) != '.') {
				v1 = v1 * 10 + (int) (version1.charAt(i) - '0');
				i++;
			}
			i++; // skip "." if exits

			int v2 = 0;
			while (j < version2.length() && version2.charAt(j) != '.') {
				v2 = v2 * 10 + (int) (version2.charAt(j) - '0');
				j++;
			}
			j++;

			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
		}
		return 0;
	}

	public static int compareVersion2(String version1, String version2) {
		String[] v1 = version1.split("\\."); // not just "."!
		String[] v2 = version2.split("\\.");
		int i = 0;
		while (i < v1.length || i < v2.length) {
			int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
			if (n1 > n2) {
				return 1;
			} else if (n1 < n2) {
				return -1;
			} else {
				i++;
			}
		}
		return 0;
	}

	// Given a string, find the length of the longest Non-Repeating Character
	// Substring (NRCS)
	public static int lengthOfLongestSubstring(String s) {
		// hashmap store the last indexes of already visited characters
		HashMap<Character, Integer> indexMap = new HashMap<>();
		int start = 0;
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// update start
			if (indexMap.containsKey(c) && indexMap.get(c) >= start) { // repeating
																		// exists
				start = indexMap.get(c) + 1;
			}
			// update the index of current character
			indexMap.put(c, i);
			// update max length
			int curlen = i - start + 1;
			if (curlen > maxLen) {
				maxLen = curlen;
			}
		}
		return maxLen;
	}

	// Implement wildcard matching with support for '?' and '*'
	// '?' Matches any single character
	// '*' Matches any sequence of characters (including the empty sequence)
	public static boolean isMatch(String s, String p) {
		int i = 0, j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j++;
				mark = i;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}
		return j == p.length();
	}

	// Implement regular expression matching with support for '.' and '*'
	// '.' Matches any single character
	// '*' Matches zero or more of the preceding element
	// what's the difference??
	public static boolean isMatch2(String s, String p) {

		return false;
	}
	
	// LC-796. Rotate String
	// Return True if and only if A can become B after some number of shifts on A
	// Time O(n), Space O(n)
    public static boolean rotateString(String A, String B) {
        return B.length() == A.length() && (A + A).contains(B);
    }
    
    // Shift string K places
    // Time O(n), Space O(n) - String is immutable, char[] takes space"
    public static String shift(String s, int k) {
    	char[] ch = s.toCharArray(); 
    	reverse(ch, 0, s.length() - k - 1);
    	reverse(ch, s.length() - k, s.length() - 1);
    	reverse(ch, 0, s.length()-1);
    	return String.valueOf(ch);
    }
    
    static void reverse(char[] ch, int start, int end) { 
        for (int i = start, j = end; i < j; i++, j--) {
	    	char temp = ch[i]; 
	        ch[i] = ch[j]; 
	        ch[j] = temp; 
        }
    } 
  
    
	
	
	

}
