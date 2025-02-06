import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard(); // Creăm tabla de șah
    
        try (Scanner scanner = new Scanner(System.in)) { 
            while (true) { // Jocul continuă până la ieșirea manuală
                board.displayBoard(); // Afișăm tabla actualizată
                System.out.println("Introdu mutarea (ex: e2 e4) sau 'exit' pentru a ieși:");
    
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Jocul s-a încheiat.");
                    break;
                }
    
                // Încercăm să mutăm piesa
                if (!board.movePiece(input)) {
                    System.out.println("Mutare invalidă! Încearcă din nou.");
                }
            }
        } 
    }
    
}
