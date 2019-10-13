package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springbootmonolith.repository.SongRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public Song createSongs (Song song){
        return songRepository.save(song);
    }

    @Override
    public Iterable<Song> listSongs(){
        return songRepository.findAll();
    }

    @Override
    public Song findBySongId(int songId){
        return songRepository.findById(songId).get();
    }

}
