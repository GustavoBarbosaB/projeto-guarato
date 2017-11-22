package project.model;

import javax.persistence.*;

@Entity
public class Comprador {

    private String Nome;

    @Id
    @Column(name="cpf_comprador")
    private String cpf;


    @JoinColumn(name="endereco")
    private Endereco End;

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
        return End;
    }

    public void setEnd(Endereco end) {
        End = end;
    }
}
