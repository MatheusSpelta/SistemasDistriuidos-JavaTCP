/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerTarefas;

import dominio.Endereco;
import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author mathe
 */

public class BuscaCEP {

    /**
     * Recupera objeto Endereco pelo CEP
     * @param cep String no formato 00000000
     * @return instancia de br.com.correios.Endereco
     */
    public static Endereco getEnderecoPorCep(String cep) {

        Document document = getCepResponse(cep);
        Endereco endereco = null;

        if (document != null) {
            Map<String, String> mapa = buscaNodes(document.getChildNodes(), new HashMap<String, String>());

            endereco = new Endereco(mapa.get("cep"), mapa.get("uf"), mapa.get("bairro"),
                    mapa.get("cidade"), mapa.get("end"), mapa.get("complemento") );
        }

        return endereco;
    }

    private static Document getCepResponse(String cep) {
        final String wellformedrequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"" +
                " xmlns:cli=\"http://cliente.bean.master.sigep.bsb.correios.com.br/\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<cli:consultaCEP>" +
                "<cep>"+cep+"</cep>" +
                "</cli:consultaCEP>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        DefaultHttpClient httpclient;
        Document document = null;
        try {
   //         if (!FuncoesUteis.validaCep(cep)) {
   //             throw new RuntimeException("Formato de CEP inválido");
   //         }

            httpclient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente");
            httpPost.setHeader(new BasicHeader("Content-Type", "text/xml;charset=UTF-8"));
            httpPost.setHeader(new BasicHeader("SOAPAction", "http://cliente.bean.master.sigep.bsb.correios.com.br/AtendeCliente/consultaCEP"));
            StringEntity s = new StringEntity(wellformedrequest, "UTF-8");
            httpPost.setEntity(s);
            HttpResponse response = httpclient.execute(httpPost);
            

//          if (entity != null) {
            if (response.getStatusLine().getStatusCode() == 200) {  // Codigo OK
                
                HttpEntity entity = response.getEntity();
                
                InputStream inputStream = entity.getContent();

                byte[] buffer = new byte[(int) entity.getContentLength()];
                inputStream.read(buffer);

                ByteArrayInputStream bais = new ByteArrayInputStream(buffer);

                SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(null, bais);

                document = soapMessage.getSOAPBody().extractContentAsDocument();

                inputStream.close();
            }

            httpclient.getConnectionManager().shutdown();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return document;
    }

    private static Map<String, String> buscaNodes(NodeList nodeList, Map<String, String> mapa) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            mapa.put(nodeList.item(i).getNodeName(), nodeList.item(i).getTextContent());

            if (nodeList.item(i).getChildNodes() != null) {
                buscaNodes(nodeList.item(i).getChildNodes(), mapa);
            }
        }

        return mapa;
    }
}    
