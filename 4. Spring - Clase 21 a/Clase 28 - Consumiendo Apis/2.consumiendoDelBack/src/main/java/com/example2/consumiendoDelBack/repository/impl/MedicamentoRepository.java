package com.example2.consumiendoDelBack.repository.impl;

import com.example2.consumiendoDelBack.dto.MedicamentoDTO;
import com.example2.consumiendoDelBack.repository.IRepositoryRest;
import com.example2.consumiendoDelBack.util.Jsons;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;


public class MedicamentoRepository implements IRepositoryRest<MedicamentoDTO> {

    @Override
    public MedicamentoDTO guardar(MedicamentoDTO medicamentoDTO) {
        HttpResponse<String> response = null;
        MedicamentoDTO medicamento = null;
        try{
            response = Unirest.post("http://localhost:8080/medicamentos/registrar")
                    .header("Content-Type", "application/json")
                    .body(Jsons.asJsonString(medicamentoDTO)).asString();

            medicamento = Jsons.objectFromString(MedicamentoDTO.class, response.getBody());

        }catch (Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public MedicamentoDTO buscar(Integer id) {
        HttpResponse<String> response = null;
        MedicamentoDTO medicamento = null;
        try{
            response = Unirest.get("http://localhost:8080/medicamentos/"+id).asString();
            medicamento = Jsons.objectFromString(MedicamentoDTO.class, response.getBody());

        }catch (Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public MedicamentoDTO update(MedicamentoDTO medicamentoDTO) {
        HttpResponse<String> response = null;
        MedicamentoDTO medicamento = null;
        try{
            response = Unirest.put("http://localhost:8080/medicamentos/actualizar")
                    .header("Content-Type", "application/json")
                    .body(Jsons.asJsonString(medicamentoDTO)).asString();

            medicamento = Jsons.objectFromString(MedicamentoDTO.class, response.getBody());

        }catch (Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public String eliminar(Integer id) {
        HttpResponse<String> response = null;
        try{
            response = Unirest.delete("http://localhost:8080/medicamentos/"+id).asString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return response !=null ? String.valueOf(response.getStatus()) : null;
    }
}
