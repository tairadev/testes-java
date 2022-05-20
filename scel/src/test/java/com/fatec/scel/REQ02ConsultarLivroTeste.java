package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.scel.model.Livro;
import com.fatec.scel.ports.LivroRepository;
@SpringBootTest
class REQ02ConsultarLivroTeste {

	@Autowired
	 LivroRepository repository;
	 @Test
	 void ct01_quando_consulta_isbn_cadastrado_retorna_os_dados_do_objeto_livro() {
	 // Dado – que o livro está cadastrado
	 repository.deleteAll();
	 Livro livro = new Livro("3333", "Teste de Software", "Delamaro");
	 repository.save(livro);
	 // Quando – o usuário consulta o livro pelo isbn
	 Livro ro = repository.findByIsbn("3333");
	 // Então – o resultado obtido da consulta ao db deve ser igual a do objeto java cadastrado
	 assertThat(ro).isEqualTo(livro);
	 } 


}
