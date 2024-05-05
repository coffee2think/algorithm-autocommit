import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int TOTAL_HEIGHT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(heights);

        boolean[] visited = new boolean[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if (dfs(1, i, 0, heights, visited)) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sb.append(heights[i]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean dfs(int depth, int index, int sum, int[] heights, boolean[] visited) {
        if (depth > 7) {
            return false;
        }

        visited[index] = true;
        sum += heights[index];

        if (depth == 7 && sum == TOTAL_HEIGHT) {
            return true;
        } else if (sum >= TOTAL_HEIGHT) {
            visited[index] = false;
            return false;
        }

        for (int i = index + 1; i < heights.length; i++) {
            if (!visited[i]) {
                if (dfs(depth + 1, i, sum, heights, visited)) {
                    return true;
                }
            }
        }

        visited[index] = false;
        return false;
    }
}
