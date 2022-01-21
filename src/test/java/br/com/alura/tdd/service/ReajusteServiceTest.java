package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

@TestInstance(Lifecycle.PER_CLASS)
class ReajusteServiceTest {

	private ReajusteService service;

	private Funcionario funcionario;

	@BeforeEach
	void inicializar() {
		service = new ReajusteService();
		funcionario = new Funcionario("Maria", LocalDate.now(), new BigDecimal(1000));
	}

	@Test
	void reajusteDeveriaSerDe3PorCentroQuandoDesempenhoForRuim() {
		service.calcular(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDe15PorCentroQuandoDesempenhoForBom() {
		service.calcular(funcionario, Desempenho.BOM);		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveriaSerDe20PorCentroQuandoDesempenhoForOtimo() {
		service.calcular(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
}