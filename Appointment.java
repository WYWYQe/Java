import java.time.LocalTime;
import java.time.format.DateTimeParseException;

/**
 * Appointment class: Stores patient appointment information and associates with health professionals
 */
public class Appointment {
    // Patient information: name, phone number
    private String patientName;
    private String patientMobile;
    // Appointment information: time slot, associated doctor (base class reference, supports polymorphism)
    private LocalTime timeSlot;
    private HealthProfessional doctor;

    // Default constructor: Initializes default values
    public Appointment() {
        this.patientName = "Unknown Patient";
        this.patientMobile = "Unknown Phone";
        this.timeSlot = LocalTime.of(9, 0);  // Default 9:00
        this.doctor = new HealthProfessional();  // Default association with general health professional
    }

    // Full-parameter constructor: Initializes all information with data validation
    public Appointment(String patientName, String patientMobile, String timeSlotStr, HealthProfessional doctor) {
        this.patientName = patientName;
        // Validate phone number (11 digits)
        this.patientMobile = patientMobile.matches("\\d{11}") ? patientMobile : "Invalid phone (not 11 digits)";
        // Parse time slot (use 9:00 by default if format is wrong)
        try {
            this.timeSlot = LocalTime.parse(timeSlotStr);
        } catch (DateTimeParseException e) {
            this.timeSlot = LocalTime.of(9, 0);
            System.out.println("Invalid time slot format (require e.g., 08:00), defaulted to 09:00");
        }
        this.doctor = doctor;  // Accept subclass objects (polymorphism)
    }

    // Print appointment details: including patient info, time and doctor details (polymorphic call)
    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Appointment Time Slot: " + timeSlot.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("Associated Doctor Information:");
        doctor.printDetails();
        System.out.println("================\n");
    }

    // Get patient's mobile number (used for cancellation matching)
    public String getPatientMobile() {
        return patientMobile;
    }
}
