import Function.sqlFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierLogin extends JFrame {
    public SupplierLogin(String title) {
        super(title);
        setSize(400,180);
        setVisible(true);

        JFrame j = this;
        JLabel l1 = new JLabel();
        l1.setText("Please enter your SupplierID: ");
        l1.setBounds(30,30,200,35);
        JTextField t1 = new JTextField();
        t1.setBounds(30,80,180,35);
        JButton b1 = new JButton("Enter");
        b1.setBounds(250,80,80,35);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Cid = t1.getText();
                System.out.println(Cid);
                if(sqlFunctions.isValidAccountSupplier(Cid)) {
                    //if success
                    SupplierPage c = new SupplierPage("Customer Page", t1.getText());
                } else {
                    JOptionPane.showMessageDialog(j,"This ID doesn't exist");
                    dispose();
                }
            }
        });

        setLayout(null);
        this.add(l1);
        this.add(t1);
        this.add(b1);

    }

}
