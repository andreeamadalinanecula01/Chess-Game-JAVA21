class Bishop extends Piece {
    public Bishop(char color) {
        super(color, color == 'W' ? "♗" : "♝");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        return Math.abs(startX - endX) == Math.abs(startY - endY);
    }
}
