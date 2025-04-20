
public abstract class Puzzle {
    protected String description;
    protected String solution;

    public Puzzle(String description, String solution) {
        this.description = description;
        this.solution = solution;
    }

    public abstract boolean checkSolution(String answer);

    public void displayPuzzle() {
        System.out.println(description);
    }
}
class RiddlePuzzle extends Puzzle {
    public RiddlePuzzle(String description, String solution) {
        super(description, solution);
    }

    @Override
    public boolean checkSolution(String answer) {
        return answer.equals(solution);
    }
}
class MathPuzzle extends Puzzle {
    public MathPuzzle(String description, String solution) {
        super(description, solution);
    }

    @Override
    public boolean checkSolution(String answer) {
        return answer.equals(solution);
    }
}

// Removed RiddlePuzzle class to place it in its own file