import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static JButton b1, b2;
    private static JLabel l1;
    private Dimension bdimension;
    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(380,360));
        setVisible(true);

        setLayout(null);

        //create Swing components
        l1=new JLabel("<html>Welcome to the Fashion Store System! <br><br><br> Please choose your users type:</html> ");
        l1.setBounds(30,20,240,80);
        b1 = new JButton("Customer");
        b2 = new JButton("Supplier");
        b1.setBounds(120,120,120,50);
        b2.setBounds(120,200,120,50);

        add(l1);
        add(b1);
        add(b2);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MainFrame.super.setVisible(false);
                CustomerLogin c = new CustomerLogin("Customer Login");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupplierLogin s = new SupplierLogin("Supplier Login");
            }
        });


    }
}
