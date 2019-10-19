import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Введите количество элементов массива: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays A = new Arrays(n);
        A.enter();
        A.out();
        System.out.println("Хотите увеличить размер массива ?: Да: 1, Нет: 2 ");
        Scanner st = new Scanner(System.in);
        int str = st.nextInt();
        switch (str) {
            case 1:
                A.newarr();
                break;
            case 2:
                System.out.println("Ну, как хотите!");
                break;

        }
        System.out.println("Отсортированный массив: ");
        A.insertion();
        A.out();
    }
}


