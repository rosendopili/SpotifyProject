package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.Song;

public interface SongService {

    public Song createSongs(Song song);

    public Iterable<Song> listSongs();
}
