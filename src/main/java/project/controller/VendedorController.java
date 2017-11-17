package project.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import project.model.Vendedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class VendedorController {


    private final List<Vendedor> vendedores = new ArrayList<>();


    /**
     * Metodo para retornar todos os carros
     */

    @RequestMapping(value = "/vendedores", method = GET)
    public List<Vendedor> comprador(){
        return vendedores;
    }


    /**
     * @param cnpj (obrigatorio)
     * @param razaosocial (não obrigatorio)
     * @return retonar todos os vendedores por cnpj
     */
    @RequestMapping(value="/vendedor/{cnpj}",method = GET)
    public List<Vendedor> vendedor(@PathVariable("cnpj") String cnpj,@RequestParam(value="razaosocial", required = false) String razaosocial){

        List<Vendedor> returnVendedores = new ArrayList<>();

        for(Vendedor car:vendedores)
        {
            /**
             * Testa se a cor e a marca é igual as passadas na URL
             * se for salva na lista de carros a serem retornados
             */
            if(car.getCNPJ().equals(cnpj) && car.getRazaoSocial().equals(razaosocial)){
                returnVendedores.add(car);
            }
        }

        return returnVendedores;
    }

    @RequestMapping(value="/addVendedor", method = POST)
    public String addVendedor(@RequestBody Vendedor vendedor, BindingResult result){

        if (result.hasErrors()) {
            return "error";
        }

        vendedores.add(vendedor);
        return "OK";
    }


    @RequestMapping(value = "/removeVendedor/{cnpj}", method = DELETE)
    public String removeVendedor(@PathVariable String cnpj)
    {
        int i;
        for(i=0;i < vendedores.size();i++)
        {
            if(vendedores.get(i).getCNPJ().equals(cnpj)){
                vendedores.remove(i);
                break;
            }
        }

        if(i==vendedores.size())
            return "Not exist";

        return "OK removed";
    }

    @RequestMapping(value = "/changeVendedor/{cnpj}", method = PUT)
    public String changeVendedor(@RequestBody Vendedor vendedor, @PathVariable String cnpj)
    {
        int i;
        for(i=0;i < vendedores.size();i++)
        {
            if(vendedores.get(i).getCNPJ().equals(cnpj)) {
                changeVendedorHelp(vendedor,vendedores.get(i));
                break;
            }
        }

        if(i==vendedores.size())
            return "Not exist";

        return "OK changed";
    }

    private void changeVendedorHelp(Vendedor newVendedor, Vendedor oldVendedor)
    {
        if(newVendedor.getCNPJ() != null)
            oldVendedor.setCNPJ(newVendedor.getCNPJ());
        if(newVendedor.getRazaoSocial() != null)
            oldVendedor.setRazaoSocial(newVendedor.getRazaoSocial());

    }




}
