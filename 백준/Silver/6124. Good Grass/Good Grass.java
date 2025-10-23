import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int[][] p = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < cols; c++) {
                p[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // when
        int maxScore = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                int sum = 0;
                for (int ri = 0; ri < 3; ri++) {
                    for (int ci = 0; ci < 3; ci++) {
                        sum += p[r + ri][c + ci];
                    }
                }

                if (sum > maxScore) {
                    maxScore = sum;
                    maxRow = r + 1;
                    maxCol = c + 1;
                }
            }
        }

        // then
        System.out.println(maxScore + "\n" + maxRow + " " + maxCol);
        br.close();
    }
}
