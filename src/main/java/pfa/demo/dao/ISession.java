package pfa.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Session;

import java.util.List;

@Repository
public interface ISession extends JpaRepository<Session, Long> {
    @Query("select f  from Session f where f.formateur.id=:idformateur")
    List<Session> findSessionByFormateur(@Param("idformateur") Long id);
//    @Query("select s from Session  s where s.formateur=:formateur")
//    List<Session> findSessionByFormateur(@Param("formateur") Formateur formateur);
}
