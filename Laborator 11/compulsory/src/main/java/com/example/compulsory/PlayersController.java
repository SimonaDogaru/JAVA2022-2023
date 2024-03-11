package com.example.compulsory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/players")

public class PlayersController {
    private  List<Player> players = new ArrayList<>();
    public PlayersController() {
        players.add(new Player(1, "Marin", "LOL"));
        players.add(new Player(2, "Simona", "Celest"));
        players.add(new Player(3, "Roxana", "WaterGirlFireBoy"));
    }
    @GetMapping
    public List<Player> getPlayers() {
        return players;
    }
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return players.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

}
