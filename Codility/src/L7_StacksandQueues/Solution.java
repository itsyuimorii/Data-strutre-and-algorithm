package L7_StacksandQueues;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-02 18:45
 **/
public class Solution {
    public int solution(int[] A, String[] D) {
        int[] payment = new int[12];    // total card payments per month
        int[] transfer = new int[12];    // total incoming transfer per month
        int[] count = new int[12];        // number of payments per month
//        for (int i = 0; i < 12; i++) {
//            payment[i] = 0;
//            transfer[i] = 0;
//            count[i] = 0;
//        }
        for (int i = 0; i < A.length; i++) {
            String[] date = D[i].split("-", 3);
            int month = Integer.parseInt(date[1]);

            if (A[i] >= 0) {
                transfer[month - 1] += A[i];
            } else {
                payment[month - 1] -= A[i];
            }
                count[month - 1]++;
        }


        // Empty account at the beginning of the year
        int balance = 0;

        for (int i = 0; i < 12; i++) {
            balance += transfer[i] - payment[i];
            if (count[i] < 3 || payment[i] < 100)    // if <3 payments or <100 total cost
                balance -= 5;                        // fee deduction
        }
        return balance;
    }

    public static void main(String[] args) {
        int[] A = {100, 100, 100, -10};
        String[] D = {"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"};
        System.out.println(new Solution().solution(A, D));

    }
}