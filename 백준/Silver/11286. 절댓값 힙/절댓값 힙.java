import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }

            return Math.abs(o1) - Math.abs(o2);
        });

        // when
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) { // poll 작업 수행
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else { // offer 작업 수행
                pq.offer(input);
            }
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
