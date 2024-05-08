import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        // Arrays.sort()를 사용하기 위한 박싱
        Integer[] boxingNumbers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            boxingNumbers[i] = numbers[i];
        }

        // 배열 정렬
        Arrays.sort(boxingNumbers, (o1, o2) -> {
            int digit1 = (o1 == 0) ? 0 : (int)Math.log10(o1);
            int digit2 = (o2 == 0) ? 0 : (int)Math.log10(o2);

            int case1 = o1 * (int)Math.pow(10, digit2 + 1) + o2; // o1 + o2
            int case2 = o2 * (int)Math.pow(10, digit1 + 1) + o1; // o2 + o1

            return case2 - case1;
        });

        // 모든 수가 0이라면 0을 리턴
        if (boxingNumbers[0] == 0) {
            return "0";
        }

        // 정렬된 배열을 문자열로 담음
        for (int n : boxingNumbers) {
            sb.append(n);
        }

        return sb.toString();
    }
}