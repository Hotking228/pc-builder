package com.hotking.pcbuilder.convertors;

public interface Convertor <F, T>{

    T convert(F object);
}
