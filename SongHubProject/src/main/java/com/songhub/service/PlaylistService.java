package com.songhub.service;

import java.util.List;

import com.songhub.entity.Playlist;
import com.songhub.entity.Song;

public interface PlaylistService {


	void savePlaylist(Playlist playlist);

	List<Playlist> getAllPlaylist();
}
