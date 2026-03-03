package com.hotking.pcbuilder.paginator;

import java.util.List;

public interface Paginator {

    default void paginate(Object result){

    }

    default Integer size(){
        return 0;
    }
}
