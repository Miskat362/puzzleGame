import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Room> rooms;
    private Player player;
    private boolean isGameOver;
    private Scanner scanner;

    public Game() {
        this.rooms = new ArrayList<>();
        this.player = new Player(10); // Set initial moves
        this.isGameOver = false;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the Escape Room Game!");
        System.out.println("Solve puzzles to unlock rooms and escape!");

        // Initialize rooms and puzzles
        createRooms();
    }

    private void createRooms() {
        // Create different puzzles for each room
        Puzzle puzzle1 = new MathPuzzle("What is 5 + 3?", "8");
        Puzzle puzzle2 = new RiddlePuzzle("I speak without a mouth and hear without ears. What am I?", "echo");

        // Add rooms with puzzles to the game
        rooms.add(new Room(1, puzzle1));
        rooms.add(new Room(2, puzzle2));
    }

    public void play() {
        int currentRoomIndex = 0;

        while (!isGameOver && player.getMovesLeft() > 0) {
            Room currentRoom = rooms.get(currentRoomIndex);
            System.out.println("\nYou are in Room " + (currentRoomIndex + 1));

            // Display the puzzle and get the player's answer
            Puzzle puzzle = currentRoom.getPuzzle();
            puzzle.displayPuzzle();

            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (puzzle.checkSolution(answer)) {
                System.out.println("Correct! You unlocked the room.");
                currentRoom.unlockRoom();
                player.useMove();

                // Move to the next room if available
                currentRoomIndex++;
                if (currentRoomIndex >= rooms.size()) {
                    isGameOver = true;
                }
            } else {
                System.out.println("Incorrect answer. Try again or check your inventory for hints.");
                player.useMove();
            }

            // Check if player has any moves left
            if (player.getMovesLeft() <= 0) {
                System.out.println("You've run out of moves.");
                break;
            }
        }

        endGame();
    }

    private void endGame() {
        if (isGameOver) {
            System.out.println("Congratulations, you've escaped!");
        } else {
            System.out.println("Game Over. Better luck next time!");
        }
        scanner.close();
    }
}