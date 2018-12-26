import javax.swing.*;
import java.util.Vector;

public class ProductInOrder {
    private String _ID;
    public ProductInOrder(String OrderID) {
        _ID = OrderID;
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,550);
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Product ID");
        columnNames.add("Quantity");
        columnNames.add("Product Name");
        columnNames.add("Category");
        columnNames.add("Brand");
        columnNames.add("Unit Price");
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

    }
}
