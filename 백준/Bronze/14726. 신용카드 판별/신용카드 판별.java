import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // given
        int T = Integer.parseInt(br.readLine());

        // when
        for (int t = 0; t < T; t++) {
            String cardNumber = br.readLine();
            int sum = 0;
            for (int digit = 1; digit <= cardNumber.length(); digit++) {
                int index = cardNumber.length() - digit;
                int value = (cardNumber.charAt(index) - '0') * (digit % 2 == 0 ? 2 : 1);
                if (value >= 10) {
                    value = value / 10 + value % 10;
                }
                sum += value;
            }

            sb.append(sum % 10 == 0 ? "T" : "F").append("\n");
        }

        // then
        System.out.println(sb);
        br.close();
    }
}
