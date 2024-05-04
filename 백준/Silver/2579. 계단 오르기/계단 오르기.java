import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N + 1];
        int[] dp = new int[stairs.length];
        for (int i = 1; i < stairs.length; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        if(N > 1) dp[2] = dp[1] + stairs[2];
        for (int i = 3; i < stairs.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(dp[N]);
        br.close();
    }
}
