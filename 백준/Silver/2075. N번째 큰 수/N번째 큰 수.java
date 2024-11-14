import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* given */
        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][N];
        for (int row = 0; row < table.length; row++) {
            String[] tokens = br.readLine().split(" ");
            for (int col = 0; col < table[0].length; col++) {
                table[row][col] = Integer.parseInt(tokens[col]);
            }
        }

        /* solution */
        PriorityQueue<Node> maxHeap = new PriorityQueue<>();

        // 각 열의 가장 큰 요소들이 있는 마지막 행 추가
        for (int col = 0; col < N; col++) {
            maxHeap.add(new Node(table[N - 1][col], N - 1, col));
        }

        // 가장 큰 숫자를 제거하고, 해당 숫자가 포함되었던 열의 다음 큰 숫자를 maxHeap에 추가
        // (N - 1) 번 반복
        for (int i = 0; i < N - 1; i++) {
            Node current = maxHeap.poll();

            int row = current.row;
            int col = current.col;

            maxHeap.offer(new Node(table[row - 1][col], row - 1, col));
        }
        
        int result = maxHeap.poll().value;

        /* output */
        System.out.println(result);
        br.close();
    }
    
    static class Node implements Comparable<Node> {
        int value;
        int row, col;

        public Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        // value를 기준으로 내림차순 정렬
        @Override
        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }
}
