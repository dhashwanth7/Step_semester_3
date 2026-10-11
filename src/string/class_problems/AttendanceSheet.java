package string.class_problems;

public class AttendanceSheet {

    private final String[] students;
    private int presentCount;

    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid student name.");
            return;
        }

        if (isPresent(name)) {
            System.out.println(name + " is already marked present.");
            return;
        }

        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        } else {
            System.out.println("Attendance sheet is full.");
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }

        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}