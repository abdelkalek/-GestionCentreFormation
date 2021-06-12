package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.PaymentFormation;

@Repository
public interface IPayementFormation extends JpaRepository<PaymentFormation, Long> {
}
