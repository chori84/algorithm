import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int temp = 0;
        int index = 0;
        for(int i=1; ; i++) {
            if(temp + i >= X) {
                index = i;
                break;
            }
            temp += i;
        }

        int number = X - temp;
        if(index % 2 == 0) {
            System.out.println(number + "/" + (index - number + 1));
        } else {
            System.out.println((index - number + 1) + "/" + number);
        }
    }
}
