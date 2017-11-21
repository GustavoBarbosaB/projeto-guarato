package project.model;

import javax.persistence.Id;

public class Vendedor {

    private  String RazaoSocial;
    @Id
    private  String CNPJ;

    protected Vendedor(){}

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
