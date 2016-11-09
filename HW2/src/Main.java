import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fileName = fileNameInput();

        Dictionary dictionary = new Dictionary(fileName);
        dictionary.learnDictionary();
    }

    private static String languageNameInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Пожалуйста, выберите язык (английский, немецкий, французский): ");
        String name = sc.nextLine().trim().toLowerCase();
        return name;
    }

    private static String fileNameInput() {
            String languageName = languageNameInput();

            String fileName;
            switch (languageName) {
                case "английский":
                    fileName = "english.properties";
                    return fileName;
                case "немецкий":
                    fileName = "german.properties";
                    return fileName;
                case "французский":
                    fileName = "french.properties";
                    return fileName;
                default:
                    System.out.println("Неправильно выбран язык. " +
                            "Попробуйте ещё раз.");
            }
            return fileNameInput();

    }

}
