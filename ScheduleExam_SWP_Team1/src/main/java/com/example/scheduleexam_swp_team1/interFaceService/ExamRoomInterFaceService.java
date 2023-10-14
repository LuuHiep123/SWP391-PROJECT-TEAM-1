package com.example.scheduleexam_swp_team1.interFaceService;

import com.example.scheduleexam_swp_team1.model.ExamRoom;

import java.util.List;

public interface ExamRoomInterFaceService {
    // ham add 1 Exam Room
    public int creatExamRoom(ExamRoom examRoom);
    // ham delete 1 Exam Room
    public boolean deleteExamRoom(long id);

    //ham getRoombyID
    public ExamRoom getRoomByID(long id);

    //ham getListRoom
    public List<ExamRoom> getListRoom();

    //  ham update Room
    public int updateExamRoom(long id, ExamRoom examRoom);
}
