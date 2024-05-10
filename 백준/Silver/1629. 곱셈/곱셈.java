import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(divide(A, B, C));
        br.close();
    }

    public static int divide(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }

        int half = divide(a, b / 2, c);
        return modToInt((long)modToInt((long)half * half, c) * (b % 2 == 1 ? a % c : 1), c);
    }

    public static int modToInt(long num, int divisor) {
        return (int)(num % divisor);
    }
}
