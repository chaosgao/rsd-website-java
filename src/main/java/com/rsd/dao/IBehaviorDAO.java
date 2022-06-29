package com.rsd.dao;

import com.rsd.bean.Behavior;

import java.util.List;

public interface IBehaviorDAO {

    List<Behavior> getByFatherId(Integer fatherId);

    List<Behavior> list();

}
