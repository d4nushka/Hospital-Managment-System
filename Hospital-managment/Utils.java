import java.io.*;
import java.util.*;

public class Utils {

    public static void writeToFile(String filename, String data) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(data + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("File write error: " + e.getMessage());
        }
    }

    public static ArrayList<String> readAll(String filename) {
        ArrayList<String> list = new ArrayList<>();
        try {
            File file = new File(filename);
            if (!file.exists()) return list;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null)
                list.add(line);

            br.close();
        } catch (Exception e) {
            System.out.println("File read error: " + e.getMessage());
        }
        return list;
    }
}