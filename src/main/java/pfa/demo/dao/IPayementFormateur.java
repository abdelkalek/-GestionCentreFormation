package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.PayementFormateur;

@Repository
public interface IPayementFormateur extends JpaRepository<PayementFormateur, Long> {
}
