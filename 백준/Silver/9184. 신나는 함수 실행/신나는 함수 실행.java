import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][][] wArr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int a, b, c;
        wArrInit();

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;
            else {
                sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        else if (a > 20 || b > 20 || c > 20) return wArr[20][20][20];
        else return wArr[a][b][c];
    }

    public static void wArrInit() {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        wArr[i][j][k] = 1;
                    } else if (i < j && j < k) {
                        wArr[i][j][k] = wArr[i][j][k - 1] + wArr[i][j - 1][k - 1] - wArr[i][j - 1][k];
                    } else {
                        wArr[i][j][k] = wArr[i - 1][j][k] + wArr[i - 1][j - 1][k] + wArr[i - 1][j][k - 1] - wArr[i - 1][j - 1][k - 1];
                    }
                }
            }
        }
    }
}
