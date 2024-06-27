import java.util.Scanner;

class ChessGame {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.initialize();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            board.display();
            System.out.println("Enter move (e.g., e2 e4): ");
            String move = scanner.nextLine();
            String[] parts = move.split(" ");
            if (parts.length == 2) {
                board.move(parts[0], parts[1]);
            } else {
                System.out.println("Invalid move format.");
            }
        }
    }
}

class ChessBoard {
    private final Piece[][] board = new Piece[8][8];

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Piece("P", false);
            board[6][i] = new Piece("P", true);
        }
        board[0][0] = new Piece("R", false); board[0][7] = new Piece("R", false);
        board[0][1] = new Piece("N", false); board[0][6] = new Piece("N", false);
        board[0][2] = new Piece("B", false); board[0][5] = new Piece("B", false);
        board[0][3] = new Piece("Q", false); board[0][4] = new Piece("K", false);
        
        board[7][0] = new Piece("R", true); board[7][7] = new Piece("R", true);
        board[7][1] = new Piece("N", true); board[7][6] = new Piece("N", true);
        board[7][2] = new Piece("B", true); board[7][5] = new Piece("B", true);
        board[7][3] = new Piece("Q", true); board[7][4] = new Piece("K", true);
    }

    public void display() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".");
                } else {
                    System.out.print(board[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void move(String from, String to) {
        int[] fromPos = parsePosition(from);
        int[] toPos = parsePosition(to);
        if (fromPos != null && toPos != null) {
            board[toPos[0]][toPos[1]] = board[fromPos[0]][fromPos[1]];
            board[fromPos[0]][fromPos[1]] = null;
        } else {
            System.out.println("Invalid move.");
        }
    }

    private int[] parsePosition(String pos) {
        if (pos.length() == 2) {
            int row = 8 - Character.getNumericValue(pos.charAt(1));
            int col = pos.charAt(0) - 'a';
            if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                return new int[]{row, col};
            }
        }
        return null;
    }
}



    @Override
    public String toString() {
        return isWhite ? type.toLowerCase() : type.toUpperCase();
    }
}
