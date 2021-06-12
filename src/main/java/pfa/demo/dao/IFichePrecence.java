package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.FichePresence;

@Repository
public interface IFichePrecence extends JpaRepository<FichePresence, Long> {
}
