import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ChessGUI extends JPanel {
    private final ChessBoard board;
    private int tileSize = 80; // Dimensiunea unei casuțe

    private int selectedX = -1, selectedY = -1; // Piesa selectată

    public ChessGUI(ChessBoard board) {
        this.board = board;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / tileSize;
                int y = e.getY() / tileSize;
                handleMouseClick(y, x);
            }
        });
    }

    private void handleMouseClick(int row, int col) {
        if (selectedX == -1 && selectedY == -1) { // Selectăm piesa
            if (board.getPiece(row, col) != null) {
                selectedX = row;
                selectedY = col;
                repaint();
            }
        } else { // Mutăm piesa
            String move = toChessNotation(selectedX, selectedY) + " " + toChessNotation(row, col);
            if (board.movePiece(move)) {
                selectedX = -1;
                selectedY = -1;
            }
            repaint();
        }
    }

    private String toChessNotation(int x, int y) {
        return (char) ('a' + y) + "" + (8 - x);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);

                // Desenăm piesele
                Piece piece = board.getPiece(row, col);
                if (piece != null) {
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Arial", Font.BOLD, 40));
                    g.drawString(piece.toString(), col * tileSize + 30, row * tileSize + 50);
                }
            }
        }
    }

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        JFrame frame = new JFrame("Șah în Java");
        ChessGUI chessGUI = new ChessGUI(board);

        frame.setSize(640, 660);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chessGUI);
        frame.setVisible(true);
    }
}
