import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> passMap = new HashMap<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            passMap.put(st.nextToken(), st.nextToken());
        }

        // when
        for (int m = 0; m < M; m++) {
            sb.append(passMap.get(br.readLine())).append("\n");
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
