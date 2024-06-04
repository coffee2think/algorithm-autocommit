import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solution
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                visited[y][x] = true;
                dfs(x, y, map[y][x], 1);
                visited[y][x] = false;

                crossShape(x, y);
            }
        }

        // print result
        System.out.println(max);
        br.close();
    }

    public static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum); // 최댓값 갱신
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            if (!visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(nx, ny, sum + map[ny][nx], depth + 1);
                visited[ny][nx] = false;
            }
        }
    }

    // ㅜ 모양의 최대 점수 갱신
    public static void crossShape(int x, int y) {
        int count = 1;
        int sum = map[y][x];

        // 인접한 칸의 개수와 합을 누적
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            count++;
            sum += map[ny][nx];
        }

        if (count == 4) {
            // 개수가 4개이면 최댓값 갱신
            max = Math.max(max, sum);
        } else if (count == 5) {
            // 개수가 5개이면 인접한 칸을 하나씩 제거한 후 최댓값 갱신
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                sum -= map[ny][nx];
                max = Math.max(max, sum);
                sum += map[ny][nx];
            }
        }
    }
}
