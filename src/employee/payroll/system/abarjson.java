//import employee.payroll.system.EmployeeTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
        

public class abarjson extends JFrame {

    private JTable employeeTable;

    public abarjson() {
        setTitle("Employee Data");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JButton fetchButton = new JButton("Fetch Employee Data");
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchAndDisplayEmployeeData();
            }
        });
 fetchAndDisplayEmployeeData();
        employeeTable = new JTable();

        // Layout
        setLayout(new BorderLayout());
        //add(fetchButton, BorderLayout.NORTH);
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);
    }

    private void fetchAndDisplayEmployeeData() {
        // Replace this URL with your actual JSON endpoint
        String jsonUrl = "https://api.myjson.online/v1/records/4f34ad1f-eaed-4042-a523-7158026e4b73";

        try {
            // Fetch data from the JSON link
            String jsonData = fetchDataFromUrl(jsonUrl);

            // Parse JSON data
           // JSONArray jsonArray;
            // Parse the JSON string
        JSONObject mainJsonObject = new JSONObject(jsonData);

        // Get the "data" array from the main JSON object
        JSONArray dataArray = mainJsonObject.getJSONArray("data");

        // Create a new JSON object to store the "data" array
        //JSONObject newDataObject = new JSONObject();
       // newDataObject.put("data", dataArray);

           System.out.println(dataArray);
          JSONArray jsonArray = new JSONArray(dataArray);

        // Create a table model
        EmployeeTableModel tableModel = new EmployeeTableModel(jsonArray);
        this.dispose();
         // tableModel.setValueAt(10, WIDTH, ICONIFIED);
         
            // Set the table model
            employeeTable.setModel(tableModel);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String fetchDataFromUrl(String url) throws IOException {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            // Create a URL object
            URL apiUrl = new URL(url);

            // Open connection
            connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();

        } finally {
            // Close connections
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new abarjson().setVisible(true);
            }
        });
    }
}
