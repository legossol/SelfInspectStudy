package com.example.demo.associationfakeobject.player;

import com.example.demo.associationfakeobject.team.TeamService;
import java.security.InvalidParameterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements  PlayerService{

    private final PlayerRepository repository;
    private final TeamService teamService;
    @Override
    public void save(Long teamId, String name) {
        Player player = new Player();
        player.setName(name);
        player.setTeam(teamService.findTeam(teamId));
        repository.save(player);
    }
}
