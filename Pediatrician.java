/**
 * Pediatrician subclass (inherits from HealthProfessional)
 * Added unique attribute: age range for consultation (e.g., 0-12 years old)
 */
public class Pediatrician extends HealthProfessional {
    // Unique attribute: age range for consultation
    private String ageRange;

    // Default constructor: calls parent's default constructor, sets default age range to "0-12 years (children)"
    public Pediatrician() {
        super();
        this.ageRange = "0-12 years (children)";
    }

    // Full-parameter constructor: initializes parent class attributes and own age range
    public Pediatrician(String id, String name, String qualificationNo, String ageRange) {
        super(id, name, qualificationNo);
        this.ageRange = ageRange;
    }

    // Override print method: outputs pediatrician type and age range, reuses parent's general info printing
    @Override
    public void printDetails() {
        System.out.println("=== Health Professional Type: Pediatrician ===");
        super.printDetails();
        System.out.println("Consultation Age Range: " + ageRange);
        System.out.println();
    }

    // Get age range
    public String getAgeRange() {
        return ageRange;
    }
}