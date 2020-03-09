package lab6.Adapter;

import java.util.ArrayList;

public class Adapter extends Records {
    Database database;

    public Adapter(Database database) {
        this.database = database;
    }

    @Override
    public void insert(Employee employee) {
        database.addEmployee(employee);
    }

    @Override
    public void remove(long emp_num) {
        database.deleteEmployee(emp_num);
    }

    @Override
    public boolean isEmployee(long emp_num) {
        for(int i = 0; i < database.getEmployees().size(); i++) {
            if (emp_num == ((Employee) database.getEmployees().get(i)).getEmpNum()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList getEmployees() {
        return new ArrayList<>(database.getEmployees());
    }

    @Override
    public String toString() {
        String message =  "Adapter{" + "database=\n" ;
        for (Object employee: database.getEmployees()){
            employee = (Employee)employee;
            message += ((Employee) employee).getEmpNum() + " Name: " + ((Employee) employee).getName() + " " + ((Employee) employee).getSurname()
                    +" Salary: " + ((Employee) employee).getSalary() + "\n";
        }
        return message + "}";
    }
}
