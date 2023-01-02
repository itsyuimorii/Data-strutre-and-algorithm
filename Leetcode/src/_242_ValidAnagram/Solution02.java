package _242_ValidAnagram;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-01 19:17
 **/
public class Solution02 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){ return false; }
        //Create two maps to store characters
        Map<Character,Integer> sMap = new HashMap<Character,Integer>();
        Map<Character,Integer> tMap = new HashMap<Character,Integer>();
        //toCharArray() method converts a string to an array of characters.
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        //for-loop the Array-sChars
        for (char sChar : sChars) {

            if(!sMap.containsKey(sChar)){
                //put method will overwrite the value
                sMap.put(sChar,1);
            }else {
                sMap.put(sChar,sMap.get(sChar) + 1);
            }
        }
        for (char tChar : tChars) {
            if(!tMap.containsKey(tChar)){
                tMap.put(tChar,1);
            }else {
                tMap.put(tChar,tMap.get(tChar) + 1);
            }
        }
        return sMap.equals(tMap);
    }
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.isAnagram("abb","abb"));
    }
}


