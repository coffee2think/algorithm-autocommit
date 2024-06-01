import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // given
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 개수
            map = new boolean[N][M]; // 지도 정보
            visited = new boolean[N][M]; // 방문 정보
            List<Point> points = new ArrayList<>(); // 배추 위치 목록
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = true;
                points.add(new Point(x, y));
            }

            // solution
            int count = 0;

            for (Point point : points) {
                if (!point.isVisited()) {
                    bfs(point);
                    count++;
                }
            }

            // result
            sb.append(count).append("\n");
        }

        // print result
        System.out.println(sb);
        br.close();
    }

    public static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);

        while (!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < dx.length; i++) {
                Point next = new Point(current.x + dx[i], current.y + dy[i]);

                if (!next.isOutOfMap() && !next.isVisited() && next.hasObject()) {
                    next.visit();
                    q.offer(next);
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 방문 처리
        public void visit() {
            visited[y][x] = true;
        }

        // 방문 여부 확인
        public boolean isVisited() {
            return visited[y][x];
        }

        // 맵을 벗어났는지 확인
        public boolean isOutOfMap() {
            return x < 0 || y < 0 || x >= map[0].length || y >= map.length;
        }

        // 배추(Object)가 있는지 확인
        public boolean hasObject() {
            return map[y][x];
        }
    }

}
