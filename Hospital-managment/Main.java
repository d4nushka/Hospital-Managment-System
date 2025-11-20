import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static PatientService patientService = new PatientService();
    private static DoctorService doctorService = new DoctorService();
    private static AppointmentService appointmentService = new AppointmentService();
    private static MedicalRecordService medicalService = new MedicalRecordService();
    private static BillingService billingService = new BillingService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Medical Records");
            System.out.println("5. Billing");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1: patientMenu(); break;
                case 2: doctorMenu(); break;
                case 3: appointmentMenu(); break;
                case 4: medicalMenu(); break;
                case 5: billingMenu(); break;
                case 6: System.out.println("Goodbye!"); System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void patientMenu() {
        System.out.println("\n--- PATIENT MANAGEMENT ---");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Search Patient");
        System.out.print("Enter choice: ");
        int p = sc.nextInt();
        switch (p) {
            case 1: patientService.addPatient(); break;
            case 2: patientService.viewPatients(); break;
            case 3: patientService.searchPatient(); break;
        }
    }

    private static void doctorMenu() {
        System.out.println("\n--- DOCTOR MANAGEMENT ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.print("Enter choice: ");
        int d = sc.nextInt();

        switch (d) {
            case 1: doctorService.addDoctor(); break;
            case 2: doctorService.viewDoctors(); break;
        }
    }

    private static void appointmentMenu() {
        System.out.println("\n--- APPOINTMENT MANAGEMENT ---");
        System.out.println("1. Book Appointment");
        System.out.println("2. View All Appointments");
        System.out.print("Enter choice: ");
        int a = sc.nextInt();

        switch (a) {
            case 1: appointmentService.bookAppointment(); break;
            case 2: appointmentService.viewAppointments(); break;
        }
    }

    private static void medicalMenu() {
        System.out.println("\n--- MEDICAL RECORD MANAGEMENT ---");
        System.out.println("1. Add Medical Record");
        System.out.println("2. View All Medical Records");
        System.out.print("Enter choice: ");
        int a = sc.nextInt();

        switch (a) {
            case 1: medicalService.addRecord(); break;
            case 2: medicalService.viewRecords(); break;
        }
    }

    private static void billingMenu() {
        System.out.println("\n--- BILLING ---");
        System.out.println("1. Generate Bill");
        System.out.println("2. View All Bills");
        System.out.print("Enter choice: ");
        int b = sc.nextInt();

        switch (b) {
            case 1: billingService.generateBill(); break;
            case 2: billingService.viewBills(); break;
        }
    }
}
