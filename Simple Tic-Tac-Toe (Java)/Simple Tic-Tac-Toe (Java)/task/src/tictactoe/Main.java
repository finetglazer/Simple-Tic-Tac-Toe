package tictactoe;
import java.util.Scanner;

public class Main {

    public static void print(char[][] grid) {
        System.out.println("---------");
        for (int i = 1; i <= 3; i++) {
            System.out.print("| ");
            for (int j = 1; j <= 3; j++) {
                if (grid[i][j] == '_') {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static void init(char[][] grid) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                grid[i][j] = ' ';
            }
        }
        print(grid);
    }
    public static char cal(char[][] grid) {
        int cntx = 0;
        int cnto = 0;
        for (int i = 1; i <= 3 ; i++) {
            for (int j = 1; j <= 3; j++) {
                if (grid[i][j] == 'X') {
                    cntx++;
                } else if (grid[i][j] == 'O') {
                    cnto++;
                }
            }
        }
//        if (cntx != cnto && cntx + cnto != 9) {
//            System.out.println("Impossible");
//            return 'i';
//        }

        boolean checkx = true;
        boolean checko = true;
        if (grid[1][1] == grid[2][2] && grid[2][2] == grid[3][3] && grid[1][1] == 'X') {
           checkx = false;
        }
        if (grid[1][3] == grid[2][2] && grid[2][2] == grid[3][1] && grid[1][3] == 'X') {
            checkx = false;
        }
        if (grid[1][1] == grid[2][2] && grid[2][2] == grid[3][3] && grid[1][1] == 'O') {
            checko = false;
        }
        if (grid[1][3] == grid[2][2] && grid[2][2] == grid[3][1] && grid[1][3] == 'O') {
            checko = false;
        }
        for (int i = 1; i <= 3; i++) {
            if (grid[i][1] == grid[i][2] && grid[i][2] == grid[i][3] && grid[i][1] == 'X') {
                checkx = false;
            }
            if (grid[1][i] == grid[2][i] && grid[2][i] == grid[3][i] && grid[1][i] == 'X') {
                checkx = false;
            }
            if (grid[i][1] == grid[i][2] && grid[i][2] == grid[i][3] && grid[i][1] == 'O') {
                checko = false;
            }
            if (grid[1][i] == grid[2][i] && grid[2][i] == grid[3][i] && grid[1][i] == 'O') {
                checko = false;
            }
        }
        if (!checkx && !checko) {
//            System.out.println("Impossible");
            return 'i';
        } else if (checkx && checko) {
            if(cnto + cntx == 9) {
//                System.out.println("Draw");
                return 'd';
            } else {
//                System.out.println("Game not finished");
                return 'i';

            }
        } else if (!checkx) {
//            System.out.println("X wins");
            return 'x';
        } else {
            return 'o';
//            System.out.println("O wins");
        }
    }
    public static void mark(char[][] grid) {
        Scanner scanner = new Scanner(System.in);
        String s;
        int cnt = 1;
        while (cal(grid) == 'i') {
            boolean d = true;
            while (d) {
                s = scanner.nextLine();
                if (s.charAt(0) < '0' || s.charAt(0) > '9') {
                    System.out.println("You should enter numbers!");
                } else {
                    if (s.charAt(0) > '3' || s.charAt(0) == '0' ||
                            s.charAt(2) > '3' || s.charAt(2) == '0') {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else {
                        int y = s.charAt(0) - '0';
                        int x = s.charAt(2) - '0';
                        if (grid[y][x] == ' ') {
                            if(cnt % 2 == 1) {
                                grid[y][x] = 'X';
                            } else {
                                grid[y][x] = 'O';
                            }
                            d = false;
                            cnt++;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }

                    }
                }
            }
            print(grid);
        }
        if (cal(grid) == 'd') {
            System.out.println("Draw");
        } else if (cal(grid) == 'x') {
            System.out.println("X wins");
        } else {
            System.out.println("O wins");
        }
    }
    public static void main(String[] args) {
        // write your code here
        char[][] grid = new char[105][105];
        init(grid);
//        cal(grid);
        mark(grid);
    }
}
