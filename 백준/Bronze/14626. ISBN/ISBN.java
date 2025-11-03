import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ISBN = br.readLine();
        int sum = 0;
        int missingIndex = -1;
        for (int i = 0; i < 13; i++) {
            if (ISBN.charAt(i) == '*') {
                missingIndex = i;
                continue;
            }

            sum += (ISBN.charAt(i) - '0') * (i % 2 == 0 ? 1 : 3);
        }
        sum %= 10;

        int inverse = (missingIndex % 2 == 0) ? 1 : 7; // mod 10일 때, 1의 역원 = 1, 3의 역원 = 7
        System.out.println((10 - sum) * inverse % 10);
        br.close();
    }
}
