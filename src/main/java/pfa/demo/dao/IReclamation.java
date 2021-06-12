package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Reclamation;

@Repository
public interface IReclamation extends JpaRepository<Reclamation, Long> {
}
