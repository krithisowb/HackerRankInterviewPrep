import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int result = 0;
        char[] c = s.toCharArray();
        
        char next = c[0]=='A'?'B':'A';
        int i = 0;
        

        while (i < c.length) {
            int j = i + 1;
             
            while (j < c.length) {
                
                if (c[j] != next) {
                    
                    result++;
                    j++;
                } else {
                    
                    i = j ;

                     next = c[i]=='A'?'B':'A';
                    break;
                }
            }
            if (j == c.length)
                break;

        }

        return result;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
