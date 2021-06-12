package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Promotion;

@Repository

public interface IPromotion extends JpaRepository<Promotion, Long> {
}
