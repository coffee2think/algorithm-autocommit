import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];

        // 테두리
        for (int i = 0; i < N; i++) {
            map[0][i] = true;
            map[N - 1][i] = true;
            map[i][0] = true;
            map[i][N - 1] = true;
        }

        // X자
        for (int i = 1; i < (N + 1) / 2; i++) {
            map[i][i] = map[i][N - 1 - i] = map[N - 1 - i][i] = map[N - 1 - i][N - 1 - i] = true;
        }

        // 문자 생성
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(map[r][c] ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
