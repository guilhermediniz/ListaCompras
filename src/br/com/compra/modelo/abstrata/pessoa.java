package br.com.compra.modelo.abstrata;

import java.util.Date;

public abstract class pessoa {
      
		private Long id;
		private String nome;
		private Date nascimento;	
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}

		public void setName(String nome) {
			this.nome = nome;
		}

		public Date getNascimento() {
			return nascimento;
		}

		public void setNascimento(Date nascimento) {
			this.nascimento = nascimento;
		}	
	}