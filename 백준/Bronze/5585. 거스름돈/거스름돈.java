import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * date: 2024-05-05
 * source: https://www.acmicpc.net/problem/5585
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int payback = 1000 - Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            count += payback / coins[i];
            payback = payback % coins[i];
        }

        System.out.println(count);
        br.close();
    }
}
