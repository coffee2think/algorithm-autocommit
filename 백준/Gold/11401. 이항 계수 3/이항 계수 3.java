import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int divisor = 1_000_000_007;

        // when
        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= N; i++) {
            factorial[i] = (factorial[i - 1] * i) % divisor;
        }

        long A = factorial[N];
        long B = (factorial[K] * factorial[N - K]) % divisor;
        long result = (A * pow(B, divisor - 2, divisor)) % divisor;

        // then
        System.out.println(result);
        br.close();
    }

    public static long pow(long base, long exp, long divisor) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % divisor;
            }

            base = (base * base) % divisor;
            exp /= 2;
        }

        return result;
    }
}
