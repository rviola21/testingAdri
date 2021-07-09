import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ReqResTests {
    @Test
    public void mandarParametros(){
        pruebaGet(   1000322, "CONTA_CORRENTE_PF", 800,"Credito de prueba4", "algo3", "algo3");
        }

        public void setup()

    LocalDateTime dateNow = LocalDateTime.now();
    String fechaNow = dateNow.toString();

    public void pruebaGet(int numeroConta, String tipoConta, int valor, String concepto, String referencia, String comprobante){
        RequestPrueba requestPOJO = new RequestPrueba();
        requestPOJO.setNumeroConta(numeroConta);
        requestPOJO.setTipoConta(tipoConta);
        requestPOJO.setValor(valor);
        requestPOJO.setConcepto(concepto);
        requestPOJO.setReferencia(referencia);
        requestPOJO.setComprobante(comprobante);


      String response =  RestAssured.given()
              .header("Topaz-Channel", "MOBILE")
              .header("Topaz-Transaction-ID", fechaNow)
              .header("Topaz-User", "TOP")
              .header("Topaz-Company", 358)
              .header("Topaz-Branch", 1001)
              .header("Content-Type", "application/json;charset=UTF-8")
              .header("Authorization", "Bearer 45684184")
              .header("Topaz-Transaction-IDStep", 57)
              .header("Topaz-Ip-Address", "127.0.0.0")
              .header("Topaz-Mac-Address", "00-14-22-01-23-45")

                .contentType(ContentType.JSON)
                .body(requestPOJO)
                .get( "http://localhost:8080/topazinterpretedws/ContasService/v1/PruebaWebServices")
                .then()
                .log().all()
              .extract().asString();

        System.out.println(response);

    }
   /* @Test
    public void postPessoa(){
        String response =  RestAssured.given()
                .header("Topaz-Channel", "MOBILE")
                .header("Topaz-Transaction-ID", fechaNow)
                .header("Topaz-User", "TOP")
                .header("Topaz-Company", 358)
                .header("Topaz-Branch", 1001)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Authorization", "Bearer 45684184")
                .header("Topaz-Transaction-IDStep", 57)
                .header("Topaz-Ip-Address", "127.0.0.0")
                .header("Topaz-Mac-Address", "00-14-22-01-23-45")
                .contentType(ContentType.JSON)
                .body("{ \n" +
                        "\"numeroDocumento\": \"91144821002\", \n" +
                        "\"tipoDocumento\": \"CPF\",\n" +
                        "\"dadosBasicos\": { \n" +
                        "      \"dataNascimento\": \"2000-08-10T00:00:00Z\", \n" +
                        "      \"emancipado\":\"NAO\",\n" +
                        "      \"genero\": \"FEMININO\", \n" +
                        "      \"naturalidade\":  \"RIO DE JANEIRO\", \n" +
                        "      \"codigoPais\": \"76\", \n" +
                        "      \"nomeMae\": \"MAMAE AMANDA ARAUJO\", \n" +
                        "      \"nomePai\": \"PAPAI AMANDA ARAUJO\", \n" +
                        "      \"ufNaturalidade\":\"RJ\", \n" +
                        "      \"nomeCompleto\": \"AMANDA ARAUJO\", \n" +
                        "      \"estadoCivil\": \"SOLTEIRO\", \n" +
                        "      \"nacionalidade\": \"BRASILEIRO\", \n" +
                        "      \"declaracaoFatca\": \"NAO\", \n" +
                        "      \"declaracaoPpe\": \"NAO\", \n" +
                        "      \"patrimonioFim\": 130000, \n" +
                        "      \"pessoaComDeficiencia\": \"NAO\", \n" +
                        "      \"apelido\": \"HIST\",\n" +
                        "      \"funcionario\": \"NAO\"\n" +
                        "}, \n" +
                        "\"dadosEmail\": { \n" +
                        "      \"email\": \"HIST@GMAIL.COM\" \n" +
                        "},\n" +
                        "\"dadosProfissao\": { \n" +
                        "      \"codigoProfissao\": \"1\" ,\n" +
                        "      \"nomeCargo\": \"Algun Cargo\" \n" +
                        "},\n" +
                        "\"dadosRenda\": { \n" +
                        "\t  \"rendaBruta\": 5000, \n" +
                        "\t  \"rendaComprovada\": \"SIM\", \n" +
                        "\t  \"rendaLiquida\": 4000, \n" +
                        "\t  \"rendaPresumida\": \"NAO\"\n" +
                        "},\n" +
                        "\"dadosTelefone\": { \n" +
                        "      \"ddd\": \"51\", \n" +
                        "      \"telefone\": \"998085315\", \n" +
                        "      \"ramal\": \"\", \n" +
                        "      \"tipoTelefone\": \"CELULAR\" \n" +
                        "}, \n" +
                        "\"documentoAdicional\": { \n" +
                        "\t  \"dataExpedicao\": \"2010-12-02\", \n" +
                        "\t  \"numeroDocumento\": \"11487986118\", \n" +
                        "\t  \"orgaoExpedicaoSigla\": \"SSP\", \n" +
                        "\t  \"tipoDocumento\": \"RG\", \n" +
                        "\t  \"ufExpedicao\": \"RS\",\n" +
                        "\t  \"dataExpiracao\": \"2025-12-02\"\n" +
                        " }, \n" +
                        "\"dadosEndereco\": { \n" +
                        "      \"cep\": \"01009999\", \n" +
                        "      \"logradouro\": \"CRISTOVÃO COLOMBO\", \n" +
                        "      \"tipoLogradouro\": \"RUA\", \n" +
                        "      \"numero\": 2948, \n" +
                        "      \"bairro\": \"HIGIENOPOLIS\", \n" +
                        "      \"complemento\": \"AP 610\", \n" +
                        "      \"tipoEndereco\": \"RESIDENCIAL\",\n" +
                        "      \"tipoResidencia\": \"NAO_INFORMADA\"\n" +
                        "}\n" +
                        "} ")
                .post( "http://localhost:8080/topazinterpretedws/PessoaService/v1/incluirPessoa")
                .then()
                .log().all()
                .extract()
                .asString();
        System.out.println(response);

    }*/
}
