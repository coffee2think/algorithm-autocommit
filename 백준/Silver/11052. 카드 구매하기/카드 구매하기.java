import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // when
        int[] dp = new int[N + 1]; // i개 구매할 때 최댓값
        dp[1] = prices[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = prices[i];
            int left = 1;
            int right = i - 1;
            while (left <= right) {
                dp[i] = Math.max(dp[i], dp[left++] + dp[right--]);
            }
        }

        // then
        System.out.println(dp[N]);
        br.close();
    }
}
