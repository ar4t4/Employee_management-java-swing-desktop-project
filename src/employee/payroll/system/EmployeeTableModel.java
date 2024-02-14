import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {

    

   private List<Employee> employeeList;
    private final String[] columnNames = {"Name", "Age", "Department"};

    // Constructor with JSONArray parameter
    public EmployeeTableModel(JSONArray jsonArray) {
        employeeList = new ArrayList<>();

        // Populate the employeeList from the JSONArray
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String name = jsonObject.getString("name");
            int age = jsonObject.getInt("age");
            String department = jsonObject.getString("department");

            Employee employee = new Employee(name, age, department);
            employeeList.add(employee);
        }
    }

    @Override
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employeeList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return employee.getName();
            case 1:
                return employee.getAge();
            case 2:
                return employee.getDepartment();
            default:
                return null;
        }
    }
}
