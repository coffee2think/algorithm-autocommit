import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[][] box = new int[height][width];
        List<int[]> ripeTomatoes = new ArrayList<>(); // 익은 토마토 목록
        int unripeTomatoesCount = 0; // 안 익은 토마토 개수

        for (int y = 0; y < height; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < width; x++) {
                box[y][x] = Integer.parseInt(st.nextToken());

                if (box[y][x] == 1) { // 익은 토마토 목록 저장
                    ripeTomatoes.add(new int[]{x, y, 0});
                } else if (box[y][x] == 0) { // 안 익은 토마토 개수 카운트
                    unripeTomatoesCount++;
                }
            }
        }

        // when
        Queue<int[]> q = new LinkedList<>(); // bfs 구현을 위한 큐
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우 이동을 위한 방향 배열
        int lastDay = 0; // 마지막으로 익은 토마토 날짜

        // bfs 초기값 설정
        for (int[] pos : ripeTomatoes) {
            q.offer(pos);
        }

        // bfs 구현
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            int days = pos[2];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // 범위를 벗어나면 건너뜀
                if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                    continue;
                }

                // 안 익은 토마토라면 익게 만들고 큐에 추가
                if (box[ny][nx] == 0) {
                    box[ny][nx] = 1;
                    unripeTomatoesCount--;
                    lastDay = days + 1;
                    q.offer(new int[]{nx, ny, days + 1});
                }
            }
        }

        // then
        // 안 익은 토마토가 남아있으면 -1 출력, 아니면 마지막으로 익은 토마토 날짜 출력
        System.out.println(unripeTomatoesCount > 0 ? -1 : lastDay);
        br.close();
    }
}
