package com.escapeRoomMap;

import java.util.List;

public interface CustomRoomRepository {
    List<ConnectionView> getConnections(int gameId);
    List<Integer> getGameRooms();
}
