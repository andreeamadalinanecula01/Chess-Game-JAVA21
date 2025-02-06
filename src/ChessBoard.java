public class ChessBoard {
    private final Piece[][] board;

    public ChessBoard(){
        board = new Piece[8][8];
        setupBoard();
    }
    
    public Piece getPiece(int x, int y) {
        return board[x][y]; // Returnează piesa aflată la coordonatele (x, y)
    }
    
    private void setupBoard(){
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn('B');
            board[6][i] = new Pawn('W');
        }

        board[0][0] = board[0][7] = new Rook('B');
        board[7][0] = board[7][7] = new Rook('W');
        board[0][1] = board[0][6] = new Knight('B');
        board[7][1] = board[7][6] = new Knight('W');
        board[0][2] = board[0][5] = new Bishop('B');
        board[7][2] = board[7][5] = new Bishop('W');
        board[0][3] = new Queen('B');
        board[7][3] = new Queen('W');
        board[0][4] = new King('B');
        board[7][4] = new King('W');
    }

    public void displayBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print((board[i][j] != null ? board[i][j].toString() : ".") + " ");
            }
            System.out.println();
        }
    }


    public boolean movePiece(String move) {
        if (move.length() != 5 || move.charAt(2) != ' ') {
            return false; // Mutarea trebuie să fie de forma "e2 e4"
        }
    
        int startX = 8 - Character.getNumericValue(move.charAt(1)); // Convertim "2" în 6
        int startY = move.charAt(0) - 'a'; // Convertim "e" în 4
        int endX = 8 - Character.getNumericValue(move.charAt(4)); // Convertim "4" în 4
        int endY = move.charAt(3) - 'a'; // Convertim "e" în 4
    
        // Verificăm dacă mutarea este în limitele tablei
        if (startX < 0 || startX >= 8 || startY < 0 || startY >= 8 ||
            endX < 0 || endX >= 8 || endY < 0 || endY >= 8) {
            return false;
        }
    
        Piece piece = board[startX][startY];
        if (piece == null) {
            return false; // Nu există nicio piesă la poziția inițială
        }
    
        if (!piece.isValidMove(startX, startY, endX, endY, board)) {
            return false; // Mutarea nu este validă conform regulilor piesei
        }
    
        // Mutăm piesa pe noua poziție și ștergem poziția veche
        board[endX][endY] = piece;
        board[startX][startY] = null;
        
        return true;
    }
}
