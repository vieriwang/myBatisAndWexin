package com.imocc.usemybatis.service.impl;

import com.imocc.usemybatis.dao.AreaDao;
import com.imocc.usemybatis.entity.Area;
import com.imocc.usemybatis.service.IAreaService;
import com.imocc.usemybatis.util.enums.ResultEnum;
import com.imocc.usemybatis.util.exception.dao.AreaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if (area != null && area.getAreaName() != null) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                areaDao.insertArea(area);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new AreaException(ResultEnum.AREA_INSERT_AREANAME_EMPTY);
        }
        return true;
    }

    @Transactional
    @Override
    public boolean updateArea(Area area) {
        if (area != null && area.getAreaName() != null) {
            area.setLastEditTime(new Date());
            try {
                int i = areaDao.updateArea(area);
                if (i == 0) {
                    throw new AreaException(ResultEnum.AREA_UPDATE_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new AreaException(ResultEnum.AREA_UPDATE_AREANAME_EMPTY);
        }
        return true;
    }

    @Transactional
    @Override
    public boolean deleteArea(Integer areaId) {
        if (areaId > 0) {
            try {
                int i = areaDao.deleteArea(areaId);
                if (i == 0) {
                    throw new AreaException(ResultEnum.AREA_DELETE);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new AreaException(ResultEnum.AREA_DELETE_AREAID_EMPTY);
        }
        return true;
    }
}
