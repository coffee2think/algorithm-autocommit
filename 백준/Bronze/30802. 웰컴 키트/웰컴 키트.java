import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());

        int[] sizes = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // solution
        int tshirtCount = 0;
        for (int i = 0; i < sizes.length; i++) {
            tshirtCount += (sizes[i] + T - 1) / T;
        }

        sb.append(tshirtCount).append("\n")
                .append(N / P).append(" ").append(N % P);

        // print result
        System.out.println(sb);
        br.close();
    }
}
