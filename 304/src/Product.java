import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Product extends JFrame {
    private JButton b1,b2;
    public Product(){
        setVisible(true);
        setLayout(null);
        setSize(300,250);
        b1 = new JButton("View all Products");
        b1.setBounds(50,50,180,50);
        b2 = new JButton("Search a product");
        b2.setBounds(50,125,180,50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AllProduct();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchProduct();
            }
        });
        add(b1);
        add(b2);
    }
}
