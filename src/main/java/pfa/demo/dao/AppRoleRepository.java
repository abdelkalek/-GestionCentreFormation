package pfa.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pfa.demo.model.AppRole;

@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findByRoleName(String roleName);


}
