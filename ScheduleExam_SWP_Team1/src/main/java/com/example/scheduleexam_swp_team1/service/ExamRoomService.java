package com.example.scheduleexam_swp_team1.service;

import com.example.scheduleexam_swp_team1.model.ExamRoom;
import com.example.scheduleexam_swp_team1.interFaceService.ExamRoomInterFaceService;
import com.example.scheduleexam_swp_team1.repository.ExamRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamRoomService implements ExamRoomInterFaceService {
    @Autowired
    private ExamRoomRepository examRoomRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int creatExamRoom(ExamRoom examRoom) {


            return jdbcTemplate.update(" insert into examroom (room_id,place,roomname) values (?,?,?)", new Object[]{examRoom.getId(),examRoom.isPlace(),examRoom.getRoomname()});


    }

    @Override
    public boolean deleteExamRoom(long id) {
        if (id>=1){
            ExamRoom examRoom=examRoomRepository.getById(id);
            if(examRoom!=null){
                examRoomRepository.delete(examRoom);
                return true;
            }
        }

        return false;
    }

    @Override
    public ExamRoom getRoomByID(long id) {
        return examRoomRepository.getById(id);
    }

    @Override
    public List<ExamRoom> getListRoom() {
        return examRoomRepository.findAll();
    }

    @Override
    public int updateExamRoom(long id, ExamRoom examRoom) {
        String sql = "UPDATE examroom SET place = ?, roomname = ? WHERE room_id = ?";
        Object[] params = {examRoom.isPlace(), examRoom.getRoomname(), id};
        int rowsAffected = jdbcTemplate.update(sql, params);

        return rowsAffected;
    }

}
