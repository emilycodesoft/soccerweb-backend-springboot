package soccerweb.soccerweb.controller;

import soccerweb.soccerweb.model.Player;
import soccerweb.soccerweb.model.User;
import soccerweb.soccerweb.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player, @RequestBody User user) {
        Player newPlayer = playerService.addPlayer(player, user);
        return ResponseEntity.ok(newPlayer);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        player.setId(id);
        Player updatedPlayer = playerService.updatePlayer(player);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}