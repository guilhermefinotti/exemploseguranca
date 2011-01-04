package br.com.exemploseguranca.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


@Component("dataSource")
public class Conexao extends DriverManagerDataSource {
	
	public Conexao(){
		this.setDriverClassName("com.mysql.jdbc.Driver");
		this.setUrl("jdbc:mysql://localhost/seguranca");
		this.setUsername("root");
		this.setPassword("root");
	}
	
}
