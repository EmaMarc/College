package ar.edu.unlp.info.oo1.patronesDeDiseño.ejercicio1;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONSimpleAdapter implements Exporter{

    @Override
    public String exportar(List<Socio> socios) {
        //crear jsonArray
        JSONArray array = new JSONArray();

        //para cada socio:
        socios.forEach(socio -> {
            //crear jsonObject
            JSONObject jsonSocio = new JSONObject();
            //poner nombre
            jsonSocio.put("nombre", socio.getNombre());
            //poner email
            jsonSocio.put("email", socio.getEmail());
            //poner legajo
            jsonSocio.put("legajo", socio.getLegajo());
            //agregar jsonObject al jsonArray
            array.add(jsonSocio);
        });

        //retornar jsonArray.toJSONString() con el objetoJson creado
        return array.toJSONString();
    }
}
