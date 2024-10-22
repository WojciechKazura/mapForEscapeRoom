package com.escapeRoomMap;

public class ConnectionDTO {

    private int source;
    private int target;

    public ConnectionDTO(int source, int target) {
        this.source = source;
        this.target = target;
    }

    public ConnectionDTO() {

    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }




}
