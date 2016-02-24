package br.com.projetocliente.restfulws;

import java.io.Writer;
import java.util.Calendar;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import br.com.projetocliente.modelo.ModeloWS;

@Path("/getServicos")
public class WSGetServicos {

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=ISO-8859-1")
    public String getClientesFV(@FormParam("token") String token){        
                     
        ModeloWS objModelo = new ModeloWS();        
        Calendar dataChamada = Calendar.getInstance();
        
        XStream xstream = new XStream(new JsonHierarchicalStreamDriver(){
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new JsonWriter(out, JsonWriter.DROP_ROOT_MODE);
                
            }
        });        
        
        String json = "";

        try{
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.aliasAttribute(ModeloWS.class, "lista", "clientes");
            xstream.processAnnotations(ModeloWS.class);
       
            objModelo.setLista(objAPIClientesERP.SelecionarClientesWS());
            
        }catch (Exception e) {
            objModelo.setCodigoErro(1);
            objModelo.setMensagemAuxiliar(e.getMessage());                
        }

        if(objModelo.getLista() != null){   
            
            boolean gravaLog = true;
            
            if(objModelo.getLista().size() == 0){
                xstream.omitField(ModeloWS.class, "lista");
                gravaLog = false;
            }
            
            json += xstream.toXML(objModelo);
            
        }else{                
        	objModelo.setCodigoErro(1);
        	objModelo.setMensagemAuxiliar("Ocorreu um Erro na chamada do WS");
            
            xstream.omitField(ModeloWS.class, "lista");
            
            json += xstream.toXML(objModelo);
        }
        
        return json;
    }
}
