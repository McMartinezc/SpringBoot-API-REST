package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Repository;

import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n01.S05T01N01MartinezMCarmen.Model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository <Sucursal, Integer> {

}
