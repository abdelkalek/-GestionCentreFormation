package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.EmploiTemps;

@Repository
public interface IEmploi extends JpaRepository<EmploiTemps, Long> {
}
