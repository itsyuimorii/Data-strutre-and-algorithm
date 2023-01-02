package _242_ValidAnagram;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-01 19:06
 **/
/*
Build your own hash table and iterate through the two strings.
1. get the position of the character in the array: each loop, take out the ith element in s, subtract its ASCII code from the ASCII code corresponding to the letter a to know the current position of the character in the array.

2. the number of occurrences of the character at that position +1, then take out the ith element in t, subtract its ASCII code from the ASCII code corresponding to letter a, to know the current position of the character in the array, then the number of occurrences of the character at that position -1.

3. At the end of the loop, the array map is traversed, and if there are characters in the map whose number is not 0, then it is not an alphabetic anagram, otherwise it is an alphabetic anagram.

Translated with www.DeepL.com/Translator (free version)
 */
public class Solution01 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution01().isAnagram("dbc", "dbc"));

    }
}
