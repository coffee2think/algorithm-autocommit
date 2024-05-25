import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] map = new int[height][width];
        int[][] count = new int[height][width];
        for (int y = 0; y < height; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < width; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                count[y][x] = -1;
            }
        }

        // when
        count[height - 1][width - 1] = 1;
        int result = countPaths(0, 0, map, count);

        // then
        System.out.println(result);
        br.close();
    }

    public static int countPaths(int x, int y, int[][] map, int[][] count) {
        // 이미 기록된 값이 있으면 값 리턴
        if (count[y][x] != -1) {
            return count[y][x];
        }

        // 기록된 값이 없는 경우 상하좌우 탐색
        count[y][x] = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // map을 벗어나면 스킵
            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            // 현 위치보다 낮은 지역의 경우의 수를 모두 합함
            if (map[ny][nx] < map[y][x]) {
                count[y][x] += countPaths(nx, ny, map, count);
            }
        }

        return count[y][x];
    }
}