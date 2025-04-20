public class Room {
    private int roomNumber;
    private Puzzle puzzle;
    private boolean isLocked;

    public Room(int roomNumber, Puzzle puzzle) {
        this.roomNumber = roomNumber;
        this.puzzle = puzzle;
        this.isLocked = true;
    }

    public boolean enterRoom() {
        System.out.println("Entering room " + roomNumber);
        return isLocked;
    }

    public void unlockRoom() {
        isLocked = false;
        System.out.println("Room " + roomNumber + " is now unlocked!");
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}