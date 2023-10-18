package com.example.scheduleexam_swp_team1.interFaceService;

import com.example.scheduleexam_swp_team1.model.Slot;

import java.util.List;

public interface SlotInterFace {

    public int createSlot(Slot slot);

    public int updateSlot(Slot slot);

    public List<Slot> listSlot();

}
