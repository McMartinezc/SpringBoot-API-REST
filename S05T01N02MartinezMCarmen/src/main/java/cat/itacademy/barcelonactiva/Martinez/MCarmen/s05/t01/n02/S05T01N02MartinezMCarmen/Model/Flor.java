package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Model;



import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

//Utilitxem anotacions de lombok per implementar getters i setters, constructor i toString
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Data

@Entity
@Table(name="flor")

public class Flor  {

    //Anotación personalizada para que aparezca en el swagger
    @ApiModelProperty(notes="Id s'autogenera", required = true)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ApiModelProperty(notes="Nom de la flor", required = true)
    private String nomFlor;

    @ApiModelProperty(notes="País de la flor", required = true)
    private String paisFlor;
}
