import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int[] cases = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(cases[n]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void init() {
        for (int n = 1; n <= 10; n++) {
            cases[n] = partitioning(n);
        }
    }

    public static int partitioning(int n) {
        return partitioning(n, new Stack<>());
    }

    public static int partitioning(int n, Stack<Integer> stack) {
        if (n < 1) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= Math.min(3, n); i++) {
            stack.push(i);
            count += partitioning(n - i, stack);
            stack.pop();
        }

        return count;
    }
}
