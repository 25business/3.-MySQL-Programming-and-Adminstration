package com.example;

import com.example.personel.Employee;
import com.example.personel.queries.EmployeeDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        try {
            /*
            Employee e = EmployeeDAO.get(11);
            System.out.println(e);
             */
            /*
            HashMap<String, Object> employee_data = new HashMap();
            employee_data.put("first_name", "Philip");
            employee_data.put("last_name", "Horst");
            employee_data.put("email", "philip@lmg.com");
            employee_data.put("start_date", LocalDate.now());
            employee_data.put("contract_type", "Temporary Employment");
            employee_data.put("departments_id", 2);
             */
            /*
            Employee new_employee = new Employee(employee_data);
            int inserted_id = EmployeeDAO.save(new_employee);
            System.out.println("New employee saved at: " + inserted_id);
            */
            /*
            int final_result = EmployeeDAO.save_all_info(employee_data);
            System.out.println(final_result);
             */

            /*
            Employee employee = EmployeeDAO.get(11);
            employee.setFirst_name("Gustav");
            int rows_affected = EmployeeDAO.update(employee);
            System.out.println("Updated? "  + rows_affected);
             */

            /*
            Employee employee = EmployeeDAO.get(21);
            int rows_affected = EmployeeDAO.delete(employee);
            System.out.println("Deleted? " + rows_affected);
             */
            /*ArrayList<Employee> employees = EmployeeDAO.all();
            for(Employee e : employees) {
                System.out.println(e);
            }*/

            /*
            HashMap<String, Object> employee_data = new HashMap();
            employee_data.put("first_name", "Tony");
            employee_data.put("last_name", "Marksman");
            employee_data.put("email", "tony@intel.com");
            Employee new_employee = new Employee(employee_data);
            int employee_id = EmployeeDAO.prepared_save(new_employee);
            System.out.println(employee_id);
            */
            /*
            Employee employee = EmployeeDAO.get(11);
            employee.setFirst_name("Alfons");
            int result = EmployeeDAO.prepared_update(employee);
            System.out.println(result);
             */
            /*
            Employee employee = EmployeeDAO.get(32);
            int result = EmployeeDAO.prepared_delete(employee);
            System.out.println(result);
             */

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
