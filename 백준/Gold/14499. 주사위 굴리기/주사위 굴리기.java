import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static Dice dice = new Dice();
    static final int[] dx = {1, -1, 0, 0}; // 동 서 북 남
    static final int[] dy = {0, 0, -1, 1};

    static class Dice {
        int top, bottom;
        int front, back;
        int left, right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // given
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solution
        st = new StringTokenizer(br.readLine());
        while (count-- > 0) {
            int command = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[command];
            int ny = y + dy[command];

            if (nx < 0 || ny < 0 || nx >= map[0].length || ny >= map.length) {
                continue;
            }

            rolling(command);
            sb.append(dice.top).append("\n"); // 윗면 기록

            if (map[ny][nx] == 0) {
                map[ny][nx] = dice.bottom;
            } else {
                dice.bottom = map[ny][nx];
                map[ny][nx] = 0;
            }

            x = nx;
            y = ny;
        }

        // print result
        System.out.println(sb);
        br.close();
    }

    public static void rolling(int command) {
        int tmp;

        switch (command) {
            case 0: // 동쪽으로 굴림
                tmp = dice.top;
                dice.top = dice.left;
                dice.left = dice.bottom;
                dice.bottom = dice.right;
                dice.right = tmp;
                break;
            case 1: // 서쪽으로 굴림
                tmp = dice.top;
                dice.top = dice.right;
                dice.right = dice.bottom;
                dice.bottom = dice.left;
                dice.left = tmp;
                break;
            case 2: // 북쪽으로 굴림
                tmp = dice.top;
                dice.top = dice.front;
                dice.front = dice.bottom;
                dice.bottom = dice.back;
                dice.back = tmp;
                break;
            case 3: // 남쪽으로 굴림
                tmp = dice.top;
                dice.top = dice.back;
                dice.back = dice.bottom;
                dice.bottom = dice.front;
                dice.front = tmp;
                break;
        }
    }

}
