package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Service;

import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Exception.ItemNotFound;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Model.Flor;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Repository.FlorRepostory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorService {
    @Autowired
    private FlorRepostory florRepostory;

    @Autowired
    private ModelMapper modelMapper;

    //METODES CRUD

    //Metode per afegir flor a la BBDD
    public FlorDTO add (FlorDTO florDTO){
        //Convertim dto a entitat per poder guardarla a la BBDD
        Flor flor = convertDTOaEntitat(florDTO);
        Flor flor1= florRepostory.save(flor);
        //convertim entitat a dto per retorna al usuari
        return  convertEntitataDTO(flor1);
    }
    //Metode que mostrar una flor per id
    public FlorDTO getOne (Integer id){
        Optional<Flor> flor = florRepostory.findById(id);
        //Comprovem que existeixi aquesta id
        if(flor.isEmpty()){
            throw new ItemNotFound("No existeix aquesta flor amb la id:" +id);
        }
        //Convertim la entitat a dto per retornar al usuari
        FlorDTO florDTO =convertEntitataDTO(flor.get());
        return florDTO;
    }
    //Metode delete per id
    public void delete(Integer id){

        //Comprovem que existeixi aquesta id
       if(!florRepostory.existsById(id)){
           throw new ItemNotFound("No existeix aquesta flor amb la id:" +id);
       }
       florRepostory.deleteById(id);
    }
    //Metode modifica
    public FlorDTO update (Integer id, FlorDTO florDTO){
        FlorDTO florEdit = getOne(id);
        florEdit.setNomFlor(florDTO.getNomFlor());
        florEdit.setPaisFlor(florDTO.getPaisFlor());
        //Guardem els canvis i convetim dto a entitat per poder guardar-la
        florRepostory.save(convertDTOaEntitat(florEdit));
        florEdit.setTipusFlor(florDTO.pertanyUE(florDTO.getPaisFlor())); //Com es un atribut de DTO editem tipus flor
        return florEdit;
    }
    //Metode getAll, mostra tota la llista
    public List<FlorDTO> getAll(){
        List<Flor> llistatFlor = florRepostory.findAll();
        //Retornem llistat de flors mapejades convertides de entitat a dto a traves de stream
        return llistatFlor.stream()
                .map(flor -> convertEntitataDTO(flor))
                .collect(Collectors.toList());
    }
    //Metode que converteix entitat a dto
    public FlorDTO convertEntitataDTO(Flor flor){
        FlorDTO florDTO = new FlorDTO();
        florDTO.setId(flor.getId());
        florDTO.setNomFlor(flor.getNomFlor());
        florDTO.setPaisFlor(flor.getPaisFlor());
        florDTO.setTipusFlor(florDTO.pertanyUE(flor.getPaisFlor())); //Utilitzem el metode creat per verificar si el pais és de la UE o no
        return florDTO;
    }
    //Metode que converteix dto a entitat
    public Flor convertDTOaEntitat (FlorDTO florDTO){
        return  modelMapper.map(florDTO, Flor.class);
    }
}
