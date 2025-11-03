import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = new String[3];
        int nextNumber = -1;
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = br.readLine();
            if (isNumeric(inputs[i])) {
                // 3의 배수, 5의 배수는 연속된 3개의 숫자 안에 최대 2번 나타나므로
                // 최소 하나는 숫자임
                nextNumber = Integer.parseInt(inputs[i]) + (3 - i);
                break;
            }
        }

        if (nextNumber % 3 == 0) sb.append("Fizz");
        if (nextNumber % 5 == 0) sb.append("Buzz");
        if (sb.length() == 0) sb.append(nextNumber);

        System.out.println(sb);
        br.close();
    }

    public static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
}
