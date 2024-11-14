import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int row = 0; row < N; row++) {
            String[] tokens = br.readLine().split(" ");
            for (int col = 0; col < N; col++) {
                pq.offer(Integer.parseInt(tokens[col]));
            }
        }

        // solution
        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        int answer = pq.poll();

        // output
        System.out.println(answer);
        br.close();
    }
}
