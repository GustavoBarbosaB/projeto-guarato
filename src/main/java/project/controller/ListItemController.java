package project.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.model.item.ListItem;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

public class ListItemController {
    //private final AtomicLong counter = new AtomicLong();
    private final List<ListItem> listitens = new ArrayList<>();

    @RequestMapping(value = "/comprador", method = GET)
    public List<ListItem> listitem(){
        return listitens;
    }


    /**
     * @param id (obrigatorio)
     * @param qtd (obrigatorio)
     * @return retonar todos os itens pedidos
     */
    @RequestMapping(value="/comprador/{id}/{qtd}",method = GET)
    public List<ListItem> listitem(@PathVariable("id") int id,@PathVariable("qtd") int qtd){

        List<ListItem> returnListItem = new ArrayList<>();

        for(ListItem listitem:listitens)
        {

            if(listitem.getId() == id && listitem.getQtd() == qtd){
                returnListItem.add(listitem);
            }
        }

        return returnListItem;
    }

    @RequestMapping(value="/addListItem", method = POST)
    public String addListItem(@RequestBody ListItem listitem, BindingResult result){

        if (result.hasErrors()) {
            return "error";
        }
        listitens.add(listitem);

        return "OK";
    }


    @RequestMapping(value = "/removeListItem/{id}/{qtd}", method = DELETE)
    public String removeComprador(@PathVariable int id, @PathVariable int qtd)
    {
        int i;
        for(i=0;i < listitens.size();i++)
        {
            if(listitens.get(i).getId() == id) {
                listitens.remove(i);
                break;
            }
        }

        if(i==listitens.size())
            return "Not exist";

        return "OK removed";
    }

    @RequestMapping(value = "/changeListItem/{id}/{qtd}", method = PUT)
    public String changeCar(@RequestBody ListItem listitem, @PathVariable int id, @PathVariable int qtd)
    {
        int i;
        for(i=0;i < listitens.size();i++)
        {
            if(listitens.get(i).getId() == id && listitens.get(i).getQtd() == qtd ) {
                changeListItemHelp(listitem,listitens.get(i));
                break;
            }
        }

        if(i==listitens.size())
            return "Not exist";

        return "OK changed";
    }



    private void changeListItemHelp(ListItem newListItem, ListItem oldListItem)
    {
        if(newListItem.getId() != -1)
            oldListItem.setId(newListItem.getId());
        if(newListItem.getQtd() != -1)
            oldListItem.setId(newListItem.getQtd());

    }
}
