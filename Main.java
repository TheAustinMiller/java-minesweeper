import java.io.*;
import java.util.*;

public class Main{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;
        System.out.println("WELCOME TO EPIC MINESWEEPER");
        System.out.println("enter 'begin' to start");
        String a = input.nextLine();
        while (!(a.equals("begin"))){
            a = input.nextLine();
        }
        System.out.println();
        System.out.println();

        String[][] numboard = new String[5][5];
        // ADD NUMBERS
        int cnt = 1;
        for(int r = 0; r < numboard.length; r++){
            for(int c = 0; c < numboard[0].length; c++){
                String num = cnt+ "";
                if (cnt < 10){
                    num = "0" + num;
                }
                numboard[r][c] = num;
                cnt++;
            }
        }
        System.out.println("REFERENCE BOARD:");
        System.out.println();
        printBoard(numboard);

        String[][] board = new String[5][5];
        System.out.println();
        // ADD SPACES
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                board[r][c] = "X";
            }
        }
        System.out.println("GAME BOARD:");
        System.out.println();
        printBoard(board);

        boolean[][] boolboard = new boolean[5][5];
        HashSet<Integer> h = new HashSet<Integer>(); 
        fiveRandos(h);
        System.out.println();
        for(int r = 0; r < boolboard.length; r++){
            for(int c = 0; c < boolboard[0].length; c++){
                boolboard[r][c] = false;
            }
        }
        for (int lcv = 0; lcv < 5; lcv++){
            addBombs(h, boolboard, lcv);
        }
        System.out.println();
        System.out.println();

        String[][] bomboard = new String[5][5];
        int cnter = 1;
        for(int r = 0; r < bomboard.length; r++){
            for(int c = 0; c < bomboard[0].length; c++){
                if (boolboard[r][c] == true){
                    bomboard[r][c] = cnter + "";
                }
                else{
                    bomboard[r][c] = "";
                }
                cnter++;
            }
        }
        for(int lcv = 0; lcv < 20; lcv++){
            System.out.println("Where do you want to dig next?");
            int ans = input.nextInt();
            playSpot(boolboard, gameOver, ans, board);
            if (ans == 1){
                if(boolboard[0][0] == true){
                    gameOver = true;
                }
            }
            if (ans == 2){
                if(boolboard[0][1] == true){
                    gameOver = true;
                }
            }
            if (ans == 3){
                if(boolboard[0][2] == true){
                    gameOver = true;
                }
            }
            if (ans == 4){
                if(boolboard[0][3] == true){
                    gameOver = true;
                }
            }
            if (ans == 5){
                if(boolboard[0][4] == true){
                    gameOver = true;
                }
            }
            if (ans == 6){
                if(boolboard[1][0] == true){
                    gameOver = true;
                }
            }
            if (ans == 7){
                if(boolboard[1][1] == true){
                    gameOver = true;
                }
            }
            if (ans == 8){
                if(boolboard[1][2] == true){
                    gameOver = true;
                }
            }
            if (ans == 9){
                if(boolboard[1][3] == true){
                    gameOver = true;
                }
            }
            if (ans == 10){
                if(boolboard[1][4] == true){
                    gameOver = true;
                }
            }
            if (ans == 11){
                if(boolboard[2][0] == true){
                    gameOver = true;
                }
            }
            if (ans == 12){
                if(boolboard[2][1] == true){
                    gameOver = true;
                }
            }
            if (ans == 13){
                if(boolboard[2][2] == true){
                    gameOver = true;
                }
            }
            if (ans == 14){
                if(boolboard[2][3] == true){
                    gameOver = true;
                }
            }
            if (ans == 15){
                if(boolboard[2][4] == true){
                    gameOver = true;
                }
            }
            if (ans == 16){
                if(boolboard[3][0] == true){
                    gameOver = true;
                }
            }
            if (ans == 17){
                if(boolboard[3][1] == true){
                    gameOver = true;
                }
            }
            if (ans == 18){
                if(boolboard[3][2] == true){
                    gameOver = true;
                }
            }
            if (ans == 19){
                if(boolboard[3][3] == true){
                    gameOver = true;
                }
            }
            if (ans == 20){
                if(boolboard[3][4] == true){
                    gameOver = true;
                }
            }
            if (ans == 21){
                if(boolboard[4][0] == true){
                    gameOver = true;
                }
            }
            if (ans == 22){
                if(boolboard[4][1] == true){
                    gameOver = true;
                }
            }
            if (ans == 23){
                if(boolboard[4][2] == true){
                    gameOver = true;
                }
            }
            if (ans == 24){
                if(boolboard[4][3] == true){
                    gameOver = true;
                }
            }
            if (ans == 25){
                if(boolboard[4][4] == true){
                    gameOver = true;
                }
            }
            if(gameOver == true){
                System.out.println();
                System.out.println("BOMB LOCATIONS:");
                System.out.println();
                printBoard(bomboard);
                System.out.println();
                System.out.println("YOU LOSE");
                System.out.println("YOU LOSE");
                System.out.println("YOU LOSE");
                System.exit(0);
            }
            System.out.println();
            printBoard(numboard);
            System.out.println();
            printBoard(board);
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("YOU WIN!!!!!");
    }

    public static void playSpot(boolean[][] bool, boolean over, int answer, String[][] b){
        int cnt = 0;
        if (answer == 1){
            if(bool[0][1] == true){
                cnt++;
            }
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[1][0] == true){
                cnt++;
            }
            b[0][0] = cnt+ "";
        }
        if (answer == 2){
            if(bool[0][0] == true){
                cnt++;
            }
            if(bool[1][0] == true){
                cnt++;
            }
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[0][2] == true){
                cnt++;
            }
            if(bool[1][2] == true){
                cnt++;
            }
            b[0][1] = cnt+ "";
        }
        if (answer == 3){
            if(bool[0][1] == true){
                cnt++;
            }
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[1][2] == true){
                cnt++;
            }
            if(bool[0][3] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            b[0][2] = cnt+ "";
        }
        if (answer == 4){
            if(bool[0][2] == true){
                cnt++;
            }
            if(bool[1][2] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            if(bool[1][4] == true){
                cnt++;
            }
            if(bool[0][4] == true){
                cnt++;
            }
            b[0][3] = cnt+ "";
        }
        if (answer == 5){
            if(bool[0][3] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            if(bool[1][4] == true){
                cnt++;
            }
            b[0][4] = cnt+ "";
        }
        if (answer == 6){
            if(bool[0][0] == true){
                cnt++;
            }
            if(bool[1][0] == true){
                cnt++;
            }
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[2][0] == true){
                cnt++;
            }
            if(bool[2][1] == true){
                cnt++;
            }
            b[1][0] = cnt+ "";
        }
        if (answer == 7){
            if(bool[0][0] == true){
                cnt++;
            }
            if(bool[0][1] == true){
                cnt++;
            }
            if(bool[0][2] == true){
                cnt++;
            }
            if(bool[1][0] == true){
                cnt++;
            }
            if(bool[1][2] == true){
                cnt++;
            }
            if(bool[2][0] == true){
                cnt++;
            }
            if(bool[2][1] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            b[1][1] = cnt+ "";
        }
        if (answer == 8){
            if(bool[0][1] == true){
                cnt++;
            }
            if(bool[0][2] == true){
                cnt++;
            }
            if(bool[0][3] == true){
                cnt++;
            }
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            if(bool[2][1] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            b[1][2] = cnt+ "";
        }
        if (answer == 9){
            if(bool[0][2] == true){
                cnt++;
            }
            if(bool[0][3] == true){
                cnt++;
            }
            if(bool[0][4] == true){
                cnt++;
            }
            if(bool[1][2] == true){
                cnt++;
            }
            if(bool[1][4] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            if(bool[2][4] == true){
                cnt++;
            }
            b[1][3] = cnt+ "";
        }
        if (answer == 10){
            if(bool[0][3] == true){
                cnt++;
            }
            if(bool[0][4] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            if(bool[2][4] == true){
                cnt++;
            }
            b[1][4] = cnt+ "";
        }
        if (answer == 11){
            if(bool[1][0] == true){
                cnt++;
            }
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[2][1] == true){
                cnt++;
            }
            if(bool[3][0] == true){
                cnt++;
            }
            if(bool[3][1] == true){
                cnt++;
            }
            b[2][0] = cnt+ "";
        }
        if (answer == 12){
            if(bool[1][0] == true){
                cnt++;
            }
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[1][2] == true){
                cnt++;
            }
            if(bool[2][0] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[3][0] == true){
                cnt++;
            }
            if(bool[3][1] == true){
                cnt++;
            }
            b[2][1] = cnt+ "";
        }
        if (answer == 13){
            if(bool[1][1] == true){
                cnt++;
            }
            if(bool[1][2] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            if(bool[2][1] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[3][1] == true){
                cnt++;
            }
            b[2][2] = cnt+ "";
        }
        if (answer == 14){
            if(bool[1][2] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            if(bool[1][4] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            if(bool[2][4] == true){
                cnt++;
            }
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[3][4] == true){
                cnt++;
            }
            b[2][3] = cnt+ "";
        }
        if (answer == 15){
            if(bool[1][4] == true){
                cnt++;
            }
            if(bool[1][3] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[3][4] == true){
                cnt++;
            }
            b[2][4] = cnt+ "";
        }
        if (answer == 16){
            if(bool[2][0] == true){
                cnt++;
            }
            if(bool[2][1] == true){
                cnt++;
            }
            if(bool[3][1] == true){
                cnt++;
            }
            if(bool[4][0] == true){
                cnt++;
            }
            if(bool[4][1] == true){
                cnt++;
            }
            b[3][0] = cnt+ "";
        }
        if (answer == 17){
            if(bool[2][0] == true){
                cnt++;
            }
            if(bool[2][1] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            if(bool[3][0] == true){
                cnt++;
            }
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[4][0] == true){
                cnt++;
            }
            if(bool[4][1] == true){
                cnt++;
            }
            if(bool[4][2] == true){
                cnt++;
            }
            b[3][1] = cnt+ "";
        }
        if (answer == 18){
            if(bool[2][1] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            if(bool[3][1] == true){
                cnt++;
            }
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[4][3] == true){
                cnt++;
            }
            if(bool[4][1] == true){
                cnt++;
            }
            if(bool[4][2] == true){
                cnt++;
            }
            b[3][2] = cnt+ "";
        }
        if (answer == 19){
            if(bool[2][4] == true){
                cnt++;
            }
            if(bool[2][2] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[3][4] == true){
                cnt++;
            }
            if(bool[4][3] == true){
                cnt++;
            }
            if(bool[4][4] == true){
                cnt++;
            }
            if(bool[4][2] == true){
                cnt++;
            }
            b[3][3] = cnt+ "";
        }
        if (answer == 20){
            if(bool[2][4] == true){
                cnt++;
            }
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[2][3] == true){
                cnt++;
            }
            if(bool[4][3] == true){
                cnt++;
            }
            if(bool[4][4] == true){
                cnt++;
            }
            b[3][4] = cnt+ "";
        }
        if (answer == 21){
            if(bool[3][0] == true){
                cnt++;
            }
            if(bool[3][1] == true){
                cnt++;
            }
            if(bool[4][1] == true){
                cnt++;
            }
            b[4][0] = cnt+ "";
        }
        if (answer == 22){
            if(bool[3][0] == true){
                cnt++;
            }
            if(bool[3][1] == true){
                cnt++;
            }
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[4][0] == true){
                cnt++;
            }
            if(bool[4][2] == true){
                cnt++;
            }
            b[4][1] = cnt+ "";
        }
        if (answer == 23){
            if(bool[3][1] == true){
                cnt++;
            }
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[4][1] == true){
                cnt++;
            }
            if(bool[4][3] == true){
                cnt++;
            }
            b[4][2] = cnt+ "";
        }
        if (answer == 24){
            if(bool[3][2] == true){
                cnt++;
            }
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[3][4] == true){
                cnt++;
            }
            if(bool[4][2] == true){
                cnt++;
            }
            if(bool[4][4] == true){
                cnt++;
            }
            b[4][3] = cnt+ "";
        }
        if (answer == 25){
            if(bool[3][3] == true){
                cnt++;
            }
            if(bool[3][4] == true){
                cnt++;
            }
            if(bool[4][3] == true){
                cnt++;
            }
            b[4][4] = cnt+ "";
        }
    }

    public static void printBoard(String[][] b){
        for(int r = 0; r < b.length; r++){
            for(int c = 0; c < b[0].length; c++){
                System.out.print("   " +b[r][c]);
            }
            System.out.println();
        }
    }

    public static void fiveRandos(HashSet ha){
        while (ha.size() < 5){
            ha.add((int)(Math.random()*25+1));
        }
    }

    public static void addBombs(HashSet ha, boolean[][] bb, int cnt){
        if(ha.contains(1) == true){
            bb[0][0] = true;
        }
        if(ha.contains(2) == true){
            bb[0][1] = true;
        }
        if(ha.contains(3) == true){
            bb[0][2] = true;
        }
        if(ha.contains(4) == true){
            bb[0][3] = true;
        }
        if(ha.contains(5) == true){
            bb[0][4] = true;
        }
        if(ha.contains(6) == true){
            bb[1][0] = true;
        }
        if(ha.contains(7) == true){
            bb[1][1] = true;
        }
        if(ha.contains(8) == true){
            bb[1][2] = true;
        }
        if(ha.contains(9) == true){
            bb[1][3] = true;
        }
        if(ha.contains(10) == true){
            bb[1][4] = true;
        }
        if(ha.contains(11) == true){
            bb[2][0] = true;
        }
        if(ha.contains(12) == true){
            bb[2][1] = true;
        }
        if(ha.contains(13) == true){
            bb[2][2] = true;
        }
        if(ha.contains(14) == true){
            bb[2][3] = true;
        }
        if(ha.contains(15) == true){
            bb[2][4] = true;
        }
        if(ha.contains(16) == true){
            bb[3][0] = true;
        }
        if(ha.contains(17) == true){
            bb[3][1] = true;
        }
        if(ha.contains(18) == true){
            bb[3][2] = true;
        }
        if(ha.contains(19) == true){
            bb[3][3] = true;
        }
        if(ha.contains(20) == true){
            bb[3][4] = true;
        }
        if(ha.contains(21) == true){
            bb[4][0] = true;
        }
        if(ha.contains(22) == true){
            bb[4][1] = true;
        }
        if(ha.contains(23) == true){
            bb[4][2] = true;
        }
        if(ha.contains(24) == true){
            bb[4][3] = true;
        }
        if(ha.contains(25) == true){
            bb[4][4] = true;
        }
    }   
}
