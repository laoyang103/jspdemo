package com.service;

import java.util.List;
import com.dao.RoomDao;
import com.bean.ClassRoom;

public class RoomService {

    public List<ClassRoom> getAllRoom() {
        RoomDao dao = new RoomDao();
        return dao.getAllRoom();
    }

    public void addRoom(int number, String buildingName) {
        RoomDao dao = new RoomDao();
        dao.addRoom(number, buildingName);
    }

    public void delRoom(int id) {
        RoomDao dao = new RoomDao();
        dao.delRoom(id);
    }
}
