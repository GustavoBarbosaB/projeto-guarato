package project.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.*;

public class PedidoController {

    private final AtomicLong counter = new AtomicLong();
    private final List<Pedido> pedidos = new ArrayList<>();

    @RequestMapping(value = "/pedido", method = GET)
    public List<Pedido> pedido(){
        return pedidos;
    }


    /**
     * @param id (obrigatorio)
     * @return retonar todos pedidos por id
     */
    @RequestMapping(value="/item/{id}",method = GET)
    public List<Pedido> pedido(@PathVariable("id") int id){

        List<Pedido> returnPedidos = new ArrayList<>();

        for(Pedido pedido: pedidos)
        {

            if(pedido.getId() == id){
                returnPedidos.add(pedido);
            }
        }

        return returnPedidos;
    }

    @RequestMapping(value="/addPedido", method = POST)
    public String addPedido(@RequestBody Pedido pedido, BindingResult result){

        if (result.hasErrors()) {
            return "error";
        }
        pedido.setId((int) counter.incrementAndGet());
        pedidos.add(pedido);

        return "OK";
    }


    @RequestMapping(value = "/removePedido/{id}", method = DELETE)
    public String removePedido(@PathVariable int id )
    {
        int i;
        for(i=0;i < pedidos.size();i++)
        {
            if(pedidos.get(i).getId() == id) {
                pedidos.remove(i);
                break;
            }
        }

        if(i==pedidos.size())
            return "Not exist";

        return "OK removed";
    }

    @RequestMapping(value = "/changePedido/{id}", method = PUT)
    public String changePedido(@RequestBody Pedido pedido, @PathVariable int id)
    {
        int i;
        for(i = 0; i < pedidos.size() ;i++)
        {
            if(pedidos.get(i).getId() == id) {
                changePedidoHelp(pedido,pedidos.get(i));
                break;
            }
        }

        if(i==pedidos.size())
            return "Not exist";

        return "OK changed";
    }



    private void changePedidoHelp(Pedido newPedido, Pedido oldPedido)
    {
        if(newPedido.getId() != -1)
            oldPedido.setId(newPedido.getId());
        if(newPedido.getComprador() != oldPedido.getComprador())
            oldPedido.setComprador(newPedido.getComprador());
        if(newPedido.getVendedor() != oldPedido.getVendedor())
            oldPedido.setVendedor(newPedido.getVendedor());

    }
}
