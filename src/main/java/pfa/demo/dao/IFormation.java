package pfa.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Formation;

@Repository
public interface IFormation extends JpaRepository<Formation, Long> {

}
