/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.payroll.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Asus
 */
public class json {
    
    
     
        public static String getJSONFromURL(String strUrl) {
        String jsonText = "";

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = 
                            new BufferedReader(new InputStreamReader(is));
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }

            is.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return jsonText;
    }
         public static void main(String[] args) {
        //String strJson = getJSONFromFile("C:/Users/BoostMyTool/Desktop/example.json");
        String strJson = getJSONFromURL(
            "https://api.myjson.online/v1/records/cb89fcbf-8750-4664-aaec-34fe8298105c"
        );
   // System.out.println(strJson);
   
}
}
