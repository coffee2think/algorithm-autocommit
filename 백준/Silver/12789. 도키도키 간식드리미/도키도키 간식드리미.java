import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // when
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        while(st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());

            if (input != idx) {
                stack.push(input);
            } else {
                idx++;
            }

            while (!stack.isEmpty() && stack.peek() == idx) {
                stack.pop();
                idx++;
            }
        }

        // then
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
        br.close();
    }
}
