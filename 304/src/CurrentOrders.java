import Function.sqlFunctions;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CurrentOrders extends JFrame {
        private JScrollPane scrollpane;
        private JTable table;
        private JButton button;
        private String _ID;
    public CurrentOrders(String ID){
        //TODO: FRONT-END: can go into a specific order
        //TODO: BACK-END: provide sort function by date from back end, return new list
        //TODO: BACK-END: receives one order or orderID, return table with order detail
        //
            this.setVisible(true);
            this.setSize(600,400);

            this._ID = ID;
            button = new JButton("Search an Order");
            button.setBounds(400,200,150,50);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchOrder searchOrder = new SearchOrder("Search order", _ID);
                }
            });
            Vector<String> columnNames = new Vector<String>();

            columnNames.add("Order No");
            columnNames.add("Order Date");
            columnNames.add("Customer ID");
            columnNames.add("Product ID");
            columnNames.add("Product Quantity");
            columnNames.add("Product Name");
            Vector<Vector<String>> data = new Vector<Vector<String>>();
            ResultSet rs = sqlFunctions.showAllSupplierOrderByDate(_ID);
        try {
            while (rs.next()) {
                Vector<String> rowData = new Vector<String>();
             
                rowData.add(rs.getString(1));
                rowData.add(rs.getString(2));
                rowData.add(rs.getString(3));
                rowData.add(rs.getString(4));
                rowData.add(rs.getString(5));
                data.add(rowData);
            }
        } catch (SQLException e) {
        }
            table = new JTable(data, columnNames){

                @Override
                public Component prepareRenderer(TableCellRenderer r, int row, int column) {

                    Component c = super.prepareRenderer(r, row, column);
                    if(isCellSelected(row, column)) {
                        if(c.getBackground()==Color.PINK) {
                            c.setBackground(Color.white);
                        }
                        c.setBackground(Color.PINK);
//                        String s  = (String) table.getValueAt(table.getSelectedRow(),0);
//                        if(s!=null) {
//                            System.out.println(s);
//                            //OrderDetails o = new OrderDetails();
//                        }
                    }
                    return c;
                }
            };
            table.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    String s  = (String) table.getValueAt(table.getSelectedRow(),0);
                    if(s!=null) {
                        System.out.println(s);
                        OrderDetails o = new OrderDetails(s);
                        //OrderDetails o = new OrderDetails();
                    }
                }
            });
            JTableHeader header = table.getTableHeader();
            header.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("header clicked");
                }
            });
            scrollpane = new JScrollPane(table);
            scrollpane.setPreferredSize(new Dimension(600, 400));
            //this.add(button);
            this.add(scrollpane);



    }
}
