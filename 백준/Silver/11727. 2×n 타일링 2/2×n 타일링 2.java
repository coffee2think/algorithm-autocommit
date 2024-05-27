import java.io.*;

public class Main {
    private static final int DIVISOR = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 3;
        }

        // when
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % DIVISOR;
        }

        // then
        System.out.println(dp[n]);
        br.close();
    }
}
