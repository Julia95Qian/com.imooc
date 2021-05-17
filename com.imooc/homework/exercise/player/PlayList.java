package player;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private String playListName; // 播放列表名称
    private List<Song> musicList;

    public PlayList(String playListName){
        this.playListName = playListName;
        musicList = new ArrayList<Song>();
    }
    
    public void addToPlayList(Song song){
        // 排除重复添加的情况
        boolean flag = false;
        for(Song song1:musicList){
            if(song1.equals(song)){
                flag = true;break;
            }
        }
        if(flag){
            System.out.println("该歌曲已存在，添加失败。");
        }
        else{
            musicList.add(song);
        }
    }
    // 搜索
    public Song searchSongById(String id){
        Song song = null;
        // id唯一
        for(Song song1:musicList){
            if(song1.getId().equals(id)){
                song = song1;break;
            }
        }
        return song;
    }
    public Song searchSongByName(String name){
        Song song = null;
        for(Song song1:musicList){
            if(song1.getName().equals(name)){
                song = song1;break;
            }
        }
        return song;
    }

    // 修改播放列表中的歌曲信息
    public void updateSong(String id, Song song){
        Song song1 = searchSongById(id);
        if(song1 == null){
            System.out.println("没有找到id为"+id+"的歌曲信息");
        }
        else{
            musicList.remove(song1);
            musicList.add(song);
            System.out.println("修改成功！");
        }
    }
    // 删除
    public void deleteSong(String id){
        Song song = searchSongById(id);
        if(song!=null){
            musicList.remove(song);
        }else{
            System.out.println("没有找到id为"+id+"的歌曲信息");
        }
    }


    // 显示所有歌曲
    public void displayAllSong(){
        System.out.println("播放列表中的所有歌曲为：");
        for(Song song:musicList){
            System.out.println(song);
        }
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Song> musicList) {
        this.musicList = musicList;
    }
}
