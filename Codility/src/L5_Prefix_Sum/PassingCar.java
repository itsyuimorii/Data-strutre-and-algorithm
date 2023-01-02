package L5_Prefix_Sum;

/**
 * @program: Data-structure-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2022-12-30 14:13
 **/
public class PassingCar {
    public int solution(int[] arr) {
        int passingCarEast = 0;
        int Sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                passingCarEast++;
            } else {
                Sum += passingCarEast;
            }
        }

        return Sum > 1000000000 ? -1 : passingCarEast;
    }

    public static void main(String[] args) {
        PassingCar car = new PassingCar();
        System.out.println(car.solution(new int[]{0, 1, 0, 1, 1}));
    }
}

