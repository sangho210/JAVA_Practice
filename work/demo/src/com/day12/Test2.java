package com.day12;

//Map<키, 값> - Interface
//HashTable: Vector와 동일 - 동기화 O
//HashMap: Arraylist와 동일 - 동기화 X
//Map은 Iterator가 없다


import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class Test2 {

    public static final String[] tel =
            {"111-111","222-222","333-333","111-111","444-444"};

    public static final String[] name =
            {"슬기","수지","효린","주현","유리"};

    public static void main(String[] args) {

        Hashtable<String, String> hMap = new Hashtable<String, String>();

        for(int i=0; i<name.length; i++) {
            hMap.put(tel[i], name[i]);
        }
        System.out.println(hMap);

        String str = hMap.get("111-111");
        if(str!=null)
            System.out.println(str);
        else
            System.out.println("자료 없음");

        if(hMap.containsKey("222-222")) {
            System.out.println("존재: " + "key \"222-222\" value \"" + hMap.get("222-222") + "\"");
        } else {
            System.out.println("없음");
        }

        if(hMap.containsValue("수지")) {
            System.out.println("있음");
        } else {
            System.out.println("없음");
        }

        hMap.remove("222-222");
        System.out.println(hMap);

        Iterator<String> it = hMap.keySet().iterator();
        while(it.hasNext()) {
            String key = it.next();
            System.out.println(key + hMap.get(key));
        }

        //정석
        Iterator<Map.Entry<String, String>> it2 = hMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, String> entry = it2.next();

            // Remove entry if key is null or equals 0.
            if (entry.getKey() == null || entry.getKey().equals("")) {
                it2.remove();
            }
        }

    }

}
