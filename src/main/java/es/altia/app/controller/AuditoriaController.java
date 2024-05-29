package es.altia.app.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.altia.app.entity.Auditoria;
import es.altia.app.entity.User;
import es.altia.app.service.AuditoriaService;
import es.altia.app.service.UserService;

@Controller
public class AuditoriaController {
	
	// Con inyeccion de dependencias, podemos usar 'UserService' desde esta clase
		@Autowired
		private UserService userService;
		@Autowired
		private AuditoriaService auditoriaService;

		@RequestMapping(value = "/list-auditoria", method = RequestMethod.GET)
		public String showAllusers(ModelMap model) {
			
//			List<Auditoria> auditoriaList = auditoriaService.listAll();
//			Collections.reverse(auditoriaList);
			List<Auditoria> auditoriaList = auditoriaService.findByOrderByOperationTimeDesc();
			model.put("auditoriaList", auditoriaList);

			return "auditoria";
		}


		@RequestMapping(value = "/create-auditoria", method = RequestMethod.POST)
		public String createAuditoria(@ModelAttribute Auditoria auditoria, ModelMap model, RedirectAttributes redirectAttributes) {
				auditoriaService.save(auditoria);
				// Agrega los datos al objeto RedirectAttributes
				redirectAttributes.addFlashAttribute("mensajeExito", "Registro de auditoría añadido");
				return "redirect:/list-users";

		}
		
}
