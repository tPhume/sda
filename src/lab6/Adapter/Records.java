/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.Adapter;

import java.util.ArrayList;

/**
 *
 * @author boonjv
 */
public class Records {

    private ArrayList employees; //Stores the employees

    public Records() {
        employees = new ArrayList();
    }

    public void insert(Employee employee) {
        //Code to insert employee
        this.employees.add(employee);
    }

    public void remove(long emp_num) {
        //Code to remove employee
        for(int i = 0; i < employees.size(); i++) {
            if (emp_num == ((Employee) employees.get(i)).getEmpNum()) {
                employees.remove(i);
            }
        }
    }

    public boolean isEmployee(long emp_num) {
        //Code to find employee
        for(int i = 0; i < employees.size(); i++) {
            if (emp_num == ((Employee) employees.get(i)).getEmpNum()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList getEmployees() {
        return employees;
    }
}
