package L4_Counting_Elements;

import java.util.HashSet;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-29 22:41
 **/
public class FrogRiverOne {
    public int solution(int X, int[] A) {

        HashSet<Integer> fallenLeafSet = new HashSet<>();
        for (int K = 0; K < A.length; K++) {
            int fallenLeaf = A[K];
            fallenLeafSet.add(fallenLeaf);
            if (fallenLeafSet.size()== X) {
                return K;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new FrogRiverOne().solution(5, new int[]{5,4,2,3,1,5}));
    }
}

