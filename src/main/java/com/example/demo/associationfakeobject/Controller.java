package com.example.demo.associationfakeobject;

import com.example.demo.associationfakeobject.player.PlayerService;
import com.example.demo.associationfakeobject.team.Team;
import com.example.demo.associationfakeobject.team.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {
    private final PlayerService playerService;

    @PostMapping("/save/{teamId}")
    public void saveUsingFakeEntity(@PathVariable Long teamId,@RequestParam String name) {
        playerService.save(teamId, name);
    }
}
