package L7_StacksandQueues;

/**
 * @program: Data-strutre-and-algorithm
 * @description:
 * @author: yuimorii
 * @create: 2023-01-02 17:19
 **/
class Brackets {
    public int solution(String S) {
        java.util.Map<String, String> charPairs = new java.util.HashMap<>();
        charPairs.put(")", "(");
        charPairs.put("}", "{");
        charPairs.put("]", "[");

        java.util.Stack<String> stack = new java.util.Stack();
        for (char c : S.toCharArray()) {
            String currentFlag = String.valueOf(c);
            if (charPairs.containsKey(currentFlag)) {
                // this is an ending flag
                if (stack.isEmpty()) return 0;

                String s = stack.pop();
                if (!charPairs.get(currentFlag).equals(s)) {
                    return 0;
                }
            } else {
                stack.push(currentFlag);
            }
        }

        if (stack.isEmpty()) return 1;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Brackets().solution("([])"));
    }
}