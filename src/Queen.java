class Queen extends Piece {
    public Queen(char color) {
        super(color, color == 'W' ? "♕" : "♛");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        if (startX == endX || startY == endY) { // Mutare ca turnul (orizontal sau vertical)
            int stepX = (endX > startX) ? 1 : (endX < startX) ? -1 : 0;
            int stepY = (endY > startY) ? 1 : (endY < startY) ? -1 : 0;
    
            int x = startX + stepX;
            int y = startY + stepY;
            while (x != endX || y != endY) {
                if (board[x][y] != null) return false; // Mutarea este blocată
                x += stepX;
                y += stepY;
            }
        } else if (Math.abs(startX - endX) == Math.abs(startY - endY)) { // Mutare ca nebunul (diagonală)
            int stepX = (endX > startX) ? 1 : -1;
            int stepY = (endY > startY) ? 1 : -1;
    
            int x = startX + stepX;
            int y = startY + stepY;
            while (x != endX && y != endY) {
                if (board[x][y] != null) return false; // Mutarea este blocată
                x += stepX;
                y += stepY;
            }
        } else {
            return false; // Mutare invalidă (nu este pe linie, coloană sau diagonală)
        }
    
        // Verificăm dacă la destinație este o piesă de aceeași culoare
        Piece destination = board[endX][endY];
        if (destination != null && destination.color == this.color) {
            return false;
        }
    
        return true;
    }
    
}
