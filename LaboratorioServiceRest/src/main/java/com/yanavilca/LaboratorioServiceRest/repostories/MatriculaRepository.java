package com.yanavilca.LaboratorioServiceRest.repostories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yanavilca.LaboratorioServiceRest.model.Matricula;

@Repository
public class MatriculaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Matricula> listar() {

		String sql = "select * from matricula";
		
		List<Matricula> matriculas = jdbcTemplate.query(sql, new RowMapper<Matricula>() {
			public Matricula mapRow(ResultSet rs, int rowNum) throws SQLException {
				Matricula matricula = new Matricula();
				matricula.setId(rs.getLong("id"));
				matricula.setTipo_solicitud(rs.getString("tipo_solicitud"));
				matricula.setSolicitud(rs.getString("solicitud"));
				matricula.setImagen(rs.getString("imagen"));
				matricula.setCorreo(rs.getString("correo"));
				return matricula;
			}
		});
		
		return matriculas;

	}
	
	public void crear(Matricula matricula) {
		
		String sql = "insert into matricula (tipo_solicitud,solicitud,imagen,correo) values (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, matricula.getTipo_solicitud(), matricula.getSolicitud(), matricula.getImagen(), matricula.getCorreo());
	}


}
