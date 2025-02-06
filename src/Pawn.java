class Pawn extends Piece {
    public Pawn(char color) {
        super(color, color == 'W' ? "♙" : "♟");
    }

    @Override
public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
    int direction = (color == 'W') ? -1 : 1;

    // Mutare standard: o casuță înainte
    if (startY == endY && endX - startX == direction && board[endX][endY] == null) {
        return true;
    }

    // Mutare de două casuțe înainte din poziția inițială
    int startRow = (color == 'W') ? 6 : 1;
    if (startX == startRow && startY == endY && endX - startX == 2 * direction &&
        board[startX + direction][startY] == null && board[endX][endY] == null) {
        return true;
    }

    // Capturare pe diagonală
    if (Math.abs(startY - endY) == 1 && endX - startX == direction && board[endX][endY] != null && board[endX][endY].color != this.color) {
        return true;
    }

    return false;
   }

}