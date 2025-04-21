package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.alura.tdd.modelo.Funcionario;

@TestInstance(Lifecycle.PER_CLASS)
class BonusServiceTest {

	@Test
	void bonusDeveSerZeroParaFuncionarioComSalarioAlto() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("Rafael", LocalDate.of(1989, 7, 1), new BigDecimal(23000));
		assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
	}

	@Test
	void bonusDeveSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Larissa", LocalDate.of(2017, 2, 15), new BigDecimal(2500)));
		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveSer10PorCentoParaSalarioDeDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Juninho", LocalDate.of(2019, 6, 1), new BigDecimal(10000)));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}