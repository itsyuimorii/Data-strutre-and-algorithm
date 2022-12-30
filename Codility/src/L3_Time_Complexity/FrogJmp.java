package L3_Time_Complexity;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-29 21:21
 **/
public class FrogJmp {
    public int solution(int X, int Y, int D) {
        int jumpDistance = Y - X;
        int result = (int)Math.ceil(jumpDistance / (double)D);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new FrogJmp().solution(10, 85, 30));

    }
}

