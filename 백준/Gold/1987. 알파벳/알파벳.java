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
        boolean rotateFlag = false; // 회전 flag

        // 2차원 좌표를 1차원 인덱스로 변경하기 위해 큰 값을 가로로 바꿈
        // (x, y) = x + y * width
        // index = (index / width, index % width)
        if (width < height) {
            int tmp = width;
            width = height;
            height = tmp;
            rotateFlag = true;
        }

        map = new int[height][width];
        for (int i = 0; i < (rotateFlag ? width : height); i++) {
            String row = br.readLine();
            for (int j = 0; j < (rotateFlag ? height : width); j++) {
                if (rotateFlag) {
                    map[j][i] = row.charAt(j) - 'A';
                } else {
                    map[i][j] = row.charAt(j) - 'A';
                }
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
