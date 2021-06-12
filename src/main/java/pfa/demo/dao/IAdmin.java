package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Admin;


@Repository
public interface IAdmin  extends JpaRepository<Admin, Long> {
}
