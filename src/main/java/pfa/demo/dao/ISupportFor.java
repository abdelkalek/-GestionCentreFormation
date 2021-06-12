package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.SupportFor;

@Repository
public interface ISupportFor extends JpaRepository<SupportFor, Long> {
}
