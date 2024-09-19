package es.altia.app.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oracle.wls.shaded.org.apache.bcel.generic.SWITCH;

import es.altia.app.entity.Auditoria;
import es.altia.app.entity.Auditoria.userTypeInfo;
import es.altia.app.entity.User;
import es.altia.app.service.AuditoriaService;
import es.altia.app.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Controller
public class UserController {

	// Con inyeccion de dependencias, podemos usar 'UserService' desde esta clase
	@Autowired
	private UserService userService;
	@Autowired
	private AuditoriaService auditoriaService;
	@Autowired
	private MessageSource messageSource;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss | dd/MM/yyyy ");

	private Auditoria registroAuditoria(Long id, ModelMap model, Auditoria.operationType tipoOperacion,
			String detallesOperacion) {
		datosLogin(model);
		String nombreUsuario = (String) model.getAttribute("name");
		Auditoria.userTypeInfo tipoUsuario = (userTypeInfo) model.getAttribute("rolUsuario");
		Auditoria crearUsuario = new Auditoria(tipoOperacion, id, nombreUsuario, tipoUsuario, new java.util.Date(),
				detallesOperacion);
		return crearUsuario;
	}

	@RequestMapping(value = "/list-users", method = RequestMethod.GET)
	public String showAllusers(ModelMap model) {
		datosLogin(model);
		model.put("userList", userService.findAll());

		return "userList";
	}

	private void datosLogin(ModelMap model) {
		final String nombreUsuario = getLoggedInUserName(model);

		Auditoria.userTypeInfo rolUsuario;
		switch (nombreUsuario) {
			case "admin@admin":
				rolUsuario = userTypeInfo.ADMIN;
				break;
			case "update@update":
				rolUsuario = userTypeInfo.UPDATE_USER;
				break;
			case "delete@delete":
				rolUsuario = userTypeInfo.DELETE_USER;
				break;
			default:
				rolUsuario = userTypeInfo.USER;
		}
		model.put("rolUsuario", rolUsuario);
		model.put("name", nombreUsuario);
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.GET)
	public String createUser(ModelMap model) {
		model.put("titulo", getMessageSource("tituloCrear.message"));
		model.put("formulario", "/create-user");

		return "create&updateUser";
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user, ModelMap model, RedirectAttributes redirectAttributes) {
		if (user != null) {
			System.out.println(user.getEmail() + " " + user.getName() + " " + user.getSurname());
		} else {
			System.out.println("Usuario vacío");
		}
		// User userBBDD = userService.findByEmail(user.getEmail());
		// if (null != userBBDD && null != userBBDD.getEmail() &&
		// !userBBDD.getEmail().isEmpty()) {
		if (existeEmail(user.getEmail())) {
			model.put("mensajeError", getMessageSource("errorEmail.message"));
			model.put("titulo", getMessageSource("tituloCrear.message"));
			model.put("formulario", "/create-user");
			return "create&updateUser";
		} else {
			userService.save(user);
			Auditoria crearUsuario = registroAuditoria(user.getId(), model, Auditoria.operationType.CREATE,
					"Creacion del nuevo usuario " + user.getName() + " " + user.getSurname());
			auditoriaService.save(crearUsuario);
			// Agrega los datos al objeto RedirectAttributes
			redirectAttributes.addFlashAttribute("mensajeExito", getMessageSource("exitoCreado.message"));
			return "redirect:/list-users";

		}

	}

	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String updateUserPage(@RequestParam long id, ModelMap model) {
		model.put("titulo", getMessageSource("tituloActualizar.message"));
		model.put("formulario", "/update-user/" + id);
		User user = userService.findById(id).get();
		model.put("user", user);

		return "create&updateUser";
	}

	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
	public String updateUser(@PathVariable long id, @ModelAttribute User user, ModelMap model,
			RedirectAttributes redirectAttributes) {
		/*
		 * if (result.hasErrors()) { return "user"; }
		 */

		if (!(user != null && (user.getName().length() >= 3 && user.getName().length() <= 20))) {
			model.put("mensajeError", getMessageSource("errorLongitud.message"));
			model.put("titulo", getMessageSource("tituloActualizar.message"));
			model.put("formulario", "/update-user/" + user.getId());
			return "create&updateUser";

		}
		User u = userService.findById(id).get();

		if (existeEmail(user.getEmail()) && !user.getEmail().equals(u.getEmail())) {
			model.put("mensajeError", getMessageSource("errorEmail.message"));
			model.put("titulo", getMessageSource("tituloActualizar.message"));
			model.put("formulario", "/update-user/" + user.getId());
			return "create&updateUser";
		}
		user.setId(id);
		userService.update(user);
		Auditoria actualizarUsuario = registroAuditoria(user.getId(), model, Auditoria.operationType.UPDATE,
				"Actualización del usuario " + user.getName() + " " + user.getSurname());
		auditoriaService.save(actualizarUsuario);
		redirectAttributes.addFlashAttribute("mensajeExito", getMessageSource("exitoActualizado.message"));
		return "redirect:/list-users";
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(@RequestParam String id, RedirectAttributes redirectAttributes,
			@ModelAttribute ModelMap model) {
		Long id_long = Long.parseLong(id);
		String nombreUsuario = userService.findById(id_long).get().getName();
		String apellidoUsuario = userService.findById(id_long).get().getSurname();
		userService.deleteById(id_long);
		Auditoria eliminarUsuario = registroAuditoria(id_long, model, Auditoria.operationType.DELETE,
				"Eliminación del usuario " + nombreUsuario + " " + apellidoUsuario);
		auditoriaService.save(eliminarUsuario);
		redirectAttributes.addFlashAttribute("mensajeExito", getMessageSource("exitoBorrado.message"));
		return "redirect:/list-users";
	}

	@GetMapping("/login")
	public String login(ModelMap model) {
		return "login";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap model) {
		model.put("name", getLoggedInUserName(model));
		model.put("userList", userService.findAll());
		return "userList";
	}

	@RequestMapping(value = "/download-csv", method = RequestMethod.GET)
	public void descargaCSV(HttpServletResponse response) {
		Iterator<User> listaUsuarios = userService.findAll().iterator();
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"user_data.csv\"");
		try {
			CSVPrinter csvPrinter = new CSVPrinter(response.getWriter(), CSVFormat.DEFAULT);
			csvPrinter.printRecord("ID", "Nombre", "Apellido", "Email", "Habilitado");
			while (listaUsuarios.hasNext()) {
				User u = listaUsuarios.next();
				csvPrinter.printRecord(u.getId().toString(), u.getName(), u.getSurname(), u.getEmail(),
						u.getEnabled().toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean existeEmail(String email) {
		User userBBDD = userService.findByEmail(email);
		return (null != userBBDD && null != userBBDD.getEmail() && !userBBDD.getEmail().isEmpty());
	}

	// @Bean
	// public MessageSource messageSource() {
	// ReloadableResourceBundleMessageSource messageSource
	// = new ReloadableResourceBundleMessageSource();
	//
	// messageSource.setBasename("classpath:messages");
	// messageSource.setDefaultEncoding("UTF-8");
	// return messageSource;
	// }
	//
	// @Bean
	// public LocalValidatorFactoryBean getValidator() {
	// LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	// bean.setValidationMessageSource(messageSource());
	// return bean;
	// }

	private String getMessageSource(String mensaje) {
		return messageSource.getMessage(mensaje, null, LocaleContextHolder.getLocale());
	}

}
