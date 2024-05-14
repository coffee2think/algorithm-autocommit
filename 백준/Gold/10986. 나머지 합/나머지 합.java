import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // given
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] psum = new int[N + 1];
        int[] remainders = new int[M];
        for (int i = 0; i < N; i++) {
            psum[i + 1] = (psum[i] + Integer.parseInt(st.nextToken())) % M;
            remainders[psum[i + 1]]++;
        }

        // when
        // 기본적으로 처음부터 끝까지 더했을 때 나머지가 0인 경우는 문제의 조건을 만족하므로 초기값으로 설정
        // 연속된 부분 구간이 a ~ b 라고 할 때,
        // 구간합은 psum[b + 1] - psum[a]이므로 두 구간의 나머지가 같아야 나머지가 0이 됨
        // 즉, 나머지가 같은 동치류에서 2개를 뽑는 경우의 수의 합으로 계산 가능
        // remainders[i] <= 10^6 이므로 long으로 선언
        long cnt = remainders[0];
        for (int i = 0; i < M; i++) {
            cnt += (long) remainders[i] * (remainders[i] - 1) / 2;
        }

        // then
        System.out.println(cnt);
        br.close();
    }
}
