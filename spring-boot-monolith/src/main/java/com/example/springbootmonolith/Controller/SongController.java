package com.example.springbootmonolith.Controller;

import com.example.springbootmonolith.models.Song;
import com.example.springbootmonolith.service.SongService;
import com.example.springbootmonolith.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")

public class SongController {

    @Autowired
    SongService songService;

    @PostMapping
    public Song createSongs(@RequestBody Song song){
        return songService.createSongs(song);
    }

    @GetMapping("/list")
    public Iterable<Song> listSongs(){
        return songService.listSongs();
    }
}