package lab8.schedule;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class ScheduleGUI extends JFrame {  // Caretaker

//    private TableMemento memento;
    private ScheduleTableModel tableModel;
    private JFileChooser fileChooser;
    ScheduleTableModel.TableMemento snapshotMemento;

    private Object[][] data = {
            {"08.00-09.00", "----", "Math", "", "", ""},
            {"09.00-10.00", "", "Math", "", "", ""},
            {"10.00-11.00", "", "", "SE 2", "", "Math"},
            {"11.00-12.00", "", "", "SE 2", "", "Math"},
            {"12.00-13.00", "----", "----", "----", "----", "----"},
            {"13.00-14.00", "SE 2", "OpSys", "", "", ""},
            {"14.00-15.00", "SE 2", "OpSys", "", "Project", ""},
            {"15.00-16.00", "", "OpSys", "", "Project", ""},
            {"16.00-17.00", "", "OpSys", "", "Project", ""},
            {"17.00-18.00", "", "", "", "Project", ""}
        };

    private String[] columnNames = {
	"Time",
	"Monday",
	"Tuesday",
	"Wednesday",
	"Thursday",
	"Friday"
    };

    public ScheduleGUI() {
	super("Schedule GUI with Memento");
	initComponents();
	pack();
    }

    protected void initComponents() {
        addWindowListener (new WindowAdapter () {
            public void windowClosing (WindowEvent evt) {
                exitForm (evt);
            }
        });

        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        // Add "Save As.." menu item here; register corresponding
        JMenuItem saveMenuItem = new JMenuItem("Save as");
        JMenuItem loadMenuItem = new JMenuItem("Load");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // listener (optional);
        saveMenuItem.addActionListener(this::saveMenuItemActionPerformed);
        loadMenuItem.addActionListener(this::loadMenuItemActionPerformed);
        exitMenuItem.addActionListener(this::exitMenuItemActionPerformed);
        // COMPLETE.

        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);
        fileMenu.add(exitMenuItem);
        mb.add(fileMenu);
        setJMenuBar(mb);

        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save As");

        tableModel = new ScheduleTableModel(data, columnNames);
        final JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton snapshotButton = new JButton("Snapshot");
        snapshotButton.setPreferredSize(new Dimension(125, 27));
        snapshotButton.addActionListener(this::snapshotButtonActionPerformed);

        JButton revertButton = new JButton("Revert");
        revertButton.setPreferredSize(new Dimension(125, 27));
        revertButton.addActionListener(this::revertButtonActionPerformed);

        JPanel panel = new JPanel();
        panel.add(snapshotButton);
        panel.add(revertButton);
        getContentPane().add(panel, BorderLayout.SOUTH);

        // Take a memento for the initial state of the table.
        // COMPLETE.
    }

    private void revertButtonActionPerformed(ActionEvent actionEvent) {
        int nRow = tableModel.getRowCount(), nCol = tableModel.getColumnCount();
        Object[] column = snapshotMemento.getColumnIdentifiers().toArray();
        Object[][] tableData = new Object[nRow][];
        ArrayList<Object[]> dataArr = snapshotMemento.getDataList();
        for(int row = 0; row < nRow; row++){
            tableData[row] = dataArr.get(row);
        }
        tableModel.setDataVector(tableData,column);
    }

    private void snapshotButtonActionPerformed(ActionEvent actionEvent) {
        int nRow = tableModel.getRowCount() , nCol = tableModel.getColumnCount();
        Object[][] snapshotData = new Object[nRow][nCol];
        for(int row = 0; row < nRow; row++){
            for(int col = 0; col < nCol ; col++){
                System.out.printf("Row: %d Col: %d message: %s\n",row,col, tableModel.getValueAt(row,col).toString());
                snapshotData[row][col] = tableModel.getValueAt(row,col);
            }
        }
        snapshotMemento = tableModel.createMemento(snapshotData,columnNames);
    }

    private void loadMenuItemActionPerformed(ActionEvent actionEvent) {
        int nRow = tableModel.getRowCount(), nCol = tableModel.getColumnCount();
        int userSelect = fileChooser.showOpenDialog(this);
        if(userSelect == JFileChooser.APPROVE_OPTION){
            File openLocation = fileChooser.getSelectedFile();
            try {
                ScheduleTableModel.TableMemento memento = tableModel.getMemento(openLocation);

                Object[] column = memento.getColumnIdentifiers().toArray();
                Object[][] tableData = new Object[nRow][];
                ArrayList<Object[]> dataArr = memento.getDataList();
                for(int row = 0; row < nRow; row++){
                    tableData[row] = dataArr.get(row);
                }
                tableModel.setDataVector(tableData,column);
                System.out.println("Set table: " + Arrays.deepToString(tableData));
            } catch(IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }

    private void saveMenuItemActionPerformed(ActionEvent actionEvent) {
        int nRow = tableModel.getRowCount() , nCol = tableModel.getColumnCount();
        Object[][] saveData = new Object[nRow][nCol];
        for(int row = 0; row < nRow; row++){
            for(int col = 0; col < nCol ; col++){
                System.out.printf("Row: %d Col: %d message: %s\n",row,col, tableModel.getValueAt(row,col).toString());
                saveData[row][col] = tableModel.getValueAt(row,col);
            }
        }

        ScheduleTableModel.TableMemento memento = tableModel.createMemento(saveData,columnNames);
        try {
            int userSelect = fileChooser.showSaveDialog(this);
            if(userSelect == JFileChooser.APPROVE_OPTION){
                File saveLocation = fileChooser.getSelectedFile();
                tableModel.setMemento(memento,saveLocation);
                JOptionPane.showMessageDialog(this,"Saved Successfully!!!");
            }
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this,e);
        }
    }

    protected void exitMenuItemActionPerformed (ActionEvent evt) {
        System.exit(0);
    }

    protected void exitForm(WindowEvent e) {
        System.exit (0);
    }

    public static void main (String[] args) {
        new ScheduleGUI().setVisible (true);
    } // end of main ()

}
