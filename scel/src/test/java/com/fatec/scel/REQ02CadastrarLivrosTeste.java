package com.fatec.scel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import com.fatec.scel.model.Livro;
import com.fatec.scel.ports.LivroRepository;

@SpringBootTest
class REQ02CadastrarLivrosTeste {

	@Autowired
	private LivroRepository repository;
	private Livro livro;
	private Validator validator;
	private ValidatorFactory validatorFactory;

	@Test
	void ct04_quando_isbn_ja_cadastrado_retornar_violacao_de_integridade() {
		// Dado – que o ISBN do livro ja está cadastrado
		repository.deleteAll();
		livro = new Livro("4444", "Teste de Software", "Delamaro");
		repository.save(livro);
		// Quando – o usuário registra as informações do livro e confirma a operação
		livro = new Livro("4444", "Teste de Software", "Delamaro");
		// Então – o sistema valida as informações E retorna violação de integridade.
		try {
			repository.save(livro);
		} catch (DataIntegrityViolationException e) {
			assertEquals("could not execute statement", e.getMessage().substring(0, 27));
			assertEquals(1, repository.count());
		}
	}
}
