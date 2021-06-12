package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Person;

@Repository
public interface Iperson extends JpaRepository<Person, Long> {
     public Person findByUsername(String username);
}
