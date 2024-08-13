package com.escapeRoomMap;

public class ConnectionDTO {

    private int from;
    private int to;

    public ConnectionDTO(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public ConnectionDTO() {

    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }




}
