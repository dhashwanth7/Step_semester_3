package string.class_problems;

public class Locker {

    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            System.out.println("Code changed successfully.");
            return true;
        } else {
            System.out.println("Incorrect current code. Change rejected.");
            return false;
        }
    }
}