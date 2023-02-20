package api.msvacina.repository;

import api.msvacina.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {


    Optional<Vacina> findByNome(String nome);

    boolean existsByNome(String nome);
}
