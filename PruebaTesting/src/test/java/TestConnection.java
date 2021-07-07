import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static OracleConnection.OracleConnection.getOracleConnection;

/**
 * Created by Igor on 5/14/2017.
 */
public class TestConnection {

    public static void main(String[] args) throws SQLException {

        /*System.out.println("Empieza programa");
        System.out.println ("Por favor introduzca numero de cuenta:");
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        int numeroConta= 0;
        numeroConta= reader.nextInt();
        String tipoConta = "";
        tipoConta = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner

        System.out.println ("Entrada recibida por teclado es: \"" + tipoConta +"\"");*/

        String selectTableSQL = " SELECT * from MOVIMIENTOS";

        Statement statement = null;

        try {

            Connection connection= getOracleConnection();

            statement = connection.createStatement();


            // get data from DB
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // fetch data
            while (rs.next()) {
                String field = rs.getString(1);


                System.out.println("field : " + field);
            }
        } catch (SQLException e) {
         //   System.out.println(e.getMessage());
        }

    }

}
