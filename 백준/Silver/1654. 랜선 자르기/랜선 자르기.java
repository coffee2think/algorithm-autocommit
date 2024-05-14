import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // given
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long left = 1;
        long right = 1;

        int[] cables = new int[K];
        for (int i = 0; i < cables.length; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, cables[i]);
        }

        // when
        long max = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int cable : cables) {
                cnt += cable / mid;
            }

            if (cnt >= N) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // then
        System.out.println(max);
        br.close();
    }
}
