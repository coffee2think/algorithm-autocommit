import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // when
        int twoCount = 0;
        int fiveCount = 0;
        for (int i = 2; i <= N; i++) {
            int n = i;
            while (n % 5 == 0) {
                fiveCount++;
                n /= 5;
            }

            while (n % 2 == 0) {
                twoCount++;
                n /= 2;
            }
        }

        // then
        System.out.println(Math.min(twoCount, fiveCount));
        br.close();
    }
}
