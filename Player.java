import java.util.ArrayList;

public class Player {
    private ArrayList<String> inventory;
    private int movesLeft;

    public Player(int moves) {
        this.inventory = new ArrayList<>();
        this.movesLeft = moves;
    }

    public void collectItem(String item) {
        inventory.add(item);
        System.out.println("Collected: " + item);
    }

    public boolean hasItem(String item) {
        return inventory.contains(item);
    }

    public void useMove() {
        movesLeft--;
    }

    public int getMovesLeft() {
        return movesLeft;
    }
}