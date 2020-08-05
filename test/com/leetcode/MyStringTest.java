package com.leetcode;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

//
public class MyStringTest extends TestCase {
	
	public void testLongestCommonPrefix1(){
		String[] strs = new String[]{"aac","cab","abb"};
		String longestCommonPrefix = MyString.longestCommonPrefix1(strs);
		assertEquals("", longestCommonPrefix);
	}
	
	public void testLongestCommonPrefix2(){
		String[] strs = new String[]{"aa", "a"};
		String longestCommonPrefix = MyString.longestCommonPrefix1(strs);
		assertEquals("a", longestCommonPrefix);
	}
	
	public void testLongestCommonPrefix3(){
		String[] strs = new String[]{"abc", "aacd"};
		String longestCommonPrefix = MyString.longestCommonPrefix1(strs);
		assertEquals("a", longestCommonPrefix);
	}
	public void testLongestCommonPrefix4(){
		String[] strs = new String[]{"aac","cab","abb"};
		String longestCommonPrefix = MyString.longestCommonPrefix2(strs);
		assertEquals("", longestCommonPrefix);
	}
	
	public void testLongestCommonPrefix5(){
		String[] strs = new String[]{"aa", "a"};
		String longestCommonPrefix = MyString.longestCommonPrefix2(strs);
		assertEquals("a", longestCommonPrefix);
	}
	
	public void testLongestCommonPrefix6(){
		String[] strs = new String[]{"abc", "aacd"};
		String longestCommonPrefix = MyString.longestCommonPrefix2(strs);
		assertEquals("a", longestCommonPrefix);
	}
	
	
	public void testStrStr1(){
		String haystack = "abc";
		String needle = "b";
		assertEquals(1, MyString.strStr1(haystack, needle));
	}
	
	public void testStrStr2(){
		String haystack = "abc";
		String needle = "";
		assertEquals(0, MyString.strStr1(haystack, needle));
	}
	public void testStrStr3(){
		String haystack = "ab";
		String needle = "abc";
		assertEquals(-1, MyString.strStr1(haystack, needle));
	}
	
	public void testStrStr4(){
		String haystack = "abc";
		String needle = "b";
		assertEquals(1, MyString.strStr2(haystack, needle));
	}
	
	public void testLengthOfLastWord1(){
		String s = " this is an apple ";
		assertEquals(5, MyString.lengthOfLastWord2(s));
	}

	public void testLengthOfLastWord2(){
		String s = " this is a  bee  ";
		assertEquals(3, MyString.lengthOfLastWord2(s));
	}
	
	public void testIsisomorphic1(){
		String s1 = "foo";
		String s2 = "app";
		String s3 = "bar";
		assertTrue(MyString.isIsomorphic(s1, s2));
		assertFalse(MyString.isIsomorphic(s1, s3));
	}
	
	public void testIsisomorphic2(){
		String s2 = "fot";
		String s4 = "app";
		assertFalse(MyString.isIsomorphic(s2, s4));
	}
	
	public void testIsisomorphic3(){
		String s1 = "turtle";
		String s2 = "tletur";
		assertTrue(MyString.isIsomorphic(s1, s2));
	}
	
	public void testIsAnagrams1(){
		String s1 = "abdc";
		String s2 = "dbca";
		assertTrue(MyString.isAnagrams1(s1, s2));
	}
	
	public void testIsAnagrams2(){
		String s1 = "abdc";
		String s2 = "dbca";
		assertTrue(MyString.isAnagrams2(s1, s2));
	}
	
	public void testAnagrams1(){
		String[] s = new String[]{"abdc", "dbca", "ddac"};
		List<String> result = new ArrayList<String>();
		result.add("abdc");
		result.add("dbca");
		assertEquals(result, MyString.anagrams1(s));
	}
	
	public void testAnagrams2(){
		String[] s = new String[]{"abdc", "dbca", "ddac"};
		List<String> result = new ArrayList<String>();
		result.add("abdc");
		result.add("dbca");
		assertEquals(result, MyString.anagrams2(s));
	}
	
	public void testAnagrams3(){
		String[] s = new String[]{"abdc", "dbca", "ddac"};
		List<String> result = new ArrayList<String>();
		result.add("abdc");
		result.add("dbca");
		assertEquals(result, MyString.anagrams3(s));
	}
	
	public void testAnagrams4(){
		String[] s = new String[]{"", ""};
		List<String> result = new ArrayList<String>();
		result.add("");
		result.add("");
		assertEquals(result, MyString.anagrams3(s));
	}
	
    public void testReverseWords1(){
    	assertEquals("blue is sky the", MyString.reverseWords1("the sky is blue"));
    	assertEquals("world! hello", MyString.reverseWords1("  hello world!  "));
    	assertEquals("", MyString.reverseWords1(""));
    }
    
    public void testReverseWords2(){
    	assertEquals("blue is sky the", MyString.reverseWords2("the sky is blue"));
    	assertEquals("world! hello", MyString.reverseWords2("  hello world!  "));
    	assertEquals("", MyString.reverseWords2(""));
    }
    
    public void testReverseWords3(){
    	assertEquals("blue is sky the", MyString.reverseWords3("the sky is blue"));
    	assertEquals("world! hello", MyString.reverseWords3("  hello world!  "));
    	assertEquals("", MyString.reverseWords3(""));
    }
    
    public void testIsPalindrome1() {
    	String s = "A man, a plan, a canal: Panama";
    	assertTrue(MyString.isPalindrome(s));
    }
    
    public void testIsPalindrome2() {
    	String s = "race a car";
    	assertFalse(MyString.isPalindrome(s));
    }
    
    public void testConvert1() {
    	String s = "A";
    	assertEquals("A", MyString.convert(s, 2));
    }
    
    public void testConvert2() {
    	String s = "A";
    	assertEquals("A", MyString.convert(s, 1));
    }
    
    public void testNumCount1() {
    	String s = "ababc";
    	assertEquals(2, MyString.numCount('a', s));
    	assertEquals(2, MyString.numCount('b', s));
    	assertEquals(1, MyString.numCount('c', s));
    	assertEquals(0, MyString.numCount('d', s));
    }
    
    public void testRemoveVowel() {
    	String s = "abiubco";
    	assertEquals("bbc", MyString.removeVowels(s));
    }
    
    public void testConvertToTitle() {
    	assertEquals("AZ", MyString.convertToTitle1(52));
    }
    
    public void testCompareVersion1() {
    	String v2 = "1.1";
    	String v3 = "1.10";
    	assertEquals(-1, MyString.compareVersion1(v2, v3));
    }
    
    public void testCompareVersion2() {
    	String v1 = "1.1";
    	String v2 = "1.01.0";
    	assertEquals(0, MyString.compareVersion1(v1, v2));
    }
    
    public void testCompareVersion3() {
    	String v1 = "0.1";
    	String v2 = "0.0.1";
    	assertEquals(1, MyString.compareVersion1(v1, v2));
    }
    
    public void testCompareVersion4() {
    	String v2 = "1.1";
    	String v3 = "1.10";
    	assertEquals(-1, MyString.compareVersion2(v2, v3));
    }
    
    public void testCompareVersion5() {
    	String v1 = "1.1";
    	String v2 = "1.01.0";
    	assertEquals(0, MyString.compareVersion2(v1, v2));
    }
    
    public void testCompareVersion6() {
    	String v1 = "0.1";
    	String v2 = "0.0.1";
    	assertEquals(1, MyString.compareVersion2(v1, v2));
    }
    
    public void testLengthOfLongestSubstring1() {
    	String s1 = "abcacbbb";
    	assertEquals(3, MyString.lengthOfLongestSubstring(s1));
    }
    
    public void testLengthOfLongestSubstring2() {
    	String s1 = "bbbbb";
    	assertEquals(1, MyString.lengthOfLongestSubstring(s1));
    }
    
    public void testIsMatch1() {
    	assertFalse(MyString.isMatch("aa", "a"));
    	assertTrue(MyString.isMatch("aa", "*?"));
    	assertFalse(MyString.isMatch("aaa","aa"));
    	assertTrue(MyString.isMatch("a", "a*"));
    	assertTrue(MyString.isMatch("ab", "?*"));
    	assertFalse(MyString.isMatch("aab", "c*a*b"));
    	assertTrue(MyString.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    	assertFalse(MyString.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
    }
    
    public void testIsMatch2() {
    	assertFalse(MyString.isMatch("aa", "a"));
    	assertTrue(MyString.isMatch("aa", ".*"));
    	assertFalse(MyString.isMatch("aaa","aa"));
    	assertTrue(MyString.isMatch("a", "a*"));
    	assertTrue(MyString.isMatch("ab", ".*"));
    	assertTrue(MyString.isMatch("aab", "c*a*b"));
    }
    
    public void testRotateString() {
    	assertTrue(MyString.rotateString("aabcd", "cdaab"));
    	assertFalse(MyString.rotateString("aa", "a"));
    }
    
    public void testShift() {
    	String s = "abcd123";
    	String result = MyString.shift(s, 3);
    	assertTrue(result.equals("123abcd"));
    }
}
