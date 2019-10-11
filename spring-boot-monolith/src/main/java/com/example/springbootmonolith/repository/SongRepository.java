package com.example.springbootmonolith.repository;

import com.example.springbootmonolith.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository <Song, Integer> {

}
