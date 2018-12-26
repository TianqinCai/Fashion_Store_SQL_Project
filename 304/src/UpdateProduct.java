import Function.sqlFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateProduct extends JFrame {
    private JLabel Name, Category, Price, Supplier,Contact;
    private JTextField t1,t2,t3,t4,t5;
    private JButton button;
    private String PID, _ID;
    private JFrame frame;
    public UpdateProduct(String SID) {

        _ID = SID;
        frame = this;
        setVisible(true);
        setSize(550, 590);
        setLayout(null);

        JTextField ID = new JTextField("Please enter the product ID");
        ID.setBounds(35,30,180,30);
        JButton search = new JButton("Get Info of this product");
        search.setBounds(35,85,180,30);
        add(ID);
        add(search);


        Name = new JLabel("Product Name:");
        Name.setBounds(80, 150, 100, 50);
        Category = new JLabel("Category");
        Category.setBounds(80, 200, 100, 50);
        Price = new JLabel("Price:");
        Price.setBounds(80, 250, 100, 50);
        Supplier = new JLabel("Supplier ID:");
        Supplier.setBounds(80, 300, 100, 50);
        Contact = new JLabel("Supplier Contact: ");
        Contact.setBounds(80,350,100,50);
        button = new JButton("Update");
        button.setBounds(280, 460, 150, 50);
        t1 = new JTextField();
        t1.setBounds(230, 150, 240, 40);
        t2 = new JTextField();
        t2.setBounds(230, 200, 240, 40);
        t3 = new JTextField();
        t3.setBounds(230, 250, 240, 40);
        t4 = new JTextField();
        t4.setBounds(230, 300, 240, 40);
        t5 = new JTextField();
        t5.setBounds(230,350,240,40);

        add(button);
        add(Name);
        add(Category);
        add(Price);
        //add(Supplier);
        add(t1);
        add(t2);
        add(t3);
        //add(t4);
//        add(Contact);
//        add(t5);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sqlFunctions.checkProductOwner(PID, _ID)) {
                    sqlFunctions.updateProduct(PID, t1.getText(), t2.getText(), t3.getText(), t4.getText());
                    JOptionPane.showMessageDialog(frame, "Update succeed");
                } else {
                    JOptionPane.showMessageDialog(frame,"Sorry. This is not your product!");
                }

            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PID = ID.getText();
                ResultSet rs = sqlFunctions.showOneProductDetail(PID);
                try {
                    while (rs.next()) {
                    	if(rs.getString(2).length()==0) {
                    		System.out.println("not found");
                    		JOptionPane.showMessageDialog(frame, "This product doesn't exist");
                    	}
                    	System.out.println("rs:" + rs.getString(2));
                        t1.setText(rs.getString(2));
                        t2.setText(rs.getString(3));
                        t3.setText(rs.getString(4));
                    }
                } catch (Exception e1) {
                    System.out.println("search result is null");
                    JOptionPane.showMessageDialog(frame, "The Product ID need to be an integer");
                }


            }
        });
    }
}
