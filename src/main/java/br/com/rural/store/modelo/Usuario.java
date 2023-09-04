package br.com.rural.store.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_USUARIO")
public class Usuario {

    @Id
	@SequenceGenerator(name="usuarios", sequenceName ="sq_tb_usuario", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="usuarios")
    
    @Column(name = "CD_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO")
    private String nome;

    @Column(name = "DS_ENDERECO")
    private String endereco;

    @Column(name = "NR_TELEFONE")
    private String telefone;

    @Column(name = "DS_EMAIL")
    private String email;


    public Usuario() {
    }

    public Usuario(String nome, String endereco, String telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

    
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
