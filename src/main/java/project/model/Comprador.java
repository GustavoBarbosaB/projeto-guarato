package project.model;

import javax.persistence.*;

@Entity
public class Comprador {

    private String Nome;
    //Será PK
    @Id
    private String CPF;
    private Endereco End;

    protected Comprador(){}

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Endereco getEnd() {
        return End;
    }

    public void setEnd(Endereco end) {
        End = end;
    }
}
