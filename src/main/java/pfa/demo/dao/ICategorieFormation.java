package pfa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.CategorieFormation;

@Repository
public interface ICategorieFormation extends JpaRepository<CategorieFormation, Long> {
}
