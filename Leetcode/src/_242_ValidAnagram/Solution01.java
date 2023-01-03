package _242_ValidAnagram;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-01 19:06
 **/
/*
建立你自己的哈希表并遍历这两个字符串。
1.获得字符在数组中的位置：每次循环，取出s中的第i个元素，用字母a对应的ASCII码减去它的ASCII码，以知道该字符在数组中的当前位置。

2. 该位置的字符出现次数+1，然后取出t中的第i个元素，用字母a对应的ASCII码减去其ASCII码，知道该字符在数组中的当前位置，然后该位置的字符出现次数-1。

3. 循环结束时，遍历数组图，如果数组图中有编号不为0的字符，则不是字母重组，否则就是字母重组。

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
        System.out.println(new Solution01().isAnagram("dac", "dbc"));

    }
}
