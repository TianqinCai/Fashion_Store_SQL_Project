import Function.sqlFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierBankInfo extends JFrame{
    private JLabel bank;
    private JButton button;
    private JTextField t1;
    private String _ID;
    private JFrame frame;

    public SupplierBankInfo(String ID){



        setVisible(true);
        setSize(500,400);
        setLayout(null);

        _ID = ID;
        bank = new JLabel("Bank No:");
        bank.setBounds(80, 50, 100, 50);
        t1 = new JTextField();
        t1.setBounds(80, 120, 280, 40);
        button = new JButton("Update");
        button.setBounds(100,210,150,50);
        add(bank);
        add(t1);
        add(button);
        ResultSet rs = sqlFunctions.showOneBankAccount(_ID);
        try {
            while (rs.next()) {
                String bank = rs.getString(1);
                t1.setText(bank);
            }
        } catch (Exception e){

        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sqlFunctions.updateOneBankAccount(_ID, t1.getText());
                } catch (SQLException e1) {

                    JOptionPane.showMessageDialog(frame, "SQLException catched! \nBank Account need to be 7 digit to 16 digit! \n\nPlease Enter Again!");
                    return;
                }
                JOptionPane.showMessageDialog(frame, "Update Succeed");
            }
        });
    }
}
