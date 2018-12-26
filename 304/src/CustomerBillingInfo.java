import Function.sqlFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerBillingInfo extends JFrame {
    private JLabel Addr, City, Country, PostCode, CreditCard, Cvv, ExpireDate;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    private JButton button;
    private String _ID;
    private JFrame frame;
    public CustomerBillingInfo(String ID){
        this._ID = ID;
        setVisible(true);
        setSize(550,590);
        setLayout(null);
        Addr = new JLabel("Address");
        Addr.setBounds(80,50,100,50);
        Cvv = new JLabel("Cvv");
        Cvv.setBounds(80,100,100,50);
        ExpireDate = new JLabel("Expire Date");
        ExpireDate.setBounds(80,150,100,50);
        PostCode = new JLabel("PostCode");
        PostCode.setBounds(80,200,100,50);
        CreditCard = new JLabel("Credit Card No.");
        CreditCard.setBounds(80,250,100,50);
        button = new JButton("Update");
        button.setBounds(80,440,150,50);

        ResultSet rs = sqlFunctions.showOneUserBillingAddressInfo(_ID);


        t1 = new JTextField();
        t1.setBounds(230,50,240,40);
        
        t2 = new JTextField();
        t2.setBounds(230,100,240,40);
        t3 = new JTextField();
        t3.setBounds(230,150,240,40);
        
        t4 = new JTextField();
        t4.setBounds(230,200,240,40);
        t5 = new JTextField();
        t5.setBounds(230,250,240,40);


        try {
            while(rs.next()) {
            	String t = rs.getString(3);
            	t = t.substring(0, 50);
            	t1.setText(t);
                t5.setText(rs.getString(4));
                t2.setText(rs.getString(6));
                String temp = rs.getString(5);
                temp=temp.substring(0,11);
                t3.setText(temp);
                t4.setText(rs.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //TODO: BACK-END: now waiting for an update function

        add(button);
        add(Addr);
//        add(City);
//        add(Country);
        add(PostCode);
        add(CreditCard);
        add(Cvv);
        add(ExpireDate);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        //add(t6);add(t7);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(t1.getText() + t2.getText());
                sqlFunctions.updateOneBankBillingInfo(_ID,t1.getText(),t5.getText(),t3.getText(),t2.getText(),t4.getText());
                System.out.println("UPdated");
                JOptionPane.showMessageDialog(frame, "Update succeed");
            }
        });

    }
}
