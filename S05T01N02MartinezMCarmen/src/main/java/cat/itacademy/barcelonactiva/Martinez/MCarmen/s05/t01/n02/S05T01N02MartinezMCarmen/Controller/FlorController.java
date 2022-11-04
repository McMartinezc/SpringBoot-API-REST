package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Controller;

import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Service.FlorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/flor")
//Anotación swagger
@Api(value="CRUD Flor")
public class FlorController {
    @Autowired
    private FlorService florService;

    @GetMapping("/getAll")
    @ApiOperation(value="Mostrar totes les flors")//Anotación swagger
    public List<FlorDTO> getAllFlors(){
        return florService.getAll();
    }
    @GetMapping("/getOne/{id}")
    @ApiOperation(value="Mostra una flor per id")//Anotación swagger
    public ResponseEntity<FlorDTO> getOne(@PathVariable Integer id){
        return new  ResponseEntity<>(florService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ApiOperation(value="Afegeix una flor")//Anotación swagger
    public ResponseEntity<FlorDTO> add(@RequestBody FlorDTO florDTO){
        return new ResponseEntity<>(florService.add(florDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value="Actualitza una flor")//Anotación swagger
    public ResponseEntity<FlorDTO> update(@RequestBody FlorDTO florDTO, @PathVariable Integer id){
        return new ResponseEntity<>(florService.update(id, florDTO), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Borrar una flor per id")//Anotación swagger
    public ResponseEntity<FlorDTO> delete (@PathVariable Integer id){
        florService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
