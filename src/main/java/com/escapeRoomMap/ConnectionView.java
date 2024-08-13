package com.escapeRoomMap;

import org.springframework.beans.factory.annotation.Value;

public interface ConnectionView {

    int getId();

    @Value("#{target.nextRoom != null ? target.nextRoom.id : -1}")
    int getNextRoomId();

}
