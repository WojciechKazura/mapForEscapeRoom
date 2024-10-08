package com.escapeRoomMap;

import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

public interface ConnectionView {

    default Set<Integer> getConnections() {
       return Set.of(getFrom(),getTo());
    }

    @Value("#{target.id}")
    int getFrom();

    @Value("#{target.nextRoom.id}")
    int getTo();


}
