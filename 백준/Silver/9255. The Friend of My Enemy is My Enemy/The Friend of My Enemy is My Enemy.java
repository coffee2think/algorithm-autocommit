import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // given
        int K = Integer.parseInt(br.readLine());

        // when
        for (int k = 1; k <= K; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                map.computeIfAbsent(from, key -> new TreeSet<>()).add(to);
                map.computeIfAbsent(to, key -> new TreeSet<>()).add(from);
            }

            int s = Integer.parseInt(br.readLine());

            sb.append("Data Set " + k + ":\n");
            if (map.containsKey(s)) {
                for (int v : map.get(s)) {
                    sb.append(v).append(" ");
                }
                sb.replace(sb.length() - 1, sb.length(), "");
            }
            sb.append("\n\n");
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
