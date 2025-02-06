abstract class Piece {
    protected char color;
    protected String name;

    public Piece(char color, String name) {
        this.color = color;
        this.name = name;
    }

    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board);
    
    @Override
    public String toString() {
        return name; // Returnează simbolul piesei (♔, ♕, ♘, etc.)
    }
    
}
