package LinearStructure;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-31 00:01
 **/
public class checkerboard {
    public static void main(String[] args) {
        //2-d array 11*!1
        //0: no Pieces 1: black 2:white
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        //for-loop 2-D array
        for (int[] row : chessArray) {
            for (int data : row) {
                //%d represent result int
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //1.2-d array to sparse array.
        //for-loop 2-D array, get non-zero elements.
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;

                }
            }
            System.out.println("sum" + sum);
        }
        //2. create new SparseMatrix
        int sparseMatrix[][] = new int[sum + 1][3];
        sparseMatrix[0][0] = 11;
        sparseMatrix[0][1] = 11;
        sparseMatrix[0][2] = sum;
        // for-loop 2-D array, store non-zero elements into sparse matrix.
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray[i][j]!= 0) {

                }
            }

        }
    }

}
