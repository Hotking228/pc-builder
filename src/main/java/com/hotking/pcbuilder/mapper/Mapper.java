package com.hotking.pcbuilder.mapper;

public interface Mapper <F, T>{

    T map(F object);

    default T map(F object, T entity) {
        return entity;
    }
}
