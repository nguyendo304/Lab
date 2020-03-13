import java.util.Scanner;
 //adding this new comment
// a new comment made from GitHub online
public class ConnectFour {

    public static void main(String[] args) {
        int row = 0, col = 0;

        Scanner scn = new Scanner(System.in);
        System.out.print("What would you like the height of the board to be? ");
        row = scn.nextInt();
        System.out.print("What would you like the length  of the board to be? ");
        col = scn.nextInt();
        char[][] newBoard = new char[row][col];
        initializeBoard(newBoard);
        printBoard(newBoard);

        char chipType1 = 'x', chipType2 = 'o';
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");


       while(true){
                // Player 1 plays
                System.out.print("\nPlayer 1: Which column would you like to choose?");
                int colInsert = scn.nextInt();
                int rowInsert= insertChip(newBoard, colInsert, chipType1);
                printBoard(newBoard);       //reprint the new board game

                //check if player 1 has 4 chips or not, if checkIfWinner return true player 1 is winner
                if (checkIfWinner(newBoard,colInsert, rowInsert, chipType1)){
                    System.out.printf("Player 1 won the game!");
                    break;
                }
                //check if the board is full before any player win?
                if (isBoardFull(newBoard)) {
                    System.out.println("Draw. Nobody wins.");
                    break;
                }


                System.out.println("\nPlayer 2: Which column would you like to choose?");
                colInsert = scn.nextInt();
                rowInsert = insertChip(newBoard, colInsert, chipType2);
                printBoard(newBoard);       //reprint the new board game

                //check if player 2 has 4 chips or not, if checkIfWinner return true player 1 is winner
                if (checkIfWinner(newBoard,colInsert, rowInsert,chipType2 ))
                {
                    System.out.printf("Player 2 won the game!");
                    break;
                }

                 //check if the board is full before any player win?
                if (isBoardFull(newBoard)) {
                    System.out.println("Draw. Nobody wins.");
                    break;
                }


        }


    }



    //print the board the the bottom to above
    public static void printBoard(char[][] board) {
        for (int row = board.length-1; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //initialize the empty board with '-' char
    public static void initializeBoard(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';


            }
        }

    }

    //insert a chip base on the user select column
    public static int insertChip(char[][] array, int col, char chipType) {
        for (int row = 0; row < array.length; row++) {
            if (array[row][col] == '-') {
                array[row][col] = chipType;  //insert chiptype ='x' or 'o' when the slot is available
                return row;                  //after inserting chip, return the row holds the chip
            }
            continue;
        }
        return -1;


    }
    // checkIfWinner checks to find the winner of the game
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        int checkVertical = 0;
        int checkHorizontal = 0;
        // Check vertical
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == chipType) {
                checkVertical++;
                if (checkVertical == 4) {
                    return true;
                }
            } else {
                checkVertical = 0;
            }
        }
        // Check horizontal
        for (int j = 0; j < array[row].length; j++) {
            if (array[row][j] == chipType) {
                checkVertical++;
                if (checkVertical == 4) {
                    return true;
                }
            } else {
                checkVertical = 0;
            }
        }
        return false;
    }
    //check if a board is full before finding a winner
    private static boolean isBoardFull(char[][] board) {
        for(char chipindex: board[board.length-1]){
            if (chipindex == '-') {
                return false;
            }
        }
        return true;
    }
}
