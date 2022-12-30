package L3_Time_Complexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-29 21:50
 **/
public class PermMinssingElem {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i]) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    public int solution2(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < A.length; i++) {
            list.add(i);
        }
        return 0;
    }

    public static void main(String[] args) {
        PermMinssingElem p = new PermMinssingElem();
        System.out.println(p.solution(new int[]{12, 13, 1, 5}));
    }
}

