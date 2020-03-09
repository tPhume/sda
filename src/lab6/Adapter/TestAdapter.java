package lab6.Adapter;

public class TestAdapter {
    public static void main(String[] args) {
        Database db = new Database();
        db.addEmployee(new Employee("Somjai","A",001,1000));
        db.addEmployee(new Employee("Somsri","B",002,2000));
        db.addEmployee(new Employee("Sompong","C",003,3000));

        Records records = new Records();
        records.insert(new Employee("Veerachai","D",101,10000));
        records.insert(new Employee("Veerasu","E",102,20000));
        records.insert(new Employee("Veera","F",103,30000));

        Adapter adapter = new Adapter(db);
        System.out.println(adapter.toString());
    }
}
