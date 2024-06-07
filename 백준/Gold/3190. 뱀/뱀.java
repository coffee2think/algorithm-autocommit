import java.io.*;
import java.util.*;

public class Main {
    static int[][] map; // 0 : 빈칸, 1 : 몸, 2 : 사과
    static int headX, headY; // 머리 좌표
    static int tailX, tailY; // 꼬리 좌표
    static int time = 0;

    static int headDirection = 0; // 머리 방향
    static Queue<Integer> tailDirection = new LinkedList<>(); // 꼬리가 움직일 방향
    static int[] dx = {1, 0, -1, 0}; // 동 남 서 북
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        map[0][0] = 1; // 처음 뱀의 위치
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        int[][] command = new int[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            command[i][0] = Integer.parseInt(st.nextToken());
            command[i][1] = st.nextToken().charAt(0) == 'L' ? -1 : 1; // -1 : 반시계, 1 : 시계
        }

        // solution
        tailDirection.offer(headDirection);

        int commandIndex = 0;
        while (isMovable()) {
            move();

            // 이동이 끝난 시간에 회전 명령이 있을 경우 머리 회전
            if (commandIndex < L && time == command[commandIndex][0]) {
                headDirection = (headDirection + command[commandIndex][1] + 4) % 4;
                commandIndex++;
            }
            
            tailDirection.offer(headDirection);
        }

        // print result
        System.out.println(time + 1);
        br.close();
    }

    public static boolean isMovable() {
        int hx = headX + dx[headDirection];
        int hy = headY + dy[headDirection];

        // 머리가 벽에 부딪혔을 경우 종료
        if (hx < 0 || hy < 0 || hx >= map[0].length || hy >= map.length) {
            return false;
        }

        // 머리가 몸에 부딪혔을 경우 false
        return map[hy][hx] != 1;
    }

    public static void move() {
        headX += dx[headDirection];
        headY += dy[headDirection];

        // 이동 위치에 사과가 없을 경우 꼬리도 움직임
        if (map[headY][headX] == 0) {
            map[tailY][tailX] = 0;
            int td = tailDirection.poll();
            tailX += dx[td];
            tailY += dy[td];
        }

        map[headY][headX] = 1;
        time++;
    }
}
