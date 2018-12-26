import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {

    private static JFrame mainframe;

    public static void createMainWindow(){
        mainframe = new MainFrame("Fashion Store System");
    }

    public static void main(String argv[]) throws SQLException {

    	createMainWindow();
    }


    
}