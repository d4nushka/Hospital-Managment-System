import java.util.*;

public class BillingService {

    private ArrayList<Bill> bills = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE = "bills.txt";
    private int nextId = 1;

    public BillingService() {
        loadBills();
    }

    private void loadBills() {
        ArrayList<String> data = Utils.readAll(FILE);
        int maxId = 0;

        for (String line : data) {
            String[] b = line.split(",");
            int id = Integer.parseInt(b[0]);
            bills.add(new Bill(id,
                    Integer.parseInt(b[1]),
                    Double.parseDouble(b[2])));
            if (id > maxId) maxId = id;
        }

        nextId = maxId + 1;
    }

    public void generateBill() {
        int id = nextId++;

        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        Bill b = new Bill(id, pid, amt);
        bills.add(b);

        Utils.writeToFile(FILE, id + "," + pid + "," + amt);

        System.out.println("Bill Generated with ID: " + id);
    }

    public void viewBills() {
        for (Bill b : bills)
            System.out.println(b);
    }
}