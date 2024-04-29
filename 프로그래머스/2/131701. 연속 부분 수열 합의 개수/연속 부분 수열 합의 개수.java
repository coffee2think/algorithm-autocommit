import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        // 누적합 배열 초기화
        int[] psum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            psum[i + 1] = psum[i] + elements[i];
        }

        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                // 범위를 초과한다면 전체에서 포함되지 않는 수열의 합을 빼고,
                // 범위를 벗어나지 않는다면 포함되는 수열의 합을 계산하여 집합에 추가함
                if (start + len - 1 >= n) {
                    set.add(psum[n] - (psum[start] - psum[start - (n - len)]));
                } else {
                    set.add(psum[start + len] - psum[start]);
                }
            }
        }

        return set.size();
    }
}