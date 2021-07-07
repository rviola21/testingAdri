package OracleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class OracleConnection {



    public static Connection getOracleConnection() throws SQLException {


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        catch(IllegalAccessException ex) {
            System.out.println("Error: access problem while loading!");
            System.exit(2);
        }
        catch(InstantiationException ex) {
            System.out.println("Error: unable to instantiate driver!");
            System.exit(3);
        }


        String URL = "jdbc:oracle:thin:@TOPSERVER29:1521:TOPAZ";
        Properties info = new Properties( );
        info.put( "User", "topazbrd" );
        info.put( "Password", "topazbrd" );

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, "topazbrd", "topazbrd");
            // or
            // connection = DriverManager.getConnection("jdbc:oracle:thin:@//123.123.123.123:1521/XE", "Me", "My_password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return connection;
    }
}
