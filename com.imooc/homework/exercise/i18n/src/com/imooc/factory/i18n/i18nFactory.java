package com.imooc.factory.i18n;
// 工厂类
public class i18nFactory {
    public static i18n getI18NObject(String area){
        if(area.equals("china")){
            return new Chinese();
        }
        else if(area.equals("spain")){
            return new Spanish();
        }
        else if(area.equals("italy")){
            return new Italy();
        }else{
            return null;
        }
    }
}
