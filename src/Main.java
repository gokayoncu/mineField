import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen satır sayısını giriniz : ");
        int row = input.nextInt();

        System.out.print("Lütfen sütun sayısını giriniz : ");
        int column = input.nextInt();

        MineSweeper mayin = new MineSweeper(row,column);
        mayin.run();



    }
}