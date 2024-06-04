import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int count = 0;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        map = new int[N][M]; // 0 : 빈칸, 1 : 벽, 2 : 청소됨
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solution
        cleaning(c, r, d);

        // print result
        System.out.println(count);
        br.close();
    }

    public static void cleaning(int x, int y, int d) {
        if (map[y][x] == 0) {
            map[y][x] = 2;
            count++;
        }

        if (checkAround(x, y)) { // 주변에 청소되지 않은 빈칸이 있는 경우
            do {
                d = (d + 3) % 4; // 방향을 반시계 방향으로 90도 회전
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (map[ny][nx] == 0) { // 바라보는 방향이 청소되지 않은 빈칸인 경우 전진
                    cleaning(nx, ny, d);
                    break;
                }
            } while(true);
        } else { // 주변에 청소되지 않은 빈칸이 없는 경우
            int back = (d + 2) % 4; // 후진 방향
            int nx = x + dx[back];
            int ny = y + dy[back];
            if (map[ny][nx] == 1) { // 후진 위치가 벽이라면 종료
                return;
            } else { // 후진 가능하면 후진 후 청소 진행
                cleaning(nx, ny, d);
            }
        }
    }

    // 주변에 청소되지 않는 빈칸이 있으면 true, 없으면 false
    public static boolean checkAround(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (map[ny][nx] == 0) {
                return true;
            }
        }

        return false;
    }
}
