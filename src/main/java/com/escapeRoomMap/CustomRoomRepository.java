package com.escapeRoomMap;

import java.util.List;

public interface CustomRoomRepository {
    List<ConnectionDTO> getConnections(int gameId);
    List<Integer> getGameRooms();
}
