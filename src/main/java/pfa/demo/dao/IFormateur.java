package pfa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Formateur;

@Repository
public interface IFormateur extends JpaRepository<Formateur, Long> {
}
