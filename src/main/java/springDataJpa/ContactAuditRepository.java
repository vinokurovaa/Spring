package springDataJpa;

import org.springframework.data.repository.CrudRepository;


public interface ContactAuditRepository extends CrudRepository<ContactAudit, Long> {
}
