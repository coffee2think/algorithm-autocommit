import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{y, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == x) {
                return cur[1];
            }
            if (cur[0] % 3 == 0) q.offer(new int[]{cur[0] / 3, cur[1] + 1});
            if (cur[0] % 2 == 0) q.offer(new int[]{cur[0] / 2, cur[1] + 1});
            if (cur[0] - n >= x) q.offer(new int[]{cur[0] - n, cur[1] + 1});
        }

        return -1;
    }
}