import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
int result = 0;
    Map<Integer, Integer> se = new HashMap<Integer, Integer>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (se.containsKey(ar[i])) {
        count = se.get(ar[i]);
        se.put(ar[i], count + 1);
      } else {
        se.put(ar[i], 1);
      }
    }
    for (Map.Entry<Integer, Integer> f : se.entrySet()) {
      Integer freq = f.getValue();
      if (freq % 2 != 0) {
        freq = freq - 1;
      }
      result += freq / 2;

    }
    return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
