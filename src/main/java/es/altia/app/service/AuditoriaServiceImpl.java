package es.altia.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.altia.app.entity.Auditoria;
import es.altia.app.repository.AuditoriaRepository;

@Service
public class AuditoriaServiceImpl implements AuditoriaService{
	
	@Autowired
	private AuditoriaRepository auditoriaRepository;

	@Override
	@Transactional
	public Iterable<Auditoria> findAll() {
		return auditoriaRepository.findAll();
	}

	@Override
	@Transactional
	public Page<Auditoria> findAll(Pageable pageable) {
		return auditoriaRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Optional<Auditoria> findById(Long id) {
		return auditoriaRepository.findById(id);
	}

	@Override
	@Transactional
	public Auditoria save(Auditoria auditoria) {
		return auditoriaRepository.save(auditoria);
	}

	@Override
	@Transactional
	public void update(Auditoria auditoria) {
		auditoriaRepository.save(auditoria);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		auditoriaRepository.deleteById(id);
	}

	@Override
	public List<Auditoria> listAll() {
		return auditoriaRepository.findAll();
	}

	@Override
	public List<Auditoria> findByOrderByOperationTimeDesc() {
		return auditoriaRepository.findByOrderByOperationTimeDesc();
	}

}
