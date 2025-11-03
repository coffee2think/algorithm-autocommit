import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] levels = new int[n];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(levels);

        int trim = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = trim; i < n - trim; i++) {
            sum += levels[i];
        }

        System.out.println(Math.round((double) sum / (n - trim * 2)));
        br.close();
    }
}
