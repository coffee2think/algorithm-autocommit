import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    static class Node {
        int to;
        int distance;

        public Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 그래프 생성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // 양방향
            graph.get(from).add(new Node(to, distance));
            graph.get(to).add(new Node(from, distance));
        }

        int start = 1;
        int end = N;

        // 경유할 지점들
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // solution
        // case1: start → A → B → end
        int startToA = dijkstra(start, A, graph);
        int AToB = dijkstra(A, B, graph);
        int BToEnd = dijkstra(B, end, graph);
        int case1 = startToA == INF || AToB == INF || BToEnd == INF ? INF : startToA + AToB + BToEnd;

        // case2: start → B → A → end
        int startToB = dijkstra(start, B, graph);
        int BToA = AToB;
        int AToEnd = dijkstra(A, end, graph);
        int case2 = startToB == INF || BToA == INF || AToEnd == INF ? INF : startToB + BToA + AToEnd;

        // case1과 case2 중 작은 값
        int answer = Math.min(case1, case2);

        // result
        System.out.println(answer == INF ? -1 : answer);
        br.close();
    }

    // start에서 end로 가는 최단 경로의 길이, 다익스트라 알고리즘 적용
    public static int dijkstra(int start, int end, List<List<Node>> graph) {
        int[] minCost = new int[graph.size()];
        Arrays.fill(minCost, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        pq.offer(new Node(start, 0));
        minCost[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.distance > minCost[current.to]) {
                continue;
            }

            for (Node next : graph.get(current.to)) {
                if (minCost[next.to] > current.distance + next.distance) {
                    minCost[next.to] = current.distance + next.distance;
                    pq.offer(new Node(next.to, minCost[next.to]));
                }
            }
        }

        return minCost[end];
    }
}
