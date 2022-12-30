package L4_Counting_Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-30 09:37
 **/
public class MaxCounters {
    public int[] solution01(int N, int[] A) {
        /*
         * => N+1 max_counter
         * K index
         */
        //value of N represents length of counter array
        //Create new Array Counter to store array with N length
        int maxValue = 0;
        int[] counter = new int[N];

        for (int i = 0; i < A.length; i++) {

            int AIndex = A[i];
            if (AIndex == N + 1) {
                //max_counter
                for (int j = 0; j < counter.length; j++) {
                   counter[j]  = maxValue;
                }

            } else {
                //increment
                //A[i] => AIndex 对应 N 数组中 counterIndex - 1 (NIndex starts from 0)
                AIndex--;
                counter[AIndex]++;
                maxValue = Math.max(maxValue, counter[AIndex]);
                System.out.println(maxValue);

                System.out.println("-");
            }

        }
        return counter;
    }

    public static void main(String[] args) {
        MaxCounters mc = new MaxCounters();
        int[] result = mc.solution01(5, new int[]{3, 4, 4, 6, 1, 4, 4});
//        for (int i : result) {
//            System.out.println(i);
//        }
    }


}
