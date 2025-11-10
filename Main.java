import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main class: Health Service Appointment System
 * Contains main method to demonstrate core system functionalities
 */
public class Main {
    // Static collection: stores all appointment records
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // Part 3: Demonstration of class and object usage
        System.out.println("[Part 3: Demonstration of Class & Object Usage]");
        System.out.println("----------------------------------------------");

        // Create 3 General Practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner("100001", "Dr. Zhang", "GP2023001", "Family Medicine, Hypertension Management");
        GeneralPractitioner gp2 = new GeneralPractitioner("100002", "Dr. Li", "GP2023002", "Diabetes Management, Common Childhood Illnesses");
        GeneralPractitioner gp3 = new GeneralPractitioner("100003", "Dr. Wang", "GP2023003", "Geriatrics, Chronic Disease Follow-up");

        // Create 2 Pediatrician objects
        Pediatrician pedia1 = new Pediatrician("200001", "Dr. Liu", "PD2023001", "0-3 Year Old Infant Care");
        Pediatrician pedia2 = new Pediatrician("200002", "Dr. Chen", "PD2023002", "4-12 Year Old Childhood Diseases");

        // Print details of all doctors (demonstrates polymorphism)
        System.out.println("[General Practitioner List]");
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();

        System.out.println("[Pediatrician List]");
        pedia1.printDetails();
        pedia2.printDetails();

        System.out.println("------------------------------");

        // Part 5: Demonstration of appointment collection functionality
        System.out.println("\n[Part 5: Demonstration of Appointment Collection Functions]");
        System.out.println("----------------------------------------------");

        // Book 2 general practitioners
        createAppointment("Xiao Ming", "13800138001", "09:30", gp1);
        createAppointment("Xiao Hong", "13900139002", "14:00", gp2);

        // Book 2 pediatricians (demonstrates polymorphism)
        createAppointment("Xiao Gang", "13700137003", "10:15", pedia1);
        createAppointment("Xiao Li", "13600136004", "15:30", pedia2);

        // Print all appointments
        System.out.println("[Step 1: Print All Appointments]");
        printExistingAppointments();

        // Cancel appointment with specified mobile number
        System.out.println("[Step 2: Cancel Appointment with Mobile 13700137003]");
        cancelBooking("13700137003");

        // Print appointments after cancellation
        System.out.println("[Step 3: Print Appointments After Cancellation]");
        printExistingAppointments();

        System.out.println("------------------------------");
    }

    // Create appointment and add to collection (with information validation)
    public static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // Validate required information is not empty
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Creation failed: Patient name cannot be empty!");
            return;
        }
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("Creation failed: Patient mobile number cannot be empty!");
            return;
        }
        if (timeSlot == null || timeSlot.trim().isEmpty()) {
            System.out.println("Creation failed: Appointment time slot cannot be empty!");
            return;
        }
        if (doctor == null) {
            System.out.println("Creation failed: No doctor selected!");
            return;
        }

        // Create appointment and add to collection
        Appointment newAppt = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppt);
        System.out.println("Appointment created successfully! Patient: " + patientName + ", Doctor: " + doctor.getName());
    }

    // Print all existing appointments
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointment records currently!");
            return;
        }

        System.out.println("There are " + appointmentList.size() + " appointment records:");
        for (Appointment appt : appointmentList) {
            appt.printAppointmentDetails();
        }
    }

    // Cancel appointment by mobile number
    public static void cancelBooking(String targetMobile) {
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean isCanceled = false;

        while (iterator.hasNext()) {
            Appointment appt = iterator.next();
            if (appt.getPatientMobile().equals(targetMobile)) {
                iterator.remove();
                isCanceled = true;
                System.out.println("Appointment canceled successfully! Record with mobile " + targetMobile + " deleted.");
                break;
            }
        }

        if (!isCanceled) {
            System.out.println("Cancellation failed: No appointment found with mobile " + targetMobile + ".");
        }
    }
}