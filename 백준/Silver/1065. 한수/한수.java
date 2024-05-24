import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // given
        int N = Integer.parseInt(br.readLine());

        // when
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        // then
        System.out.println(count);
        br.close();
    }

    public static boolean isHansu(int n) {
        // 1자리수이면 true
        if (n / 10 == 0) {
            return true;
        }

        int d = n / 10 % 10 - n % 10; // 공차
        while (n / 10 > 0) { // 2자리수 이상인 동안 반복
            if (n / 10 % 10 - n % 10 != d) {
                return false;
            }

            n /= 10;
        }

        return true;
    }
}
