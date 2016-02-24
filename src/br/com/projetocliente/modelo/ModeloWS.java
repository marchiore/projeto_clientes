package br.com.projetocliente.modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloWS extends ErroWS{

    private List<Object> lista = new ArrayList<Object>();
    
    public ModeloWS(){
        super();
    }    

    public List<Object> getLista() {
        return lista;
    }
    public void setLista(List<Object> lista) {
        this.lista = lista;
    }

}
