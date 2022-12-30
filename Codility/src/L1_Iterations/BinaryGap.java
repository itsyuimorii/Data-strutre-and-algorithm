package L1_Iterations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-29 20:42
 **/
public class BinaryGap {
    public int solution01(int N) {
        // Convert numbers to binary
        String num = Integer.toBinaryString(N);
        //Split the array N
        String[] nums = num.split("");
        int counter = 0;
        int maxCouter = 0;
        // Use a for loop to iterate through each element of the array, and count ++ when 0 is encountered,
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].equals("1")) {
                //1. If the second 1 is encountered, the number of zeros in the middle is counted, and if the number of counters > maxCounter, then the counters are assigned to the counters.
                //2. The reason for maxCounter here is that if the number encountered is 100100001, then there are more zeros between the next 11, then the number of zeros to be returned
                if (counter > maxCouter) {
                    maxCouter = counter;
                }
                //1. If the first number is 1 when encountered, put counter to 0, the condition is not valid
                //2. If the second 1 is encountered, the counter will be 0 and the number of 0s will be recalculated
                counter = 0;
            }
            if (nums[i].equals("0")) {
                counter++;
            }
        }
        return maxCouter;
    }

    public int solution02(int N) {
        // Convert numbers to binary
        String binaryNum = Integer.toBinaryString(N);
        //Split the array N
        String[] binaryArr = binaryNum.split("");
        //Testing
        //for (String s : binaryArr) {
        //System.out.println(s);
        //}
        int counter = 0;
        //用arraylist装counter的数
        List<Integer> list = new ArrayList<>();
        for (String string : binaryArr) {
            if (string.equals("0")) {
                counter++;
            } else {
                list.add(counter);
                counter = 0;
            }
        }
        return Collections.max(list);
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.solution01(549));
        System.out.println(bg.solution02(549));
    }
}

