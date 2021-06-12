package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.BesoinMateril;

@Repository
public interface IBesoinMateril extends JpaRepository<BesoinMateril, Long> {
}
