package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Service;

import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Exception.ItemNotFound;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Model.Sucursal;
import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Repository.SucursalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private ModelMapper modelMapper;

    //METODES CRUD

    //Metode getAll mostrarem al ususari llistat de sucursalDto, però la info la recull del repositori(BBDD). Convertim la entitat a dto.
    public List<SucursalDTO> getAll(){
        List<Sucursal> llistaSucursals = sucursalRepository.findAll();
        return llistaSucursals.stream()
                .map((sucursal)->convertEntitatADto(sucursal)).collect(Collectors.toList());
    }

    //Metode add usuari introdueix info per tant és un dto, pero al guardar a la BBDD s'ha de convertir en entitat. Al retornar la info a l'usuari torna com DTO
    public SucursalDTO add(SucursalDTO sucursalDTO){
        Sucursal sucursal = convertDtoAEntitat(sucursalDTO);
        Sucursal newSucursal = sucursalRepository.save(sucursal);
        return convertEntitatADto(newSucursal);
    }

    //Metod getOne, busca per id una entitat i la retorna al usuari com a dto.
    public SucursalDTO getOne(Integer id){

        Optional<Sucursal> sucursalOptional=sucursalRepository.findById(id);

        if(sucursalOptional.isEmpty()){
            throw new ItemNotFound("Sucursal amb id: "+id +" no existeix.");//Si no la troba salta una exception
        }

        SucursalDTO sucursalDTO = convertEntitatADto(sucursalOptional.get());

        return sucursalDTO;
    }

    //Metode update, usuari busca una sucursaldto i l'actualitza. Al actualitzar s'ha de modificar l'entitat per tant és realitza una conversió de dto a entitat. Al retornar a l'usuari serà la dto.
    public SucursalDTO update (Integer id, SucursalDTO sucursalDTO){
        SucursalDTO sucursalDTO1 = getOne(id); //Es busca amb la id la sucursal que és
        sucursalDTO1.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursalDTO1.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursalRepository.save(convertDtoAEntitat(sucursalDTO1)); //És converteix  a entitat i es guarda a la BBDD com entitat
        sucursalDTO.pertanyUE(sucursalDTO.getPaisSucursal());
        return sucursalDTO1;
    }
    //Metode delete
    public void delete(Integer id){
        sucursalRepository.deleteById(id);
    }


   public SucursalDTO convertEntitatADto (Sucursal sucursal){
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setId(sucursal.getId());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalDTO.setTipusSucursal(sucursalDTO.pertanyUE(sucursal.getPaisSucursal()));
        return sucursalDTO;
    }

    //Conversió de DTO a entitat
    public Sucursal convertDtoAEntitat (SucursalDTO sucursalDTO){
        return modelMapper.map(sucursalDTO, Sucursal.class);
    }


}
