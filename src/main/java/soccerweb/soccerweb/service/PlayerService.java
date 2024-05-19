package soccerweb.soccerweb.service;

import soccerweb.soccerweb.model.Player;
import soccerweb.soccerweb.model.User;
import soccerweb.soccerweb.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private UserService userService;

    public Player addPlayer(Player player, User user) {
        userService.addUser(user);
        player.setUser(user);
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findByDeletedFalse();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id).filter(player -> !player.isDeleted());
    }

    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.findById(id).ifPresent(player -> {
            player.setDeleted(true);
            playerRepository.save(player);
        });
    }
}