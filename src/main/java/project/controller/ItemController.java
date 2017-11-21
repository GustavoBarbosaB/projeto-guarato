package project.controller;


import org.springframework.validation.BindingResult;
import project.model.Comprador;
import org.springframework.web.bind.annotation.*;
import project.model.item.Item;
import java.util.concurrent.atomic.AtomicLong;

import java.util.ArrayList;
import java.util.List;



import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ItemController {

    private final AtomicLong counter = new AtomicLong();
    private final List<Item> itens = new ArrayList<>();

    @RequestMapping(value = "/item", method = GET)
    public List<Item> item(){
        return itens;
    }


    /**
     * @param id (obrigatorio)
     * @return retonar todos os itens por id
     */
    @RequestMapping(value="/item/{id}",method = GET)
    public List<Item> item(@PathVariable("id") int id){

        List<Item> returnItens = new ArrayList<>();

        for(Item item: itens)
        {

            if(item.getId() == id){
                returnItens.add(item);
            }
        }

        return returnItens;
    }

    @RequestMapping(value="/addItem", method = POST)
    public String addItem(@RequestBody Item item, BindingResult result){

        if (result.hasErrors()) {
            return "error";
        }
        item.setId((int) counter.incrementAndGet());
        itens.add(item);

        return "OK";
    }


    @RequestMapping(value = "/removeItem/{id}", method = DELETE)
    public String removeItem(@PathVariable int id )
    {
        int i;
        for(i=0;i < itens.size();i++)
        {
            if(itens.get(i).getId() == id) {
                itens.remove(i);
                break;
            }
        }

        if(i==itens.size())
            return "Not exist";

        return "OK removed";
    }

    @RequestMapping(value = "/changeItem/{id}", method = PUT)
    public String changeItem(@RequestBody Item item, @PathVariable int id)
    {
        int i;
        for(i = 0; i < itens.size() ;i++)
        {
            if(itens.get(i).getId() == id) {
                changeItemHelp(item,itens.get(i));
                break;
            }
        }

        if(i==itens.size())
            return "Not exist";

        return "OK changed";
    }



    private void changeItemHelp(Item newItem, Item oldItem)
    {
        if(newItem.getId() != -1)
            oldItem.setId(newItem.getId());
        if(newItem.getDesc() != null)
            oldItem.setDesc(newItem.getDesc());
        if(newItem.getVal() != -1)
            oldItem.setVal(newItem.getVal());
    }
}
