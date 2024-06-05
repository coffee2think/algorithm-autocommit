import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            String row = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = row.charAt(j) - 'A';
            }
        }

        // solution
        visited[map[0][0]] = true;
        dfs(0, 0, 1);

        // print result
        System.out.println(maxCount);
        br.close();
    }

    public static void dfs(int x, int y, int count) {
        if (maxCount < count) {
            maxCount = count;
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            int value = map[ny][nx];
            if (!visited[value]) {
                visited[value] = true;
                dfs(nx, ny, count + 1);
                visited[value] = false;
            }
        }
    }
}
