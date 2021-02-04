package test.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import test.domain.Domain;

@RepositoryRestResource(path = "domains")
public interface DomainJpaRepository extends JpaRepository<Domain, Integer> {

}
