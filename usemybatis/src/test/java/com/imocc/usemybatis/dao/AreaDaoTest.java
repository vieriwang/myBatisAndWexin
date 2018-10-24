package com.imocc.usemybatis.dao;

import com.imocc.usemybatis.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area>areaList =areaDao.queryArea();
        assertEquals(2,areaList.size());

    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("测试区域");
        area.setPriority(1);
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        int id = areaDao.insertArea(area);
        assertNotEquals(id,0);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaId(4);
        area.setAreaName("南苑1");
        area.setLastEditTime(new Date());
        int i = areaDao.updateArea(area);
        assertEquals(i,1);
    }

    @Test
    public void deleteArea() {
        int i = areaDao.deleteArea(3);
        assertEquals(i,1);
    }
}