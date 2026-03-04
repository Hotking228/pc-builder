package com.hotking.pcbuilder.parsers;

import org.springframework.stereotype.Component;

@Component
public class VersionParser implements Convertor<String, String>{

    @Override
    public String parse(String object) {
        int l = 0;
        int r = 0;
        StringBuilder sb = new StringBuilder();
        while(r < object.length()){
            if(object.charAt(r) == '.'){
                sb.append(object, l, r);
                l = r + 1;
            }
            r++;
        }

        sb.append(object, l, r);

        return sb.toString();
    }
}
