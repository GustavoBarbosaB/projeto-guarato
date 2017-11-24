package project.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comprador")
public class Comprador  {

    private String Nome;

    @Id
    @Column(name="cpf_comprador")
    private String cpf;

    @Embedded
    private Endereco endereco;

    protected Comprador(){}

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public Endereco getEnd() {
        return endereco;
    }

    public void setEnd(Endereco end) {
        this.endereco = end;
    }
}
