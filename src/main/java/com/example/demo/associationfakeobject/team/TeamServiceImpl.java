package com.example.demo.associationfakeobject.team;

import com.example.demo.associationfakeobject.player.Player;
import com.example.demo.associationfakeobject.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;

    @Override
    public Team findTeam(Long teamId) {
        Team team = new Team();
        team.setId(teamId);
        return team;
    }
}
