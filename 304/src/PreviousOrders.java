import Function.sqlFunctions;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class PreviousOrders extends JFrame {
    private JScrollPane scrollpane;
    private JTable table;
    private JButton button;
    private String _ID;
    public PreviousOrders(String ID){

        this._ID = ID;

        //TODO: BACK-END: provide sort function (by date ) from back end, return new table
        this.setVisible(true);
        this.setSize(600,400);
        button = new JButton("Search an Order");
        button.setBounds(400,200,150,50);
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Customer ID");
        columnNames.add("Order Date");
        columnNames.add("Order Number");
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        ResultSet rs = sqlFunctions.showAllCustomerOrder(_ID);
        try {
            while (rs.next()) {
                Vector<String> rowData = new Vector<String>();
                rowData.add(rs.getString(1));
                rowData.add(rs.getString(2));
                rowData.add(rs.getString(3));
                data.add(rowData);
            }
        } catch (SQLException e) {
        }
        table = new JTable(data, columnNames);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                String s  = (String) table.getValueAt(table.getSelectedRow(),2);
                if(s!=null) {
                    System.out.println(s);
                    OrderDetails o = new OrderDetails(s);
                    //OrderDetails o = new OrderDetails();
                }
            }
        });

        scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(600, 400));
        //this.add(button);
        this.add(scrollpane);
        //TODO: BACK-END: receives an column, decide what is the ID of this product
        //TODO: BACK-END: receives Product ID, return table of product details with ID, name, price, track No., review star, brand, supplier Info,
    }
}
