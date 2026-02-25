package com.hotking.pcbuilder.convertors;

import org.springframework.stereotype.Component;

@Component
public class VersionConvertor implements Convertor<String, String>{

    @Override
    public String convert(String object) {
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
