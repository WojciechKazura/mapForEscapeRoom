package com.escapeRoomMap;

public class ConnectionDTO implements ConnectionView {

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


    @Override
    public int getFrom() {
        return getSource();
    }

    @Override
    public int getTo() {
        return getTarget();
    }
}
