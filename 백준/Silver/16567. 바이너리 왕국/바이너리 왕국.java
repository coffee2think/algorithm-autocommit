import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] road = new boolean[N];

        st = new StringTokenizer(br.readLine());
        road[0] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
        int flipCount = road[0] ? 1 : 0;
        for (int i = 1; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true; // false: 깨끗, true: 오염
            if (!road[i - 1] && road[i]) {
                flipCount++;
            }
        }

        // when
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                sb.append(flipCount).append("\n");
                continue;
            }

            int target = Integer.parseInt(st.nextToken()) - 1;

            if (road[target]) {
                continue;
            }

            road[target] = true;
            flipCount++;

            if (target > 0 && road[target - 1] && road[target]) {
                flipCount--;
            }

            if (target < N - 1 && road[target] && road[target + 1]) {
                flipCount--;
            }
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
