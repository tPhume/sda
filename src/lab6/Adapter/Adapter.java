package lab6.Adapter;

public class Adapter {
    Database database;
    Records records;

    public Adapter(Database database) {
        this.database = database;
    }

    public Adapter(Records records) {
        this.records = records;
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

}
