import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    public static List<Employee> parseXML(String fileName) throws Exception {
        List<Employee> employeeList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(fileName));

        NodeList employeeNodes = document.getDocumentElement().getElementsByTagName("employee");

        for (int i = 0; i < employeeNodes.getLength(); i++) {
            Node employeeNode = employeeNodes.item(i);
            if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element employeeElement = (Element) employeeNode;
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(employeeElement.getElementsByTagName("id").item(0).getTextContent()));
                employee.setFirstName(employeeElement.getElementsByTagName("firstName").item(0).getTextContent());
                employee.setLastName(employeeElement.getElementsByTagName("lastName").item(0).getTextContent());
                employee.setCountry(employeeElement.getElementsByTagName("country").item(0).getTextContent());
                employee.setAge(Integer.parseInt(employeeElement.getElementsByTagName("age").item(0).getTextContent()));
                employeeList.add(employee);
            }
        }

        return employeeList;
    }
}

