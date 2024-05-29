import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE;

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 그래프 생성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) { // 그래프에 1부터 V까지 정점 생성. 0은 미사용 정점
            graph.add(new ArrayList<>());
        }

        // 그래프 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }

        // solution
        int[] distance = new int[V + 1]; // start로부터 정점까지 최소 비용 저장
        Arrays.fill(distance, INF); // INF : 연결되지 않음을 표현

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 간선의 가중치를 기준으로 오름차순 정렬
        pq.offer(new Node(start, 0)); // 시작 노드
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // 간선의 비용이 저장된 최소 비용보다 크면 갱신하지 않음
            if (current.cost > distance[current.to]) {
                continue;
            }

            // 그래프에서 현재 노드와 연결된 간선들을 탐색함
            for (Node next : graph.get(current.to)) {
                // 비용이 줄어들면 최소 비용을 갱신하고, 큐에 작업 추가
                if (distance[next.to] > current.cost + next.cost) {
                    distance[next.to] = current.cost + next.cost;
                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }

        // print result
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < distance.length; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
