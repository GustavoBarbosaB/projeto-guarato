package project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @Column(name = "cnpj_vendedor")
    private  String cnpj;

    @NotNull
    private  String razaoSocial;

    protected Vendedor(){}

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String CNPJ) {
        this.cnpj = CNPJ;
    }
}
