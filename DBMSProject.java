
package dbmsproject;

import dbmsproject.HomeFrame;
import dbmsproject.Connector;
import java.awt.*;


public class DBMSProject {

   
    Boolean user_login = false;

    public static void main(String[] args) {
        //Firts establish connection with DB
        Connector con1 = new Connector();
        // TODO code application logic here
        HomeFrame h1 = new HomeFrame(con1.getConn());
        h1.setSize(new Dimension(500, 500));
        h1.setVisible(true);

    }

}
