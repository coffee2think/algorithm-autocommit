import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // when
        int[] dp = new int[N + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i; // 최대 개수는 모두 1로 합하는 경우
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 제곱수인 경우 dp[0] + 1 = 1이 됨
            }
        }


        // then
        System.out.println(dp[N]);
        br.close();
    }
}
