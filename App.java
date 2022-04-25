package za.ac.up.cs.cos221;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Hello world!
 *
 */

public class App 
{
    JFrame f;
    App()
    {
        //1.    creating frame
        f = new JFrame();

        //2.    creating panels
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        /*     4.1     **/
        //3.    creating tabs
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(50,50,900,500);
        tp.add("Staff",p1);
        tp.add("Films",p2);
        tp.add("Inventory",p3);
        tp.add("Clients",p4);

        /*     4.2     **/
        //4.    create Staff table
        String [] S_ColumnNames = {"First Name",
                "Last Name",
                "Address",
                "Address2",
                "District",
                "City",
                "Postal Code",
                "Store",
                "Active"};

        Object [][] data = {
                {"Lisa", "Fellingham", "5 lonehill", "lonhill", "Gauteng", "Joburg", "0234", "Blockbuster 3", new Boolean(false)},
                {"Yane","Van der Westhuizen", "3 Pretoria","Pretoria","Gauteng","Joburg","5678","Blockbuster 5", new Boolean(true)}
        };

        JTable Staff = new JTable(data, S_ColumnNames);
        p1.add(Staff.getTableHeader(), "width 100%");
        p1.add(Staff,"width 100%");


        //5.    set Frame
        Staff.setFillsViewportHeight(true);
        f.add(tp);
        f.setSize(1000,700);
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        /*      4.3     **/
        //5.    create filter textbox
            //5.1 add textbox
        JTextField textBox = new JTextField("FILTER BY:\t",50);
        p1.add(textBox);

            //5.2 use to sort by ______
        TableRowSorter sorter = new TableRowSorter();
        class MyTableModel extends AbstractTableModel
        {
            public int getRowCount(){return 0;}
            public int getColumnCount() {return 0;}
            public String getColumnName(int column) {return super.getColumnName(column);}
            public Class getColumnClass(int columnIndex){return null;}
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                if(rowIndex==3) return true;
                else return false;
            }
            public Object getValueAt(int rowIndex, int columnIndex){return null;}               //fix
            public void setValueAt(Object aValue, int rowIndex, int columnIndex){}              //fix
            @Override
            public void addTableModelListener(TableModelListener l) {}

            @Override
            public void removeTableModelListener(TableModelListener l) {}
        }


    }

    public static void main(String[] args)
    {
        new App();
    }
}
