import java.util.*;

public class AppointmentService {

    private ArrayList<Appointment> appts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE = "appointments.txt";
    private int nextId = 1;

    public AppointmentService() {
        loadAppointments();
    }

    private void loadAppointments() {
        ArrayList<String> data = Utils.readAll(FILE);
        int maxId = 0;

        for (String line : data) {
            String[] a = line.split(",");
            int id = Integer.parseInt(a[0]);
            appts.add(new Appointment(id, Integer.parseInt(a[1]),
                    Integer.parseInt(a[2]), a[3]));
            if (id > maxId) maxId = id;
        }
        nextId = maxId + 1;
    }

    public void bookAppointment() {
        int id = nextId++;

        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();

        System.out.print("Enter Date (dd/mm/yyyy): ");
        String date = sc.next();

        Appointment a = new Appointment(id, pid, did, date);
        appts.add(a);

        Utils.writeToFile(FILE, id + "," + pid + "," + did + "," + date);

        System.out.println("Appointment booked with ID: " + id);
    }

    public void viewAppointments() {
        for (Appointment a : appts)
            System.out.println(a);
    }
}