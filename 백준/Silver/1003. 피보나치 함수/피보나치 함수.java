import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int T = Integer.parseInt(br.readLine());
        int[][] count = new int[41][2]; // {{0이 출력된 횟수, 1이 출력된 횟수}, ...}
        count[0][0] = 1;
        count[1][1] = 1;
        for (int i = 2; i < count.length; i++) {
            count[i][0] = count[i - 1][0] + count[i - 2][0];
            count[i][1] = count[i - 1][1] + count[i - 2][1];
        }

        // when
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(count[n][0]).append(" ").append(count[n][1]).append("\n");
        }

        // then
        System.out.println(sb.toString());
        br.close();
    }
}
