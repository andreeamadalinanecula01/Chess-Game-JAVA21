class Rook extends Piece {
    public Rook(char color) {
        super(color, color == 'W' ? "♖" : "♜");
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        // Verificăm dacă mutarea este doar pe linie sau coloană
        if (startX != endX && startY != endY) {
            return false; // Turnul nu poate muta pe diagonală
        }
    
        // Determinăm direcția mutării
        int stepX = (endX > startX) ? 1 : (endX < startX) ? -1 : 0;
        int stepY = (endY > startY) ? 1 : (endY < startY) ? -1 : 0;
    
        // Verificăm fiecare poziție de pe traseu
        int x = startX + stepX;
        int y = startY + stepY;
        while (x != endX || y != endY) {
            if (board[x][y] != null) {
                return false; // Turnul este blocat de o altă piesă
            }
            x += stepX;
            y += stepY;
        }
    
        // Verificăm dacă destinația conține o piesă de aceeași culoare
        Piece destination = board[endX][endY];
        if (destination != null && destination.color == this.color) {
            return false;
        }
    
        return true; // Mutare validă
    }
    
}
