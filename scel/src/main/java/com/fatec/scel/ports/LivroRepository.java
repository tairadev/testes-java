package com.fatec.scel.ports;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.scel.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
	// @Query("SELECT l FROM Livro l WHERE l.isbn = :isbn")
	public Livro findByIsbn(@Param("isbn") String isbn);
}
