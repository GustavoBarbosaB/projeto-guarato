package project.controller;

import org.springframework.validation.BindingResult;
import project.model.Comprador;
import org.springframework.web.bind.annotation.*;
import project.model.Endereco;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class CompradorController {

    //private final AtomicLong counter = new AtomicLong();
    private final List<Comprador> compradores = new ArrayList<>();

    @RequestMapping(value = "/comprador", method = GET)
    public List<Comprador> comprador(){
        return compradores;
    }


    /**

     * @param cpf (obrigatorio)
     * @param nome ( não obrigatorio)
     * @return retonar todos os compradores por cpf
     */
    @RequestMapping(value="/comprador/{cpf}",method = GET)
    public List<Comprador> comprador(@PathVariable("cpf") String cpf,@RequestParam(value="nome", required = false) String nome){

        List<Comprador> returnCompradores = new ArrayList<>();

        for(Comprador comprador:compradores)
        {
            /**
             * Testa se cpf e nome são iguais as passadas na URL
             * se for salva na lista de compradores a serem retornados
             */
            if(comprador.getCPF().equals(cpf) && comprador.getNome().equals(nome)){
            returnCompradores.add(comprador);
            }
        }

        return returnCompradores;
    }

    @RequestMapping(value="/addComprador", method = POST)
    public String addComprador(@RequestBody Comprador comprador, @RequestBody Endereco endereco, BindingResult result){

        if (result.hasErrors()) {
            return "error";
        }

        comprador.setEnd(endereco);

        compradores.add(comprador);

        return "OK";
    }


    @RequestMapping(value = "/removeComprador/{cpf}", method = DELETE)
    public String removeComprador(@PathVariable String cpf)
    {
        int i;
        for(i=0;i < compradores.size();i++)
        {
            if(compradores.get(i).getCPF().equals(cpf)) {
                compradores.remove(i);
                break;
            }
        }

        if(i==compradores.size())
            return "Not exist";

        return "OK removed";
    }

    @RequestMapping(value = "/changeComprador/{cpf}", method = PUT)
    public String changeCar(@RequestBody Comprador comprador, @PathVariable String cpf)
    {
        int i;
        for(i=0;i < compradores.size();i++)
        {
            if(compradores.get(i).getCPF() == cpf) {
                changeCarHelp(comprador,compradores.get(i));
                break;
            }
        }

        if(i==compradores.size())
            return "Not exist";

        return "OK changed";
    }



    private void changeCarHelp(Comprador newComprador, Comprador oldComprador)
    {
        if(newComprador.getNome() != null)
            oldComprador.setNome(newComprador.getNome());
        if(newComprador.getEnd() != null)
            oldComprador.setEnd(newComprador.getEnd());

    }

}
