package LinearStructure;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-30 23:59
 **/
public class SparseArr {
    public static void main(String[] args) {
        //create 2-D array
        int[][] sparse = {{0, 0, 7, 0},
                {1, 0, 0, 0},
                {2, 0, 5, 0},
                {0, 8, 0, 4}};

        //Using variable sparseNum to record non-zero elements found in sparse array
        int sparseNum = 0;
        for (int i = 0; i < sparse.length; i++) {
            for (int j = 0; j < sparse[i].length; j++) {
                if (sparse[i][j] != 0) {
                    sparseNum++;
                }
            }
        }
//Store the non-zero elements found in sparse array into a sparse array
        int[][] sparseArray = new int[3][sparseNum];
        /**
         * [0] sparseNum
         * [1] sparseNum
         * [2] sparseNum
         */




    }

}



