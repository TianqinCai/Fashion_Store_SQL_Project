import Function.sqlFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerLogin extends JFrame {
    private JLabel l1;
    private JTextField t1;
    private JButton b1;


    public CustomerLogin(String title) {
        setSize(400,180);
        setVisible(true);
        //TODO: FRONT-END: get customer ID

        JFrame j = this;
        l1 = new JLabel();
        l1.setText("Please enter your CustomerID: ");
        l1.setBounds(30,30,200,35);
        t1 = new JTextField();
        t1.setBounds(30,80,180,35);
        b1 = new JButton("Enter");
        b1.setBounds(250,80,80,35);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Cid = t1.getText();
                if(sqlFunctions.isValidAccountCUSTOMER(Cid)) {
                    //if success
                    CustomerPage c = new CustomerPage("Customer Page", t1.getText());
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
