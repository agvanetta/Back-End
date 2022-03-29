package com.example2.consumiendoDelBack.service;

import com.example2.consumiendoDelBack.dto.MedicamentoDTO;
import com.example2.consumiendoDelBack.repository.IRepositoryRest;

public class MedicamentoService {

    private IRepositoryRest<MedicamentoDTO> medicamentoRepository;

    //Constructor
    public MedicamentoService(IRepositoryRest<MedicamentoDTO> medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public MedicamentoDTO guardarMedicamento(MedicamentoDTO medicamentoDTO) {
        return medicamentoRepository.guardar(medicamentoDTO);
    }

    public MedicamentoDTO actualizarMedicamento(MedicamentoDTO medicamentoDTO) {
        return medicamentoRepository.update(medicamentoDTO);
    }

    public MedicamentoDTO buscar(Integer id) {
        return medicamentoRepository.buscar(id);
    }

    public String eliminar(Integer id) {
        return medicamentoRepository.eliminar(id);
    }
}

