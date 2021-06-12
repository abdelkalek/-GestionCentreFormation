package pfa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Salle;

@Repository
public interface ISalle extends JpaRepository<Salle, Long> {
}
