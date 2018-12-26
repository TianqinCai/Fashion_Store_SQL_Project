import Function.sqlFunctions;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrderDetails extends JFrame{
    private JScrollPane scrollpane;
    private JTable table;
    private String OrderNo;
    public OrderDetails(String No){
        OrderNo = No;
        this.setVisible(true);
        this.setSize(800,500);
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Total Price");
        columnNames.add("Order Status");
        columnNames.add("Order Number");
        ResultSet rs = sqlFunctions.showOneOrder(OrderNo);
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        try {
            while(rs.next()){
                Vector<String> rowData = new Vector<String>();
                rowData.add(rs.getString(1));
                rowData.add(rs.getString(2));
                rowData.add(rs.getString(3));
                data.add(rowData);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        table = new JTable(data, columnNames);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String s  = (String) table.getValueAt(table.getSelectedRow(),2);
                if(s!=null) {
                    System.out.println(s);
                    ProductInOrder o = new ProductInOrder(s);
                    //OrderDetails o = new OrderDetails();
                }
            }
        });
        scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(600, 400));
        this.add(scrollpane);

    }
}
