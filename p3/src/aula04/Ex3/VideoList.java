package aula04.Ex3;

import java.util.ArrayList;

public class VideoList {
	
	private ArrayList<Video> videos = new ArrayList<>();
	
	public void addVideo(Video v) {
		videos.add(v);
	}
	
	public void removeVideo(Video v) {
		videos.remove(v);
	}
	
	public Video getVideoByID(int id) {
		for(Video v : getVideos()) {
			if(v.id() == id) return v;
		}
		throw new IllegalArgumentException();
	}
	
	public int size() {
		return videos.size();
	}
	
	public Video[] getVideos() {	
		return videos.toArray(new Video[size()]);
	}

}
