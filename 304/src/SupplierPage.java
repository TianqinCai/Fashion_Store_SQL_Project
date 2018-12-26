import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierPage extends JFrame {
    private JLabel l1;
    private JButton b1, b2, b3,b4;
    private String _ID;
    public SupplierPage(String title, String ID){
        //TODO: FRONT-END: Get supplier ID
        super(title);
        setSize(400,560);
        setVisible(true);
        setLayout(null);

        this._ID = ID;
        l1 = new JLabel();
        l1.setText("Hello Supplier " + _ID +" !");
        l1.setBounds(30,50,250,50);
        b1 = new JButton("Update Product Info");
        b1.setBounds(50,120, 220,50);
        b2 = new JButton("Update Bank Info");
        b2.setBounds(50,200,220,50);
        b3 = new JButton("View Current Orders");
        b3.setBounds(50, 280, 220, 50);
        b4 = new JButton("View All Product");
        b4.setBounds(50,360,220,50);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateProduct(_ID);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SupplierBankInfo(ID);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CurrentOrders(_ID);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AllProduct();
            }
        });
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

//        Browser b = new Browser();
//        BrowserView bv = new BrowserView(b);
//        add(bv);
//        b.loadURL("http://www.google.com");

        JButton b5 = new JButton("Search a product on google ");
        b5.setBounds(50,440,250,50);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Browser browser = new Browser();
                BrowserView browserView = new BrowserView(browser);
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.add(browserView, BorderLayout.CENTER);
                frame.setSize(700, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                browser.loadURL("http://www.google.com");
            }
        });

        add(b5);


    }
}

