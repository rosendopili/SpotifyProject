package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.Song;
import org.springframework.stereotype.Service;

@Service
public interface SongService {

    public Song createSongs(Song song);

    public Iterable<Song> listSongs();

    public Song findBySongId(int songId);
}
