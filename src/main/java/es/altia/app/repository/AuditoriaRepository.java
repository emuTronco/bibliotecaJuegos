package es.altia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.altia.app.entity.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
	
	public List<Auditoria> findByOrderByOperationTimeDesc();

}
