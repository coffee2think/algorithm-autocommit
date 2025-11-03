import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, List<String>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                map.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
            }

            int count = 1;
            for (String type : map.keySet()) {
                count *= map.get(type).size() + 1;
            }
            count--;

            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
