package pfa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pfa.demo.model.Avis;

import java.util.List;

@Repository
public interface IAvis  extends JpaRepository<Avis, Long> {




        @Query("select f  from Avis f where f.formateurAvis.id=:idformateur")
        List<Avis> findAvisByFormateur(@Param("idformateur") Long id);

        @Query("select f  from Avis f where f.formation.id=:idformation")
        List<Avis> findAvisByFormation(@Param("idformation") Long id);
        @Query("select f  from Avis f where f.candidat.id=:idcondidat")
        List<Avis> findAvisByidcondidat(@Param("idcondidat") Long id);

    }


