package com.hotking.pcbuilder.parsers;

public interface Convertor <F, T>{

    T parse(F object);
}
