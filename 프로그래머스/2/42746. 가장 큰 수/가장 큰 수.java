// 다른 사람 풀이. 성능 비교용
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        boolean isZero = true;

        for (int i = 0; i < numbers.length; i++) {
            if (isZero && numbers[i] != 0) {
                isZero = false;
            }
            strs[i] = String.valueOf(numbers[i]);
        }
        if (isZero) {
            return "0";
        }

        Arrays.sort(strs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int maxLen = 4;
                char c1 = '0';
                char c2 = '0';
                int j = 0;

                for (int i = 0; i < maxLen; i++) {
                    if (i < o1.length()) {
                        c1 = o1.charAt(i);    
                    } else {
                        c1 = o1.charAt(i % o1.length());
                    }

                    if (i < o2.length()) {
                        c2 = o2.charAt(i);    
                    } else {
                        c2 = o2.charAt(i % o2.length());
                    }

                    if (c1 == c2) {
                        continue;
                    } else {
                        return c1 - c2;
                    }
                }

                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = strs.length-1; i >= 0; i--) {
            sb.append(strs[i]);
        }

        return sb.toString();
    }
}