/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employee.payroll.system;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author Asus
 */
import javax.swing.table.DefaultTableModel;
public class asifjson extends javax.swing.JFrame {

    /**
     * Creates new form asifjson
     */
    public asifjson() {
        initComponents();
          Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        size.height/2 - getHeight()/2);
        fetchAndDisplayEmployeeData();
        
        
    }
     private void fetchAndDisplayEmployeeData() {
        
        String jsonUrl = "https://api.myjson.online/v1/records/4f34ad1f-eaed-4042-a523-7158026e4b73";

        try {
         
            String jsonData = fetchDataFromUrl(jsonUrl);

           
           // JSONArray jsonArray;
            // Parse the JSON string
        JSONObject mainJsonObject = new JSONObject(jsonData);

        // Get the "data" array from the main JSON object
        JSONArray dataArray = mainJsonObject.getJSONArray("data");

    
        //JSONObject newDataObject = new JSONObject();
       // newDataObject.put("data", dataArray);

          // System.out.println(dataArray);
          JSONArray jsonArray = new JSONArray(dataArray);

        
       // EmployeeTableModel x = new EmployeeTableModel(jsonArray);
        //String d[]={"asif","hello"};
       
            // Set the table model
            //employeeTable.setModel(tableModel);
            DefaultTableModel l=(DefaultTableModel)data.getModel();
             for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
                String  age = jsonObject.getString("age");
            String department = jsonObject.getString("department");
         String  salary = jsonObject.getString("salary");
              String d[]={name,department,age,salary};
              l.addRow(d);
        }

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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "DEPARTMENT", "AGE", "SALARY","EMAIL"
            }
        ));
        jScrollPane1.setViewportView(data);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(asifjson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(asifjson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(asifjson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(asifjson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new asifjson().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable data;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
