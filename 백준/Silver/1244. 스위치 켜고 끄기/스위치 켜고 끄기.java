import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int n = Integer.parseInt(br.readLine()); // 스위치 개수
        int[] switches = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < switches.length; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // 학생 수

        // solution
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                boy(pos, switches);
            } else {
                girl(pos, switches);
            }
        }

        // print result
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < switches.length; i++) {
            sb.append(switches[i]).append(i % 20 == 0 ? "\n" : " ");
        }
        System.out.println(sb);
        br.close();
    }

    public static void boy(int pos, int[] switches) {
        for (int i = 1; pos * i < switches.length; i++) {
            switches[pos * i] = 1 - switches[pos * i];
        }
    }

    public static void girl(int pos, int[] switches) {
        int left = pos - 1;
        int right = pos + 1;

        switches[pos] = 1 - switches[pos];
        while (left >= 1 && right < switches.length) {
            if (switches[left] != switches[right]) {
                return;
            }

            int value = 1 - switches[left];
            switches[left--] = switches[right++] = value;
        }
    }
}
