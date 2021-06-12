package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Commentaire;

@Repository
public interface ICommentaire extends JpaRepository<Commentaire, Long> {
}
