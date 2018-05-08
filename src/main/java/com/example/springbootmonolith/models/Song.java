package com.example.springbootmonolith.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
@Table(name = "SONGS")
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "SONG_TITLE")
  private String songTitle;

  @Column(name = "SONG_LENGTH")
  private Double songLength;

}
