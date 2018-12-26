import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPage extends JFrame {
    private JLabel l1;
    private JButton b1, b2, b3, b4;
    private String _ID;
    //private String ID;

//    public void createCustomerPage(){
//        JFrame frame = new JFrame("Hello Customer!");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//        JPanel panel1 = new JPanel();
//        panel1.setBackground(Color.PINK);
//        panel1.setPreferredSize(new Dimension(200, 150));
//
//        JLabel orders = new JLabel("Orders", SwingConstants.CENTER);
//        orders.setPreferredSize(new Dimension(160, 30));
//        panel1.add(orders);
//        JButton b1 = new JButton("Previous Orders");
//        b1.setPreferredSize(new Dimension(160, 30));
//        b1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new PreviousOrders();
//                new OrderDetails();
//            }
//        });
//        panel1.add(b1);
//
//        JButton b2 = new JButton("Previous Orders");
//        b2.setPreferredSize(new Dimension(160, 30));
//        b2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new SearchOrder("Search an order");
//            }
//        });
//        panel1.add(b2);
//
//        frame.add(orders,BorderLayout.PAGE_START);
//        frame.add(panel1,BorderLayout.LINE_START);
//
//        JPanel panel2 = new JPanel();
//        panel2.setBackground(Color.LIGHT_GRAY);
//        panel2.setPreferredSize(new Dimension(200, 150));
//
//        frame.add(panel2,BorderLayout.CENTER);
//        frame.pack();
//
//
//    }
//
//    public CustomerPage(){
//        System.out.println("create a customer page");
//        createCustomerPage();
//    }

    public CustomerPage(String title, String ID){
        super(title);
        this._ID = ID;
        setSize(400,550);
        setVisible(true);
        setLayout(null);

        l1 = new JLabel();
        l1.setText("Hello Customer "+ _ID);
        l1.setBounds(30,30,250,50);
        b1 = new JButton("View Previous Orders");
        b1.setBounds(50,120, 220,50);
        b4 = new JButton("Search an Order");
        b4.setBounds(50,360,220,50);
        b2 = new JButton("Browse Products");
        b2.setBounds(50,200,220,50);
        b3 = new JButton("Update Billing Information");
        b3.setBounds(50, 280, 220, 50);
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PreviousOrders(_ID);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchOrder("Search an order", _ID);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Product();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerBillingInfo(_ID);
            }
        });
    }
}
