
import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    Scanner input = new Scanner(System.in);
    private int row;
    private int col;
    private String[][] miniMap;
    private String[][] board;
    private int sayac = 0;
    private int rowNo;
    private int colNo;
    private boolean win;
    private boolean event;

    MineSweeper(int row, int col) {
        this.row = row;
        this.col = col;
        this.miniMap = new String[row][col];
        this.board = new String[row][col];
        empty(this.board);
        empty(this.miniMap);
    }

    public void randomNumber() {
        Random rdn = new Random();
        this.rowNo = rdn.nextInt(this.row);

        Random rdn2 = new Random();
        this.colNo = rdn2.nextInt(this.col);
    }

    public String[][] empty(String[][] dizi) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                dizi[i][j] = "-";
            }
        }
        return dizi;
    }

    public boolean isFind(String[][] arr, String value) {
        if (arr[this.rowNo][colNo] == "*") {
            return false;
        }
        return true;
    }

    public void run() {
        for (int j = 0; j < this.row; j++) {
            for (int k = 0; k < this.col; k++) {
                if (sayac < (this.col * this.row / 4)) {
                    randomNumber();
                    sayac++;
                    if (isFind(this.board, "*")) {
                        this.miniMap[rowNo][colNo] = "*";
                        this.board[rowNo][colNo] = "*";
                    } else sayac--;
                }
            }
        }
        printMineMap();
        empty(this.board);
        printBoard();
        koordinatGir();

    }

    public void printMineMap() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print(" " + this.miniMap[i][j]);
            }
            System.out.println("");
        }
        System.out.println("===========================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");

    }

    public void printBoard() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print(" " + this.board[i][j]);
            }
            System.out.println(" ");
        }
    }

    private int durumSayac = 0;

    public void koordinatGir() {
        this.event = true;
        while (this.event) {
            int sayac = 0;
            this.durumSayac++;
            boolean kontrol = true;
            int row = 0;
            int col = 0;
            while (kontrol) {
                System.out.print("Satır Giriniz : ");
                row = input.nextInt();
                System.out.print("Sütun Giriniz : ");
                col = input.nextInt();
                if ((row < 0 || row > (this.row - 1)) || (col < 0 || col > (this.col - 1))) {
                    System.out.println("Hatalı sayı girdiniz lütfen tekrar giriniz ");
                    kontrol = true;
                } else {
                    kontrol = false;
                }
            }
            System.out.println("===========================");
            if (this.miniMap[row][col].equals("*")) {
                System.out.println("Kaybettin ! ");
                printMineMap();
                this.event = false;
                break;
            }
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((row + i >= 0 && (row + i) <= (this.row - 1)) && (col + j >= 0 && (col + j) <= (this.col - 1))) {
                        if (this.miniMap[row + i][col + j].equals("*")) {
                            sayac++;
                            this.board[row][col] = String.valueOf(sayac);
                        }
                        if (sayac == 0) {
                            this.board[row][col] = "0";
                        }
                    }
                }
            }
            if (this.durumSayac == this.row * this.col - (this.col * this.row / 4)) {
                this.win = true;
            }
            if (this.win == true) {
                this.event = false;
                System.out.println("KAZANDINIZ !!!");
            } else event = true;
            printBoard();

        }
    }

}
