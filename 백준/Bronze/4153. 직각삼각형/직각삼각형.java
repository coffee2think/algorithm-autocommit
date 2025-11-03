import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] sides = new int[3];
            for (int i = 0; i < sides.length; i++) {
                sides[i] = Integer.parseInt(st.nextToken());
            }

            if (sides[0] == 0) {
                break;
            }

            Arrays.sort(sides);

            sb.append(square(sides[2]) == square(sides[0]) + square(sides[1]) ? "right" : "wrong").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int square(int n) {
        if (n > Math.sqrt(Integer.MAX_VALUE)) {
            return -1; // 오버플로우 방지
        }

        return n * n;
    }
}
