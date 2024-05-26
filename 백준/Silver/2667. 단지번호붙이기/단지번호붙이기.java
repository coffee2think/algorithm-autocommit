import java.io.*;
import java.util.PriorityQueue;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N]; // 방문 처리 배열
        for (int y = 0; y < N; y++) {
            String input = br.readLine();
            for (int x = 0; x < N; x++) {
                map[y][x] = input.charAt(x) - '0';
            }
        }

        // when
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (!visited[y][x] && map[y][x] == 1) {
                    int result = dfs(x, y);
                    pq.offer(result == 0 ? 1 : result); // 인근에 집이 없는 경우 1을 넣음
                }
            }
        }

        // then
        sb.append(pq.size()).append("\n"); // 단지수
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n"); // 단지별 가구수
        }
        System.out.println(sb);
        br.close();
    }

    public static int dfs(int x, int y) {
        int count = 0;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // map을 벗어나면 스킵
            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            // 방문하지 않았고, 집이 있으면 방문
            if (!visited[ny][nx] && map[ny][nx] == 1) {
                visited[ny][nx] = true;
                count += 1 + dfs(nx, ny);
            }
        }

        return count;
    }
}
