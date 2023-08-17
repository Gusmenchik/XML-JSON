import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Employee> employeeList = XMLParser.parseXML("data.xml");

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(employeeList);

            try (FileWriter writer = new FileWriter("data2.json")) {
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

