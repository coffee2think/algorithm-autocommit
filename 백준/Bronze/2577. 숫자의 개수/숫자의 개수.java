import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String product = Integer.toString(A * B * C);
        int[] count = new int[10];

        for (int i = 0; i < product.length(); i++) {
            count[product.charAt(i) - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
