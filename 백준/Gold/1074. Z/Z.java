import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] pow; // 2의 거듭제곱

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // solution
        initPow(N);
        int result = divide(N, r, c);

        // print result
        System.out.println(result);
        br.close();
    }

    public static int divide(int N, int r, int c) {
        int order = c / pow[N - 1] + r / pow[N - 1] * 2; // 구역 순서
        order *= pow[2 * (N - 1)]; // 4^(N-1)을 곱함

        if (N > 1) {
            order += divide(N - 1, r % pow[N - 1], c % pow[N - 1]); // 더 작은 부분에서의 순서를 더함
        }

        return order;
    }

    public static void initPow(int N) {
        pow = new int[2 * N + 1];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 2;
        }
    }
}
