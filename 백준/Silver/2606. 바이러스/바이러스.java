import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        parent = new int[V + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        // solution
        int count = 0;
        for (int i = 2; i < parent.length; i++) {
            if (find(i) == find(1)) {
                count++;
            }
        }

        // print result
        System.out.println(count);
        br.close();
    }

    public static void union(int x, int y) {
        int rootX = find(x); // x의 루트
        int rootY = find(y); // y의 루트

        // 서로 다른 집합에 속해있을 경우 한 루트를 다른 루트의 자식으로 만듦
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        // 재귀적으로 x의 부모 노드를 찾아 갱신하고 리턴함
        return parent[x] = find(parent[x]);
    }
}
