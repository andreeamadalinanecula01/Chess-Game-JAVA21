// Clasa King reprezintă regele în șah
class King extends Piece {
    // Constructorul inițializează regele
    public King(char color) {
        super(color, color == 'W' ? "♔" : "♚"); // Setează simbolul pentru alb/negru
    }

    // Metodă care verifică dacă mutarea regelui este validă
    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        // Regele poate muta o singură casuță în orice direcție
        return Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
    }
}