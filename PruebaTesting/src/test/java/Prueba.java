import static OracleConnection.OracleConnection.getOracleConnection;
import static  io.restassured.RestAssured.*;

import java.sql.*;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import jdk.net.SocketFlow;
import org.apache.http.HttpStatus;
import org.testng.IDynamicGraph;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.sql.ResultSetMetaData;


public class Prueba {
    private ResultSet rs;


    @Test
    public void pruebaConParametros(){
        pruebaGet(1000322,"CONTA_CORRENTE_PF",70,"Creditode prueba5","algo5","algo5");
    }

    public void pruebaGet(int numeroConta, String tipoConta, int valor, String concepto, String referencia, String comprobante) {

        baseURI = "http://localhost:8080/topazinterpretedws/ContasService/v1/PruebaWebServices";
        LocalDateTime fechaAhora = LocalDateTime.now();
        String transactionId = fechaAhora.toString();
        Response response = given()
                .header("Topaz-Channel", "MOBILE")
                .header("Topaz-Transaction-ID", transactionId)
                .header("Topaz-User", "TOP")
                .header("Topaz-Company", 358)
                .header("Topaz-Branch", 1001)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Authorization", "Bearer 45684184")
                .header("Topaz-Transaction-IDStep", 57)
                .header("Topaz-Ip-Address", "127.0.0.0")
                .header("Topaz-Mac-Address", "00-14-22-01-23-45")

                .param("conta.numeroConta", numeroConta)
                .param("conta.tipoConta", tipoConta)
                .param("valor", valor)
                .param("Concepto", concepto)
                .param("Referencia", referencia)
                .param("Comprobante", comprobante)

                .get("http://localhost:8080/topazinterpretedws/ContasService/v1/PruebaWebServices")
                .then().log().body().extract().response();


                if(response.statusCode() == 200 ){
                   System.out.println("Status 200, realiza consultas en la bd");
                   validacionesBD();
                }

    }

        public void validacionesBD(){
            String selectTableSQL = " SELECT * from MOVIMIENTOS_CONTABLES";

            Statement statement = null;

            try {

                Connection connection= getOracleConnection();

                statement = connection.createStatement();


                // get data from DB
                ResultSet rs = statement.executeQuery(selectTableSQL);

                while (rs.next())
                    {
                        String field = rs.getString(1);
                        System.out.println("field : " + field);
                        System.out.println(rs);
                    }

                }
            catch (SQLException e) {
                 System.out.println(e.getMessage());
            }
        }

}
