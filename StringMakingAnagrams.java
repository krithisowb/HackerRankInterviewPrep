import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringMakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int result = 0;
        char c[] = a.toCharArray();
        char d[] = b.toCharArray();
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        Map<Character, Integer> n = new HashMap<Character, Integer>();
        for (int i = 0; i < c.length; i++) {
            Integer size = m.get(c[i]);
            if (size != null)
                m.put(c[i], size + 1);
            else
                m.put(c[i], 1);
        }
        for (int i = 0; i < d.length; i++) {
            Integer size = n.get(d[i]);
            if (size != null)
                n.put(d[i], size + 1);
            else
                n.put(d[i], 1);
        }
        for (Entry<Character, Integer> e : m.entrySet()) {
            Integer f = e.getValue();
            Integer g = n.get(e.getKey());
            if (g == null)
                result += f;
            else if (!g.equals(f))
                result += Math.abs((g-f));
            n.remove(e.getKey());
        }
        if (!n.isEmpty())
        for (Entry<Character, Integer> e : n.entrySet()) {
            Integer f = e.getValue();
            result += f;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new
         FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);

         bufferedWriter.write(String.valueOf(res));
         bufferedWriter.newLine();

         bufferedWriter.close();

         scanner.close();
    }
}
