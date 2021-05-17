package player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 播放列表集合
public class PlayListCollection {
    Map<String,PlayList> playListMap;
    public PlayListCollection(){
        playListMap = new HashMap<String,PlayList>();
    }
    // 向播放器添加播放列表
    public void addPlayList(PlayList playList){
        playListMap.put(playList.getPlayListName(), playList);
    }
    // 删除播放列表
    public void deletePlayList(PlayList playList){
        playListMap.remove(playList.getPlayListName());
        System.out.println("删除成功！");
    }
    // 查询
    public PlayList searchPlayListByName(String playListName){
        PlayList pl = null;
        Set<String> playListSet = playListMap.keySet();
        for(String s:playListSet){
            if(s.equals(playListName)){
                pl = playListMap.get(s);break;
            }
        }
        return pl;
    }

    public Map<String, PlayList> getPlayListMap() {
        return playListMap;
    }

    public void setPlayListMap(Map<String, PlayList> playListMap) {
        this.playListMap = playListMap;
    }

    // 显示
    public void displayListName(){
        Set<String> playListSet = playListMap.keySet();
        System.out.println("播放列表名称为");
        for(String s:playListSet){
            System.out.println(s);
        }
    }

    
}
