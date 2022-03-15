public class RandomTestStub extends java.util.Random {
    private final int target;
    private boolean firstAnswerNext;

    RandomTestStub(int target) {
        if (target < 0 || target > 1000) {
            throw new IllegalArgumentException("target must be between 0 and 1000 inclusive");
        }
        this.target = target;
        firstAnswerNext = true;
    }

    @Override
    public int nextInt(int upperBound) {
        return target-1;
    }

}