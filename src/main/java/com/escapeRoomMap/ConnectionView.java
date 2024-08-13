package com.escapeRoomMap;

import org.springframework.beans.factory.annotation.Value;

public interface ConnectionView {

    @Value("#{target.id}")
    int getFrom();

    @Value("#{target.nextRoom.id}")
    int getTo();

}
