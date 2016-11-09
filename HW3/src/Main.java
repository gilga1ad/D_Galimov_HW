import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите имя аннотации: ");
            String name = sc.nextLine().trim();
            Test test = new Test(name);
            test.testAnnotations();
        }
    }

}
