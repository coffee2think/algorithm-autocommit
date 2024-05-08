import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        // Arrays.sort()를 사용하기 위한 String 배열 초기화
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 앞뒤로 붙여서 비교하여 정렬
        Arrays.sort(strNumbers, (s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        });

        // 모두 "0"일 경우 "0"을 리턴
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 문자열 합치기
        for (String number : strNumbers) {
            sb.append(number);
        }

        return sb.toString();
    }
}