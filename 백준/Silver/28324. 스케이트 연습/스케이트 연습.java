import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] limit = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < limit.length; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        int[] velocity = new int[N];
        int sum = velocity[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            velocity[i] = Math.min(velocity[i + 1] + 1, limit[i]);
            sum += velocity[i];
        }

        System.out.println(sum);
        br.close();
    }
}
