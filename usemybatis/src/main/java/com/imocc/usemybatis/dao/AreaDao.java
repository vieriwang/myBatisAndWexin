package com.imocc.usemybatis.dao;

import com.imocc.usemybatis.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     *
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据Id查出对应区域信息
     *
     * @param areaId
     * @return area
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return area
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);

}
