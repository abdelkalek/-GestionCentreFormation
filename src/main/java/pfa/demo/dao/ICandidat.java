package pfa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Candidat;

@Repository
public interface ICandidat extends JpaRepository<Candidat, Long> {
}
