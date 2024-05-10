import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                paper[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        divide(paper, 0, 0, N);

        for (int i = 0; i < count.length; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    // 영역 분할
    public static void divide(int[][] paper, int x, int y, int size) {
        if (size == 1) {
            count[paper[y][x] + 1]++;
            return;
        }

        if (isIdentical(paper, x, y, size)) {
            count[paper[y][x] + 1]++;
        } else {
            int newSize = size / 3;
            for (int dy = 0; dy < 3; dy++) {
                for (int dx = 0; dx < 3; dx++) {
                    divide(paper, x + dx * newSize, y + dy * newSize, newSize);
                }
            }
        }
    }

    // 영역 안의 숫자가 모두 같은지 확인
    public static boolean isIdentical(int[][] paper, int x, int y, int size) {
        int value = paper[y][x];
        for (int j = y; j < y + size; j++) {
            for (int i = x; i < x + size; i++) {
                if (paper[j][i] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
