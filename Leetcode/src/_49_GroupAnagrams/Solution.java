package _49_GroupAnagrams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-01 19:22
 **/
public class Solution {
    // 从给定的单词列表中对字谜进行分组的函数
    public static Set<Set<String>> groupAnagrams(List<String> words) {
        // 一组存储字谜
        Set<Set<String>> anagrams = new HashSet<>();

        // 基本情况
        if (words == null) {
            return anagrams;
        }

        // 对列表中的每个单词进行排序
        List<String> list = words.stream()
                .map(s -> Stream.of(s.split("")).sorted()
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());

        // 构造一个映射，其中键是每个排序的单词，
        // 并且 value 是它所在的索引列表
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.putIfAbsent(list.get(i), new ArrayList<>());
            map.get(list.get(i)).add(i);
        }

        // 遍历地图并读取每个排序键的索引。
        // 字谜出现在这些索引处的实际列表中
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            Set<String> collection = entry.getValue().stream()
                    .map(i -> words.get(i))
                    .collect(Collectors.toSet());
            if (collection.size() > 1) {
                anagrams.add(collection);
            }
        }

        return anagrams;
    }

    public static void main(String[] args) {

        //单词列表
        List<String> words = Arrays.asList("CARS", "REPAID", "DUES", "NOSE", "SIGNED",
                "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN");

        Set<Set<String>> anagrams = groupAnagrams(words);
        for (Set<String> anagram : anagrams) {
            System.out.println(anagram);
        }
    }
}


