package com.example.springbootmonolith.controllers;

import com.example.springbootmonolith.models.Song;
import com.example.springbootmonolith.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SongsController {

  @Autowired
  private SongRepository songRepository;

  @GetMapping
  public List<Song> findAllSongs() {
    return new ArrayList<Song>();
  }

  @GetMapping("/songs/{songId}")
  public Optional<Song> findSongById(@PathVariable Long songId) {return  songRepository.findById(songId); }

  @DeleteMapping("/users/{songId}")
  public HttpStatus deleteSongById(@PathVariable Long songId) {
    songRepository.deleteById(songId);
    return HttpStatus.OK;
  }

  @PostMapping("/songs")
  public Song createNewSong(@RequestBody Song newSong) {
    return songRepository.save(newSong);
  }

  @PatchMapping("/songs/{songId}")
  public Song updateSongById(@PathVariable Long songId, @RequestBody Song songRequest) {

    Song songFromDb = songRepository.findById(songId).get();

    songFromDb.setSongTitle(songRequest.getSongTitle());
    songFromDb.setSongength(songRequest.getSongLength());

    return songRepository.save(songFromDb);
  }

}