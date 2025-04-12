package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Perfumaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Indica que essa interface é um componente de persistência (Spring Data)
public interface PerfumariaRepository extends JpaRepository<Perfumaria, Long> {
    // Ao estender JpaRepository, essa interface herda vários métodos prontos como:
    // save(), findById(), findAll(), deleteById(), entre outros

    // Não precisa declarar nada aqui se for usar apenas operações padrão
}

