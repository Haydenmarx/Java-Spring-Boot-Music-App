package com.example.springbootmonolith.controllers;

import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class SongsController {

  @Autowired
  private UserRepository songRepository;

  @GetMapping
  public List<Song> findAllSongs() {
    return new ArrayList<Song>();
  }

  @GetMapping("/users/{userId}")
  public Optional<Song> findUserById(@PathVariable Long userId) {
    return songRepository.findById(userId);
  }

  @DeleteMapping("/users/{userId}")
  public HttpStatus deleteUserById(@PathVariable Long userId) {
    songRepository.deleteById(userId);
    return HttpStatus.OK;
  }

  @PostMapping("/users")
  public Song createNewUser(@RequestBody User newUser) {
    return songRepository.save(newUser);
  }

  @PatchMapping("/users/{userId}")
  public Song updateUserById(@PathVariable Long userId, @RequestBody User userRequest) {

    Song userFromDb = userRepository.findById(userId).get();

    songFromDb.setUserName(userRequest.getUserName());
    songFromDb.setFirstName(userRequest.getFirstName());
    songFromDb.setLastName(userRequest.getLastName());

    return songRepository.save(userFromDb);
  }

}