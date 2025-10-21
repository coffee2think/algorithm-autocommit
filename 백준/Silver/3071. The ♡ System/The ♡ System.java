import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int T = Integer.parseInt(br.readLine());

        // when
        for (int t = 0; t < T; t++) {
            StringBuilder ternaryBuilder = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            int r = 0;
            boolean sign = true; // true: 양수, false: 음수

            if (n == 0) {
                sb.append(0).append("\n");
                continue;
            } else if (n < 0) {
                sign = false;
                n = -n;
            }

            Stack<Integer> stack = new Stack<>();
            while (n > 0) {
                r = n % 3;
                n /= 3;

                stack.push((r == 2 ? -1 : r) * (sign ? 1 : -1));
                n += (r == 2) ? 1 : 0;
            }

            while (!stack.isEmpty()) {
                int value = stack.pop();
                ternaryBuilder.append(value == -1 ? "-" : value);
            }
            sb.append(ternaryBuilder).append("\n");
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
