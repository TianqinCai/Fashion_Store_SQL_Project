//import Function.sqlFunctions;

import Function.sqlFunctions;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;

public class AllProduct extends JFrame {
    private JTable table;
    private JScrollPane scrollpane;
    private JFrame frame;
    private int flag = 0;
    private JPanel MainPanel;
    public AllProduct(){

        setVisible(true);
        setSize(1150,550);
        final Vector<String> ColNames = new Vector<String>();
        frame = this;
        MainPanel = new JPanel();

        ColNames.add("Product ID");
        ColNames.add("TotalPurchase Number");
        ColNames.add("Product Name");
        ColNames.add("Product Type");
        ColNames.add("Unit Price");
        ColNames.add("Brand");
        ColNames.add("Review Star");
        ColNames.add("Supplier Name");
        ColNames.add("Supplier Contact");

        Vector<Vector<String>> data = new Vector<Vector<String>>();
        ResultSet rs = sqlFunctions.showAllProduct();
        try {
            while (rs.next()) {
                Vector<String> rowData = new Vector<String>();
                rowData.add(rs.getString(1));
                rowData.add(rs.getString(2));
                rowData.add(rs.getString(3));
                rowData.add(rs.getString(4));
                rowData.add(rs.getString(5));
                rowData.add(rs.getString(6));
                rowData.add(rs.getString(7));

                ResultSet ts = sqlFunctions.showsupplierinfofromproduct(rs.getString(1));
                while(ts.next()) {
                    rowData.add(ts.getString(1));
                    rowData.add(ts.getString(2));
                }
                data.add(rowData);
            }
        } catch (SQLException e) {
        }

        table = new JTable(data,ColNames);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, tcr);

        JButton hightrated = new JButton("  View Most High-rated Product Type  ");
        hightrated.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs1 = sqlFunctions.mostpopulartype();
                try{
                    while(rs1.next()) {
                        String P = rs1.getString(1);
                        String N = rs1.getString(2);
                        JOptionPane.showMessageDialog(frame,"Most highRated Type is " + P
                                + "\nAverage rate star of this type is " + N);

                    }
                } catch (SQLException e2){
                    System.out.println("error in view pop type");
                }
            }
        });

        JButton pop = new JButton("  View Most purchased Product Brand  ");
        pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet rs2 = sqlFunctions.mostpurchasedtype();
                try{
                    while(rs2.next()) {
                        String P1 = rs2.getString(1);
                        String N1 = rs2.getString(2);
                        BigDecimal bd = new BigDecimal(N1);
                        DecimalFormat df = new DecimalFormat();
                        String type = "0.0";
                        df.applyPattern(type);
                        Double dou;
                        dou = Double.parseDouble(bd.toPlainString());
                        JOptionPane.showMessageDialog(frame,"Most purchased Product Brand is " + P1
                                + "\nTotal purchase number of this brand is " + N1 + "   ");

                    }
                } catch (SQLException e2){
                }
            }
        });

        JButton sort = new JButton("  Sort By Price  ");
        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == 0) {
                    ResultSet nrs = sqlFunctions.showAllProductByPrice(true);
                    try {
                        data.clear();
                        while (nrs.next()) {
                            Vector<String> rowData1 = new Vector<String>();
                            rowData1.add(nrs.getString(1));
                            rowData1.add(nrs.getString(2));
                            rowData1.add(nrs.getString(3));
                            rowData1.add(nrs.getString(4));
                            rowData1.add(nrs.getString(5));
                            rowData1.add(nrs.getString(6));
                            rowData1.add(nrs.getString(7));
                            //rowData1.add(nrs.getString(8));
                            ResultSet ts = sqlFunctions.showsupplierinfofromproduct(nrs.getString(1));
                            while(ts.next()) {
                                rowData1.add(ts.getString(1));
                                rowData1.add(ts.getString(2));
                            }
                            data.add(rowData1);
                        }
                    } catch (SQLException e1) {
                        System.out.println("error in sorting");
                    }

                    MainPanel.remove(scrollpane);
                    JTable table1 = new JTable(data, ColNames);
                    table1.setDefaultRenderer(Object.class, tcr);

                    scrollpane = new JScrollPane(table1);
                    scrollpane.setPreferredSize(new Dimension(1100, 400));
                    MainPanel.add(scrollpane, BorderLayout.CENTER);
                    MainPanel.updateUI();
                    flag = 1;
                } else {
                    ResultSet nrs = sqlFunctions.showAllProductByPrice(false);
                    try {
                        data.clear();
                        while (nrs.next()) {
                            Vector<String> rowData1 = new Vector<String>();
                            rowData1.add(nrs.getString(1));
                            rowData1.add(nrs.getString(2));
                            rowData1.add(nrs.getString(3));
                            rowData1.add(nrs.getString(4));
                            rowData1.add(nrs.getString(5));
                            rowData1.add(nrs.getString(6));
                            rowData1.add(nrs.getString(7));
                            //rowData1.add(nrs.getString(8));
                            ResultSet ts = sqlFunctions.showsupplierinfofromproduct(nrs.getString(1));
                            while(ts.next()) {
                                rowData1.add(ts.getString(1));
                                rowData1.add(ts.getString(2));
                            }
                            data.add(rowData1);

                        }
                    } catch (SQLException e1) {
                    }

                    MainPanel.remove(scrollpane);

                    JTable table1 = new JTable(data, ColNames);
                    table1.setDefaultRenderer(Object.class, tcr);
                    scrollpane = new JScrollPane(table1);
                    scrollpane.setPreferredSize(new Dimension(1100, 400));
//                    scrollpane.updateUI();
//                    scrollpane.validate();
                    MainPanel.add(scrollpane,BorderLayout.CENTER);
                    MainPanel.updateUI();
                    flag = 0;
                }
            }
        });
        JPanel panel = new JPanel();
        panel.add(sort);
        panel.add(hightrated);
        panel.add(pop);

        scrollpane = new JScrollPane(table);
        scrollpane.setPreferredSize(new Dimension(1100, 400));
        MainPanel.add(panel, BorderLayout.PAGE_START);
        MainPanel.add(scrollpane, BorderLayout.CENTER);
        this.add(MainPanel);
    }
}
