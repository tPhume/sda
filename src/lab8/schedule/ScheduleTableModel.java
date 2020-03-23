package lab8.schedule;

import javax.swing.table.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ScheduleTableModel extends DefaultTableModel { //originator

    // DefaultTableModel uses:
    // - a list of column identifiers
    // - a list of lists of Object values
    // This fact is reflected by the Memento class.

    public ScheduleTableModel(Object[][] data, Object[] columnNames)
    {
	super(data, columnNames);
    }

    public TableMemento createMemento(Object[][] data, Object[] columnNames)
    {
	// COMPLETE.
        return new TableMemento(new ArrayList<>(Arrays.asList((String[])columnNames)),new ArrayList<>(Arrays.asList(data)));
    }

    public void setMemento(TableMemento memento, File file) throws IOException {
        // COMPLETE.
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject((Object)memento);
        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println("Snapshot was created at" + file.getAbsolutePath());
    }

    public TableMemento getMemento(File file) throws IOException, ClassNotFoundException {
        TableMemento tableMemento;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tableMemento = (TableMemento) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return tableMemento;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Value object.

    public class TableMemento implements Serializable {

        private ArrayList<String> columnIdentifiers;
        private ArrayList<Object[]> dataList;

        // Package visibility to only allow access for
        // the Originator.
        // We receive from the TableModel:
        // - a List of column identifiers
        // - a List of Lists of Object values (assumption: Strings)

        public TableMemento(ArrayList<String> columnIdentifiers, ArrayList<Object[]> dataList) {
            this.columnIdentifiers = columnIdentifiers;
            this.dataList = dataList;
        }


        // Package visibility to only allow access for
        // the Originator.


        public ArrayList<String> getColumnIdentifiers() {
            return columnIdentifiers;
        }

        public ArrayList<Object[]> getDataList() {
            return dataList;
        }

        @Override
        public String toString() {
            return "[ci=" + columnIdentifiers.toString() + "\n" +
                    "dl=" + dataList.toString() + "]";
        }
        // Other private (static) helper methods.
        // COMPLETE if necessary.
    }
}
