package com.example.scheduleexam_swp_team1.service;

import com.example.scheduleexam_swp_team1.model.Room;
import com.example.scheduleexam_swp_team1.interFaceService.RoomInterFaceService;
import com.example.scheduleexam_swp_team1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements RoomInterFaceService {
    @Autowired
    private RoomRepository RoomRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int creatRoom(Room Room) {
        return jdbcTemplate.update(" insert into Room (room_id,place,roomname) values (?,?,?)", new Object[]{Room.getId(), Room.isPlace(), Room.getRoomname()});
    }

    @Override
    public boolean deleteRoom(long id) {
        if (id >= 1) {
            Room Room = RoomRepository.getById(id);
            if (Room != null) {
                RoomRepository.delete(Room);
                return true;
            }
        }

        return false;
    }

    @Override
    public Room getRoomByID(long id) {
        return RoomRepository.getById(id);
    }

    @Override
    public List<Room> getListRoom() {
        return RoomRepository.findAll();
    }

    @Override
    public int updateRoom(long id, Room Room) {
        String sql = "UPDATE Room SET place = ?, roomname = ? WHERE room_id = ?";
        Object[] params = {Room.isPlace(), Room.getRoomname(), id};
        int rowsAffected = jdbcTemplate.update(sql, params);

        return rowsAffected;
    }

}
