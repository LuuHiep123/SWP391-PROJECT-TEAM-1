package com.example.scheduleexam_swp_team1.service;

import com.example.scheduleexam_swp_team1.interFaceService.SlotInterFace;
import com.example.scheduleexam_swp_team1.model.Slot;
import com.example.scheduleexam_swp_team1.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

@Service
public class SlotService implements SlotInterFace {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SlotRepository slotRepository;


    @Override
    public int createSlot(Slot slot) {
        try {
            String create = "INSERT INTO Slot (Slot_ID, Slot_Name, Start_Time, End_Time, [Time]) VALUES (?,?,?,?,?)" ;

            int rowsInserted = jdbcTemplate.update(create,
                    slot.getId(),
                    slot.getSlotName(),
                    slot.getStartTime(),
                    slot.getEndTime(),
                    slot.getTime());

            return rowsInserted;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Create false !");
        }
        return 0;
    }

    @Override
    public int updateSlot(Slot slot) {
        return 0;
    }

    @Override
    public List<Slot> listSlot() {
        try {

            return slotRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something Wrong!!!!!");
        }
        return null;
    }
}
