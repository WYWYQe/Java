/**
 * Base class for all health professionals, containing common attributes and behaviors.
 */
public class HealthProfessional {
    // Required instance variables: ID (digits only) and name
    protected String id;   // Use String to store ID to avoid issues with long numbers; validate digits only in practice
    protected String name;
    // General attribute: Professional qualification certificate number
    protected String qualificationNo;

    // 1. Default constructor
    public HealthProfessional() {
        this.id = "000000";
        this.name = "Unknown Name";
        this.qualificationNo = "Unknown Certificate No.";
    }

    // 2. Constructor to initialize all instance variables
    public HealthProfessional(String id, String name, String qualificationNo) {
        // Simple validation: Ensure ID contains only digits
        if (id.matches("\\d+")) {
            this.id = id;
        } else {
            this.id = "Invalid ID (non-digit)";
        }
        this.name = name;
        this.qualificationNo = qualificationNo;
    }

    // 3. Method to print all instance variables (general print for base class)
    public void printDetails() {
        System.out.println("Health Professional ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Professional Qualification Certificate No.: " + qualificationNo);
    }

    // Getter methods for encapsulation (used in Appointment class to retrieve doctor information)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
