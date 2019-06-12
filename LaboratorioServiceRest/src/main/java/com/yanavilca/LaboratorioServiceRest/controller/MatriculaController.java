package com.yanavilca.LaboratorioServiceRest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yanavilca.LaboratorioServiceRest.model.Matricula;
import com.yanavilca.LaboratorioServiceRest.model.ResponseMessage;
import com.yanavilca.LaboratorioServiceRest.services.MatriculaService;

@RestController
public class MatriculaController {

	private static final String FILEPATH = "/var/data/matricula-api/images";

	@Autowired
	private MatriculaService matriculaService;

	@GetMapping("/matriculas")

	public List<Matricula> matriculas() {

		List<Matricula> matriculas = matriculaService.listar();

		return matriculas;
	}

	@GetMapping("/matriculas/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception {

		Resource resource = new UrlResource(Paths.get(FILEPATH).resolve(filename).toUri());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(FILEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength())).body(resource);
	}

	@PostMapping("/matriculas") // https://spring.io/guides/gs/uploading-files/
	public ResponseMessage crear(@RequestParam(name = "imagen", required = false) MultipartFile imagen,
			@RequestParam("tipo_solicitud") String tipo_solicitud, @RequestParam("solicitud") String solicitud,
			@RequestParam("correo") String correo) {

		Matricula matricula = new Matricula();
		matricula.setCorreo(correo);
		matricula.setTipo_solicitud(tipo_solicitud);
		matricula.setSolicitud(solicitud);

		if (imagen != null && !imagen.isEmpty()) {
			try {

				matricula.setImagen(imagen.getOriginalFilename());

				Files.copy(imagen.getInputStream(), Paths.get(FILEPATH).resolve(imagen.getOriginalFilename()));

			} catch (IOException e) {
			}

		}

		matriculaService.crear(matricula);

		return ResponseMessage.success("Registro completo");
	}

}
