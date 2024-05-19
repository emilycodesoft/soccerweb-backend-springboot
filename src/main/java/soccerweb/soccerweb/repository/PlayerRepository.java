package soccerweb.soccerweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import soccerweb.soccerweb.model.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByDeletedFalse();
}
