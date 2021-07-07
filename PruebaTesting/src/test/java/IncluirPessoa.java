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
import java.util.*;
import java.util.Date;


public class IncluirPessoa {
    private ResultSet rs;
    @Test
    public void pruebaConParametros(){
        incluirPessoaPost("91144821002","CPF",  "2000-08-10T00:00:00Z", "NAO", "FEMININO", "RIO DE JANEIRO",
                "76", "MAMAE AMANDA ARAUJO", "PAPAI AMANDA ARAUJO", "RJ", "AMANDA ARAUJO", "SOLTEIRO",
                "BRASILEIRO", "NAO", "NAO", 130000, "NAO", "HIST", "NAO", "HIST@GMAIL.COM",
                "1" , "Algun Cargo", 5000,  "SIM", 4000, "NAO",
                 "51", "998085315", "", "CELULAR", "2010-12-02", "11487986118",
                 "SSP", "RG", "RS", "2025-12-02", "01009999", "CRISTOVÃO COLOMBO",
                "RUA", 2948, "HIGIENOPOLIS", "AP 610", "RESIDENCIAL", "NAO_INFORMADA");
    }

    //verificar dataNascimiento, llega como string pero debe ser Date
    public void incluirPessoaPost(String numeroDocumento, String tipoDocumento, String dataNascimento, String emancipado, String genero,
                                  String naturalidade, String codigoPais, String nomeMae, String nomePai, String ufNaturalidade,
                                  String nomeCompleto, String estadoCivil, String nacionalidade, String declaracaoFatca, String declaracaoPpe,
                                  int patrimonioFim, String pessoaComDeficiencia, String apelido, String funcionario, String email,
                                  String codigoProfissao, String nomeCargo,int rendaBruta, String rendaComprovada, int rendaLiquida,
                                  String rendaPresumida,String ddd,String telefone, String ramal , String tipoTelefone, String dataExpedicao,
                                  String AdicionalnumeroDocumento, String orgaoExpedicaoSigla, String AdicionaltipoDocumento, String ufExpedicao,
                                  String dataExpiracao,String cep, String logradouro, String tipoLogradouro,int numero, String bairro, String complemento,
                                  String tipoEndereco, String tipoResidencia)
     {

        baseURI = "http://localhost:8080/topazinterpretedws/ContasService/v1/PruebaWebServices";

        //hashmap para dados basicos
        Map<String, Object> dadosBasicosMap = new HashMap<String, Object>();
            dadosBasicosMap.put("dadosBasicos.dataNascimento",dataNascimento);
            dadosBasicosMap.put("dadosBasicos.emancipado",emancipado);
            dadosBasicosMap.put("dadosBasicos.genero",genero);
            dadosBasicosMap.put("dadosBasicos.naturalidade",naturalidade);
            dadosBasicosMap.put("dadosBasicos.codigoPais",codigoPais);
            dadosBasicosMap.put("dadosBasicos.nomeMae",nomeMae);
            dadosBasicosMap.put("dadosBasicos.nomePai",nomePai);
            dadosBasicosMap.put("dadosBasicos.ufNaturalidade",ufNaturalidade);
            dadosBasicosMap.put("dadosBasicos.nomeCompleto",nomeCompleto);
            dadosBasicosMap.put("dadosBasicos.estadoCivil",estadoCivil);
            dadosBasicosMap.put("dadosBasicos.nacionalidade",nacionalidade);
            dadosBasicosMap.put("dadosBasicos.declaracaoFatca",declaracaoFatca);
            dadosBasicosMap.put("dadosBasicos.declaracaoPpe",declaracaoPpe);
            dadosBasicosMap.put("dadosBasicos.patrimonioFim",patrimonioFim);
            dadosBasicosMap.put("dadosBasicos.pessoaComDeficiencia",pessoaComDeficiencia);
            dadosBasicosMap.put("dadosBasicos.apelido",apelido);
            dadosBasicosMap.put("dadosBasicos.funcionario",funcionario);

            List<Map<String,Object>> dadosBasicos = new ArrayList<>();
            dadosBasicos.add(dadosBasicosMap);

        //hashmap para dados email
        Map<String, Object> dadosEmailMap = new HashMap<String, Object>();
            dadosEmailMap.put("email", email);

         List<Map<String,Object>> dadosEmail = new ArrayList<>();
         dadosEmail.add(dadosEmailMap);

        //hashmap para dados profissao
        Map<String, Object> dadosProfissaoMap = new HashMap<String, Object>();
            dadosProfissaoMap.put("codigoProfissao", codigoProfissao);
            dadosProfissaoMap.put("nomeCargo", nomeCargo);

         List<Map<String,Object>> dadosProfissao = new ArrayList<>();
         dadosProfissao.add(dadosProfissaoMap);

        //hashmap para dados renda
        Map<String, Object> dadosRendaMap = new HashMap<String, Object>();
         dadosRendaMap.put("rendaBruta", rendaBruta);
            dadosRendaMap.put("rendaComprovada", rendaComprovada);
            dadosRendaMap.put("rendaLiquida", rendaLiquida);
            dadosRendaMap.put("rendaPresumida", rendaPresumida);

         List<Map<String,Object>> dadosRenda = new ArrayList<>();
         dadosRenda.add(dadosRendaMap);

        //hashmap para dados telefone
        Map<String, Object> dadosTelefoneMap = new HashMap<String, Object>();
            dadosTelefoneMap.put("ddd", ddd);
            dadosTelefoneMap.put("telefone", telefone);
            dadosTelefoneMap.put("ramal", ramal);
            dadosTelefoneMap.put("tipoTelefone", tipoTelefone);

         List<Map<String,Object>> dadosTelefone = new ArrayList<>();
         dadosTelefone.add(dadosTelefoneMap);

        //hashmap para documento adicional
        Map<String, Object> documentoAdicionalMap = new HashMap<String, Object>();
            documentoAdicionalMap.put("dataExpedicao", dataExpedicao);
            documentoAdicionalMap.put("numeroDocumento", AdicionalnumeroDocumento);
            documentoAdicionalMap.put("orgaoExpedicaoSigla", orgaoExpedicaoSigla);
            documentoAdicionalMap.put("tipoDocumento", AdicionaltipoDocumento);
            documentoAdicionalMap.put("ufExpedicao", ufExpedicao);
            documentoAdicionalMap.put("dataExpiracao", dataExpiracao);

         List<Map<String,Object>> documentoAdicional = new ArrayList<>();
         documentoAdicional.add(documentoAdicionalMap);

        //hashmap para dados endereco
        Map<String, Object> dadosEnderecoMap = new HashMap<String, Object>();
            dadosEnderecoMap.put("cep", cep);
            dadosEnderecoMap.put("logradouro", logradouro);
            dadosEnderecoMap.put("tipoLogradouro", tipoLogradouro);
            dadosEnderecoMap.put("numero", numero);
            dadosEnderecoMap.put("bairro", bairro);
            dadosEnderecoMap.put("complemento", complemento);
            dadosEnderecoMap.put("tipoEndereco", tipoEndereco);
            dadosEnderecoMap.put("tipoResidencia", tipoResidencia);

         List<Map<String,Object>> dadosEndereco = new ArrayList<>();
         dadosEndereco.add(dadosEnderecoMap);

            Map<String, Object> bodyMap = new HashMap<String,Object>();
            bodyMap.put("numeroDocumento",numeroDocumento);
            bodyMap.put("tipoDocumento", tipoDocumento);
            bodyMap.put("dadosBasicos",dadosBasicos);
            bodyMap.put("dadosEmail",dadosEmail);
            bodyMap.put("dadosProfissao",dadosProfissao);
            bodyMap.put("dadosRenda",dadosRenda);
            bodyMap.put("dadosTelefone",dadosTelefone);
            bodyMap.put("documentoAdicional",documentoAdicional);
            bodyMap.put("dadosEndereco",dadosEndereco);

         given()
                .header("Topaz-Channel", "MOBILE")
                .header("Topaz-Transaction-ID", 86154152)
                .header("Topaz-User", "TOP")
                .header("Topaz-Company", 358)
                .header("Topaz-Branch", 1001)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Authorization", "Bearer 45684184")
                .header("Topaz-Ip-Address", "127.0.0.0")
                .header("Topaz-Mac-Address", "00-14-22-01-23-45")

                /*.param("numeroDocumento", numeroDocumento)
                .param("tipoDocumento", tipoDocumento)
                .param("dadosBasicos",dadosBasicosMap)
                .param("dadosEmail",dadosEmailMap)
                .param("dadosProfissao",dadosProfissaoMap)
                .param("dadosRenda",dadosRendaMap)
                .param("dadosTelefone",dadosTelefoneMap)
                .param("documentoAdicional",documentoAdicionalMap)
                .param("dadosEndereco",dadosEnderecoMap)*/
                .body(bodyMap)
                .post("http://localhost:8080/topazinterpretedws/PessoaService/v1/incluirPessoa")
                .then().log().all();

               /* System.out.println(response);
        if(response.statusCode() == 201 ){
            System.out.println("Status 201, realiza consultas en la bd");
           // validacionesBD();*/
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
