package com.simlink.sinosoft.drugmonitor.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.annotation.MyBatisDao;
import com.simlink.sinosoft.drugmonitor.entity.Area;
import com.simlink.sinosoft.drugmonitor.entity.Organization;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@MyBatisDao
public interface AreaDao {

    public List<Area> findAreas(Area area, PageBounds pb);

    public void createArea(Area area);

    public void updateArea(Area area);

    public void deleteArea(String id);

    public List<Area> findAllAreas();

}
