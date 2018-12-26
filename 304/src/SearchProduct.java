import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SearchProduct extends JFrame {
    private JLabel l1,l2,l3,l32,l4;
    private JButton button;
    private JTextField t1,t2,t3;
    private JComboBox<String> comboBox1, comboBox2;
    public SearchProduct(){
        setLayout(null);
        setSize(500,460);
        setVisible(true);
        l1 = new JLabel("Brand");
        l1.setBounds(50,50,120,50);
        l2 = new JLabel("Product Type");
        l2.setBounds(50,100,120,50);
        l3 = new JLabel("Sort by price");
        l3.setBounds(50,150,120,50);
        l32 = new JLabel("To");
        l32.setBounds(310,150,120,50);
        l4 = new JLabel("Product Name");
        l4.setBounds(50,200, 120,50);
        button = new JButton("Search");
        button.setBounds(80,300,120,50);
        String[] BrandStrings = {"Gucci","Polo","Addidas","Air Jordan"};
        comboBox1 = new JComboBox<>(BrandStrings);
        comboBox1.setSelectedIndex(3);
        comboBox1.setBounds(150,50,180,35);
        String[] TypeStrings = {"Bottom","Top","Dress","Ourwear","acessory", "shoe", "bag"};
        comboBox2 = new JComboBox<>(BrandStrings);
        comboBox2.setSelectedIndex(1);
        comboBox2.setBounds(150,100,180,35);
        t1 = new JTextField();
        t1.setBounds(180, 150, 120,35);
        t2 = new JTextField();
        t2.setBounds(340, 150, 120, 35);
        t3 = new JTextField();
        t3.setBounds(180, 200,180,35);
        add(l1);
        add(l2);
        add(l3);
        add(l32);
        add(l4);
        add(button);
        add(comboBox1);
        add(comboBox2);
        add(t1);
        add(t2);
        add(t3);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame result = new JFrame("Search Results");
                result.setSize(810,350);
                result.setVisible(true);

                Vector<String> columnNames = new Vector<String>();
                columnNames.add("Product ID");
                columnNames.add("Name");
                columnNames.add("Price");
                columnNames.add("Brand");
                columnNames.add("Category");
                columnNames.add("Review Star");
                columnNames.add("Supplier Info");
                columnNames.add("Total Purchase");
                Vector<Vector<String>> data = new Vector<Vector<String>>();

                //ResultSet rs = sqlFunctions.searchProduct(t3.getText(),comboBox2.getSelectedItem().toString(),float UNITPRICEUPPER,float UNITPRICELOWER,String BRAND, float REVIEWSTARUPPER,float REVIEWSTARLOWER )

                JTable table = new JTable(data, columnNames);
                JScrollPane scrollpane = new JScrollPane(table);
                scrollpane.setPreferredSize(new Dimension(650, 350));
                result.add(scrollpane);

                //TODO: FRONT-END: can purchase one product, or give one product a review score?

            }
        });
    }
}
