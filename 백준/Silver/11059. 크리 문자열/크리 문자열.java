import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        String str = br.readLine();
        int strLen = str.length();

        // when
        int[] prefixSum = new int[strLen + 1];
        for (int i = 0; i < strLen; i++) {
            prefixSum[i + 1] = prefixSum[i] + (str.charAt(i) - '0');
        }

        int maxEvenRange = strLen >> 1 << 1; // == strLen / 2 * 2. 최대 짝수 길이
        int maxRange = 0;
        for (int range = maxEvenRange; range > 0; range -= 2) {
            int half = range / 2;
            for (int left = 0; left <= strLen - range; left++) {
                int prevSum = prefixSum[left + half] - prefixSum[left];
                int nextSum = prefixSum[left + range] - prefixSum[left + half];
                if (prevSum == nextSum) {
                    maxRange = Math.max(range, maxRange);
                }
            }
        }

        // then
        System.out.println(maxRange);
        br.close();
    }
}
