import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SearchOrder extends JFrame {
    private JButton button;
    private JLabel OrderNoLabel, DateLabel, DateToLabel, ProductNameLabel, ProductTypeLabel;
    private JTextField OrderNoText, DateFromText, DateToText, ProductNameText, ProductTypeText;
    private JSpinner spinner;
    private JTable table;
    private JFrame frame;
    private String _ID;
    public SearchOrder(String title, String ID) {
        super(title);
        setSize(520,580);
        setVisible(true);
        setLayout(null);

        _ID = ID;
        OrderNoLabel = new JLabel("Order No. ");
        OrderNoLabel.setBounds(50,50,150,50);
        OrderNoText = new JTextField();
        OrderNoText.setBounds(200, 50,230,50);
        DateLabel = new JLabel("Order Date ");
        DateLabel.setBounds(50,125,150,50);
        DateFromText = new JTextField();
        DateFromText.setBounds(200,125,95,50);
        DateToText = new JTextField();
        DateToText.setBounds(330,125,100,50);
        DateToLabel = new JLabel("To");
        DateToLabel.setBounds(305,125,20,50);
        ProductNameLabel = new JLabel("Product Name:");
        ProductNameLabel.setBounds(50,200,150,50);
        ProductNameText = new JTextField();
        ProductNameText.setBounds(200, 200,230,50);
        ProductTypeLabel = new JLabel("Product Type: ");
        ProductTypeLabel.setBounds(50,275,150,50);
        ProductTypeText = new JTextField();
        ProductTypeText.setBounds(200,275,230,50);
        button = new JButton("Search");
        button.setBounds(150,380,150,50);
        frame = this;

        add(button);
        add(OrderNoLabel);
        add(OrderNoText);
        add(DateLabel);
        add(DateFromText);
        add(DateToText);
        add(DateToLabel);
        add(ProductNameLabel);
        add(ProductNameText);
        add(ProductTypeLabel);
        add(ProductTypeText);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(OrderNoText.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame,"Order Number can not be empty");
                }

                else if(true) {

                    JFrame result = new JFrame("Search Results");
                    result.setSize(800,350);
                    result.setVisible(true);

                    //TODO: BACK-EDN: A search function: receive any of the parameters of (OrderDate, OrderID, ProductName and type, any other parameter may be added by Ziwei) and returns a table
                    //TODO: you need to first check if these parameters are null, then search with the filter of exist parameters
                    Vector<String> columnNames = new Vector<String>();
                    columnNames.add("Product ID");
                    columnNames.add("Name");
                    columnNames.add("Price");
                    columnNames.add("Brand");
                    columnNames.add("Track No");
                    columnNames.add("Category");
                    columnNames.add("Review Star");
                    columnNames.add("Supplier Info");
                    Vector<Vector<String>> data = new Vector<Vector<String>>();
                    table = new JTable(data, columnNames);
                    JScrollPane scrollpane = new JScrollPane(table);
                    scrollpane.setPreferredSize(new Dimension(650, 350));
                    result.add(scrollpane);

                    //TODO: FRONT-END: can go into a specific order?
                    //maybe not
                }
            }
        });


    }
}
