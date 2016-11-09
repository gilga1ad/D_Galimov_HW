import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    final private String fileName;

    final private Map<String, String> dict;

    Dictionary(String fileName) {
        this.fileName = fileName;
        dict = new HashMap<>();

        this.fillDictionary();
    }

    private void fillDictionary() {
        Scanner sc = null;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(this.fileName)));

            String line;
            while (sc.hasNext()) {
                line = sc.nextLine();
                int equalSign = line.indexOf('=');

                this.dict.put(line.substring(0, equalSign),
                        line.substring(equalSign+1, line.length()));
            }
        } catch (FileNotFoundException e) {} finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public void learnDictionary() {
        int good = 0, bad = 0;

        try {
            for(Map.Entry<String, String> entry : this.dict.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                System.out.printf("%s: ", key);
                String response = getRespose();

                if (response.equals(value)) {
                    System.out.println("Верно");
                    good++;
                } else if (response.equals("exit")){
                    break;
                } else {
                    System.out.println("Не верно");
                    bad++;
                }
            }
        } finally {
            System.out.printf("Верно: %d, не верно: %d\n", good, bad);
            System.exit(0);
        }
    }

    private String getRespose() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim().toLowerCase();
    }

}
