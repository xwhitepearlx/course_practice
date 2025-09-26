package Question3;

public class GraduateStudent extends Student {
    private static final double TUITION_PER_SEMESTER = 6000.0;

    public GraduateStudent(int studentID, String lastName) {
        super(studentID, lastName);
        setTuition();
    }

    @Override
    public void setTuition() {
        // Assume 2 semesters per year
        setAnnualTuition(TUITION_PER_SEMESTER * 2);
    }
}