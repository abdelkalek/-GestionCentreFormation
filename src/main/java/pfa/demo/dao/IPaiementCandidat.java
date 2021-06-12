package pfa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.PaiementCandidat;

@Repository
public interface IPaiementCandidat extends JpaRepository<PaiementCandidat, Long> {
}
