package com.escapeRoomMap;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomRoomRepositoryImpl implements CustomRoomRepository{

    private JdbcTemplate jdbcTemplate;

    public CustomRoomRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ConnectionView> getConnections(int gameId){
       return jdbcTemplate.query("select * from Room r where r.game.id = "+gameId, new MyRowMapper());
    }
//todo
    @Override
    public List<Integer> getGameRooms() {
        return List.of();
    }


    static class MyRowMapper implements RowMapper<ConnectionView>{

        @Override
        public ConnectionView mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ConnectionDTO(rs.getInt("NEXT_ROOMS_ID"),rs.getInt("ROOM_ID"));

        }
    }


}
