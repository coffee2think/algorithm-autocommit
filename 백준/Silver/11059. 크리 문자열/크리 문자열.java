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

        int maxRange = 0;
        for (int range = 2; range <= strLen; range += 2) {
            int half = range / 2;
            for (int right = range; right <= strLen; right++) {
                int prevSum = prefixSum[right - half] - prefixSum[right - range];
                int nextSum = prefixSum[right] - prefixSum[right - half];
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
