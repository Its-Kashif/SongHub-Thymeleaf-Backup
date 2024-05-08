package com.songhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.songhub.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

	Song findByName(String name);

}
