package es.altia.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.altia.app.entity.Auditoria;

public interface AuditoriaService {
	
	public Iterable<Auditoria> findAll();
	
	public Page<Auditoria> findAll(Pageable pageable);
	
	public List<Auditoria> listAll();
	
	public Optional<Auditoria> findById(Long id);
	
	public Auditoria save(Auditoria auditoria);
	
	public void update(Auditoria auditoria);
	
	public void deleteById(Long id);
	
	public List<Auditoria> findByOrderByOperationTimeDesc();

}
