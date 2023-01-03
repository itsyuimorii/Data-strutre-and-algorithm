package _49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-01 20:39
 **/
public class Solution02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //create new arraylist to store result
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        //for loop the strs
        for (String current : strs) {
            //converts this string to a new character array.
            char[] chars = current.toCharArray();
            //Convert chars into String, as Arraylist can only store reference type
            Arrays.sort(chars);
            //back to string
            String sorted = new String(chars);
            //如果map里面不包含这个sorted后的值，那么把这个sorted 值 和 value 放进map
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            //Object get(Object key)：获取指定key对应的value
            map.get(sorted). add(current);
//            List<String> newSortedList = map.get(sorted);
//            newSortedList.add(current);

        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        Solution02 solution = new Solution02();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
