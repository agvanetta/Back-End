package com.example2.consumiendoDelBack;

import com.example2.consumiendoDelBack.dto.MedicamentoDTO;
import com.example2.consumiendoDelBack.repository.impl.MedicamentoRepository;
import com.example2.consumiendoDelBack.service.MedicamentoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void guardar(){
		MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoRepository());
		MedicamentoDTO medicamentoDTO = medicamentoService.guardarMedicamento(new MedicamentoDTO("Ibuprofeno", "Pfizer", 500, 100.99 ));

		org.junit.Assert.assertNotNull(medicamentoDTO);
	}

}
