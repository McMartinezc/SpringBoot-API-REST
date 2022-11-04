package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

//Afegim lombok per crear els constructors, getters i setters, toString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString

public class FlorDTO implements Serializable {

    private Integer id;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    //Metode per verificar si el pais pertany a la UE
    public String pertanyUE (String paisFlor) {
        List<String> FlorUE = List.of("Alemania","Austria","Bélgica","Bulgaria","Chipre","Croacia",
                "Dinamarca","Eslovaquia","Eslovenia","España","Estonia","Finlandia","Francia","Grecia","Hungría","Irlanda","Italia",
                "Letonia", "Lituania",  "Luxemburgo","Malta", "Paises Bajos", "Polonia", "Portugal", "República Checa",
                "Rumanía", "Suecia");

        Boolean encontrado = false;
        String tipusFlor = "";

        int i=0;

        while (i< FlorUE.size() && !encontrado) {

            if(FlorUE.get(i).equalsIgnoreCase(paisFlor)){
                tipusFlor = "UE";
                encontrado = true;
            }
            i++;
        }
        if(!encontrado){
            tipusFlor ="Fora UE";
        }
        return tipusFlor;
    }

}
