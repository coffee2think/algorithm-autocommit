import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int M = 1234567891;
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long[] r = new long[L];
        long hash = str.charAt(0) - 'a' + 1;
        
        r[0] = 1;
        for (int i = 1; i < L; i++) {
            r[i] = (r[i - 1] * 31) % M;
            hash += ((str.charAt(i) - 'a' + 1) * r[i]) % M;
            hash %= M;
        }

        System.out.println(hash);
        br.close();
    }
}
