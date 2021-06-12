package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Materil;

@Repository
public interface IMateril extends JpaRepository<Materil, Long> {
}
