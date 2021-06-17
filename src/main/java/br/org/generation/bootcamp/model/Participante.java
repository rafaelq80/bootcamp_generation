package br.org.generation.bootcamp.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity 
@Table(name = "tb_participante")
public class Participante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
	@Size(min = 1, max = 150, message = "O Nome deve ter no mínimo 1 caracter e no máximo 150 caracteres")
    private String nome;
    
    @Column(name = "datanascimento")
    private LocalDate dataNascimento;
    
    private String periodo;
    
    @Column(name = "tipocurso")
    private String tipoCurso;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacadastro")
    private Date dataCadastro = new java.sql.Date(System.currentTimeMillis());

}
