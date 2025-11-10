/**
 * General Practitioner subclass (inherited from HealthProfessional)
 * Added unique attributes for general practitioners: areas of expertise (such as family medicine, chronic disease management)
 */
public class GeneralPractitioner extends HealthProfessional {
    // Subclass-specific instance variable: Areas of expertise of a general practitioner
    private String specialty;

    // Default constructor
    public GeneralPractitioner() {
        super();  // Inherit the default property initialization of the base class
        this.specialty = "General Basic Diagnosis and Treatment";
    }

    // Constructor method that initializes all variables
    public GeneralPractitioner(String id, String name, String qualificationNo, String specialty) {
        super(id, name, qualificationNo);  // Call the base class parameterized constructor to initialize common attributes.
        this.specialty = specialty;
    }

    // Rewrite the print method
    @Override
    public void printDetails() {
        System.out.println("=== Type of Health Professional: General Practitioner ===");
        super.printDetails();  // Call the base class method
        System.out.println("Areas of expertise:" + specialty);
        System.out.println();
    }

    // Getter method (the Appointment class may need to get the area of expertise)
    public String getSpecialty() {
        return specialty;
    }
}
