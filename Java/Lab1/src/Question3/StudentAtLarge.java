package Question3;

public class StudentAtLarge extends Student {
    private static final double TUITION_PER_SEMESTER = 2000.0;

    public StudentAtLarge(int studentID, String lastName) {
        super(studentID, lastName);
        setTuition();
    }

    @Override
    public void setTuition() {
        // Assume 2 semesters per year
        setAnnualTuition(TUITION_PER_SEMESTER * 2);
    }
}