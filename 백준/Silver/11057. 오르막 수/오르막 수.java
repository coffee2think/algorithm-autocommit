import java.io.*;

public class Main {
    public static final int DIVISOR = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // when
        int[][] dp = new int[N + 1][10]; // dp[길이][시작하는 숫자]의 개수
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= DIVISOR;
                }
            }
        }

        // then
        int answer = 0;
        for (int value : dp[N]) {
            answer = (answer + value) % DIVISOR;
        }
        System.out.println(answer);
        br.close();
    }
}
