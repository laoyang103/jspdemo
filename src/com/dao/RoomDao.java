package com.dao;

import java.util.List;
import java.util.ArrayList;
import com.bean.ClassRoom;

public class RoomDao {
    private static int crListSize;
    private static List<ClassRoom> crList;

    static {
        crListSize = 5;
        crList = new ArrayList<ClassRoom>();
        for (int i = 0; i < crListSize; i++) {
            ClassRoom cr = new ClassRoom();
            cr.setId(i);
            cr.setBuildingName("逸夫楼");
            cr.setNumber(i + 100);
            crList.add(cr);
        }
    }

    public List<ClassRoom> getAllRoom() {
        return crList;
    }

    public void addRoom(int number, String buildingName) {
        ClassRoom cr = new ClassRoom();
        cr.setId(crListSize++);
        cr.setBuildingName(buildingName);
        cr.setNumber(number);
        crList.add(cr);
    }

    public void delRoom(int id) {
        for (int i = 0; i < crListSize; i++) {
            if (crList.get(i).getId() == id) {
                crList.remove(i);
                crListSize --;
                break;
            }
        }
    }
}
