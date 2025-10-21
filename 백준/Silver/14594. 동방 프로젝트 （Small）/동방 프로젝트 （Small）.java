import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // given
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<int[]> ranges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ranges.add(new int[]{x, y});
        }

        if (M == 0) {
            System.out.println(N);
            return;
        }

        // when
        ranges.sort(((r1, r2) -> {
            if (r1[0] != r2[0]) {
                return r1[0] - r2[0];
            }
            return r1[1] - r2[1];
        }));

        List<int[]> mergedRanges = new ArrayList<>();
        int currentStart = ranges.get(0)[0];
        int currentEnd = ranges.get(0)[1];

        for (int i = 1; i < ranges.size(); i++) {
            int nextStart = ranges.get(i)[0];
            int nextEnd = ranges.get(i)[1];

            if (nextStart <= currentEnd) {
                currentEnd = Math.max(nextEnd, currentEnd);
            } else {
                mergedRanges.add(new int[]{currentStart, currentEnd});
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }
        mergedRanges.add(new int[]{currentStart, currentEnd});

        // then
        int count = N;
        for (int[] range : mergedRanges) {
            count -= range[1] - range[0];
        }
        System.out.println(count);
        br.close();
    }
}
