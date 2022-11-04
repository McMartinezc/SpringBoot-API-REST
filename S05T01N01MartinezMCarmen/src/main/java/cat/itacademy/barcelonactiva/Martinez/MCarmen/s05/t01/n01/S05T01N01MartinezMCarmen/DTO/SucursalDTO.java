package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.DTO;

import java.io.Serializable;
import java.util.List;


public class SucursalDTO implements Serializable {
    //Inclou només aquelles dades a la classe DTO requerida pel client. Els camps Entitat i DTO tenen el mateix aspecte, s'ha d'afegir camps obligatoris pel client.
        private Integer id;
        private String nomSucursal;
        private String paisSucursal;
        private String tipusSucursal;

    public SucursalDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }


    //Metode per verificar si el pais pertany a la UE
    public String pertanyUE (String paisSucursal) {
        List<String> paisosUE = List.of("Alemania","Austria","Bélgica","Bulgaria","Chipre","Croacia",
                "Dinamarca","Eslovaquia","Eslovenia","España","Estonia","Finlandia","Francia","Grecia","Hungría","Irlanda","Italia",
                "Letonia", "Lituania",  "Luxemburgo","Malta", "Países Bajos", "Polonia", "Portugal", "República Checa",
                "Rumanía", "Suecia");

        Boolean encontrado = false;
        String tipusSucursal = "";

        int i=0;

        while (i< paisosUE.size() && !encontrado) {

            if(paisosUE.get(i).equalsIgnoreCase(paisSucursal)){
                tipusSucursal = "UE";
                encontrado = true;
            }
            i++;
        }
        if(!encontrado){
            tipusSucursal ="No UE";
        }
        return tipusSucursal;
    }

    @Override
    public String toString() {
        return "SucursalDTO{" +
                "id=" + id +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                ", tipusSucursal='" + tipusSucursal + '\'' +
                '}';
    }
}
