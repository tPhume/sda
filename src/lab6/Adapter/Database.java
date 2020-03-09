/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.Adapter;

/**
 *
 * @author boonjv
 */
import java.util.Vector;

/**
 *
 * @author boonjv
 */
public class Database {

    private Vector employees; //Stores the employees

    public Database() {
        employees = new Vector();
    }

    public void addEmployee(Employee employee) {
        //Code to add employee
        this.employees.add(employee);
    }

    public void deleteEmployee(long emp_num) {
        //Code to delete employee
        for(int i = 0; i < employees.size(); i++){
            if(emp_num == ((Employee) employees.get(i)).getEmpNum()){
                employees.remove(i);
            }
        }
    }

    public Vector getEmployees() {
        return employees;
    }
}
