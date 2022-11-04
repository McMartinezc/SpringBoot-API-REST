package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Controller;

import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    //Pagina principal, mostra llistat de sucursals
    @GetMapping(value={"/","/getAll"})
    public String viewHomePage(Model model) {
        model.addAttribute("llistaSucursals", sucursalService.getAll());
        return "index";
    }

    //Mostra Un
    @GetMapping("/getOne")
    public String getOneSucursal(Integer id, Model model){
        if(id !=null){ //Existeix sucursal la mostra
            model.addAttribute("llistaSucursals", sucursalService.getOne(id));

        }else{
            model.addAttribute("llistaSucursals", sucursalService.getAll()); //No existeix mostra tot
        }
        return "index";
    }

    //Pagina per afegir sucursal
    @GetMapping("/add")
    public String ShowAddSucursal (Model model){
        SucursalDTO sucursalDTO = new SucursalDTO();
        model.addAttribute("sucursal", sucursalDTO);
        return "new-sucursal";
    }
    //afegir Sucursal cridem al CRUD
    @PostMapping("/add")
    public String addSucursal(@ModelAttribute("sucursal") SucursalDTO sucursalDTO){
        sucursalService.add(sucursalDTO);
        return "redirect:/";
    }
    //Pagina per Editar sucursal
    @GetMapping("/update/{id}")
    public String ShowUpdateSucursal(Model model, @PathVariable Integer id){
        model.addAttribute("sucursal", sucursalService.getOne(id));
        return "update-sucursal";
    }
    //Update sucursal cridem al CRUD
    @PostMapping("/update/{id}")
    public String updateSucursal(@PathVariable Integer id, @ModelAttribute("sucursal") SucursalDTO sucursalDTO){
        sucursalService.update(sucursalDTO.getId(), sucursalDTO);
        return "redirect:/";
    }

    //Delete sucursal cridem al CRUD
    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") Integer id){
        sucursalService.delete(id);
        return "redirect:/";
    }

}
