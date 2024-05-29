package es.altia.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.altia.app.entity.Auditoria;
import es.altia.app.service.AuditoriaService;
import es.altia.app.service.UserService;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaApiController {
	
	//Con inyeccion de dependencias, podemos usar 'UserService' desde esta clase
	@Autowired
	private AuditoriaService auditoriaService;
	
	//Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Auditoria auditoria) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(auditoriaService.save(auditoria));
	}
	
	//Read
	@GetMapping("/{id}")
	//public ResponseEntity<?> read(@PathVariable Long id) {
	public ResponseEntity<?> read(@PathVariable(value = "id") Long auditoriaId) {
		Optional<Auditoria> auditoria = auditoriaService.findById(auditoriaId);
		
		if(!auditoria.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(auditoria);
	}
	
	
	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Auditoria auditoriaDetails, @PathVariable(value = "id") Long auditoriaId) {
		Optional<Auditoria> auditoria = auditoriaService.findById(auditoriaId);
		
		if(!auditoria.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//user.get().setId(userId);
		auditoria.get().setOperationType(auditoriaDetails.getOperationType());
		auditoria.get().setUserName(auditoriaDetails.getUserName());
		auditoria.get().setUserTypeInfo(auditoriaDetails.getUserTypeInfo());
		auditoria.get().setIDuser(auditoriaDetails.getIDuser());
		
		
		/*Con esta opcion, se copiarian todas las porpiedades, incluido el ID, 
		 * que en este caso no nos interesa
		 */
		//BeanUtils.copyProperties(auditoriaDetails, auditoria.get());
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(auditoriaService.save(auditoria.get()));
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long auditoriaId) {
		if(!auditoriaService.findById(auditoriaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		auditoriaService.deleteById(auditoriaId);
		return ResponseEntity.ok().build();
	}
	
	//Read all
	@GetMapping()
	public List<Auditoria> readAll() {
		
		List<Auditoria> auditoriaList = StreamSupport
				.stream(auditoriaService.findAll().spliterator(), false) //false = secuencial
				.collect(Collectors.toList());
		
		return auditoriaList;
		
	}
	

}
