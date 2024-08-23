
import java.util.Scanner;

class Game {
    Scanner sc = new Scanner(System.in);
    // инициализирую доску для игры
    char[][] board = new char[3][3];
    boolean isWinner = false;
    boolean isDraw;

    // метод для отображения доски
    public void drawDesk() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + (board[i][j] == '\u0000' ? ' ' : board[i][j]) + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    // метод для проверки победы
    public void check_win() {
        // проверка строк
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'X') ||
                    (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'O')) {
                isWinner = true;
            }
        }
        // проверка столбцов
        for (int i = 0; i < 3; i++) {
            if ((board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'X') ||
                    (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'O')) {
                isWinner = true;
            }
        }
        // проверка диагоналей
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'X') ||
                (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'O')) {
            isWinner = true;
        }
        if ((board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'X') ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'O')) {
            isWinner = true;
        }
    }

    // метод для проверки ничьи
    public void check_draw() {
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X' || board[i][j] == 'O') {
                    counter++;
                }
            }
        }
        isDraw = counter == 9;
    }


    // метод для основного цикла игры
    public void play() {
        boolean isFirstPlayer = true;

        while (true) {
            drawDesk();
            System.out.println("Ход делает игрок № " + (isFirstPlayer ? "1 (X)" : "2 (O)") + ": ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] != '\u0000') {
                System.out.println("Это поле занято! Попробуйте другое");
                continue;
            }

            board[row][col] = (isFirstPlayer ? 'X' : 'O');

            check_win();
            check_draw();
            if (isDraw) {
                System.out.println("Ничья !");
                break;
            }

            if (isWinner) {
                if (isFirstPlayer) {
                    System.out.println("Победил игрок № 1 !");
                    drawDesk();
                    break;
                } else {
                    System.out.println("Победил игрок № 2 !");
                    drawDesk();
                    break;
                }
            }
            isFirstPlayer = !isFirstPlayer;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

