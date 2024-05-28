import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // solution
        boolean[] dp = new boolean[N + 1]; // false: 상근(SK), true: 창영(CY)
        if (N > 1) dp[2] = true;
        if (N > 3) dp[4] = true;
        for (int i = 5; i < dp.length; i++) {
            dp[i] = dp[i - 4];
        }

        // print result
        System.out.println(dp[N] ? "CY" : "SK");
        br.close();
    }
}
