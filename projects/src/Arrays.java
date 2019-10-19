import java.util.Scanner;

public class Arrays {
    private short[] array;
    Arrays(int length) {
        this.array = new short[length];
    }
    public  void enter() {
        System.out.println("Введите способ ввода: 1 - рандом, 2 - ручной ");
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        switch (x) {
            case 1:
                for (int i = 0; i < this.array.length; i++) {
                    array[i] = (short) (-255 + (Math.random() * 255));
                }
                break;
            case 2:
                for (int i = 0; i < this.array.length; i++) {

                    System.out.println("Введите  элемент массива: ");
                    Scanner scn = new Scanner(System.in);
                    short el = scn.nextShort();
                    array[i] = el;
                }
                break;
        }
    }
    public  void out()
    {
        for (int i:this.array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public   void reverse()
    {
        for(int i = this.array.length; i>0; i--)
        {
            System.out.print(this.array[i]+" ");
        }
        System.out.println();
    }
    public  void insertion() {
        for (int left = 0; left < this.array.length; left++) {
            // Вытаскиваем значение элемента
            short value = this.array[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < this.array[i]) {
                    this.array[i + 1] = this.array[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            this.array[i + 1] = value;
        }
    }
    public  void newarr() {
        System.out.println("Насколько элемнтов увеличить предыдущий массив: ");
        Scanner some = new Scanner(System.in);
        int a = some.nextInt();
        int n = this.array.length;
        short arrayNew[] = new short[n + a];
        for (int i = 0; i < n+a; i++) {
            if(i<n)
            {
                arrayNew[i] = this.array[i];
            }
            else {
                arrayNew[i] = (short) (-255 + (Math.random() * 255));
            }
            System.out.print(arrayNew[i]+" ");
        }
        System.out.println();
    }
}
