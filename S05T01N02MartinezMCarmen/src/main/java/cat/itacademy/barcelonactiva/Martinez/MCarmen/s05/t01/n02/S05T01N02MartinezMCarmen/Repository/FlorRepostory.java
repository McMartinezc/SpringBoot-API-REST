package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Repository;

import cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Model.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepostory extends JpaRepository<Flor, Integer> {
}
