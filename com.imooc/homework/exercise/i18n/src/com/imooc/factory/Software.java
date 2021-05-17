package com.imooc.factory;

import com.imooc.factory.i18n.i18n;
import com.imooc.factory.i18n.i18nFactory;

public class Software {
    public static void main(String[] args) {
        i18n in = i18nFactory.getI18NObject("spain");
        System.out.println(in.getTitle());
    }
}
