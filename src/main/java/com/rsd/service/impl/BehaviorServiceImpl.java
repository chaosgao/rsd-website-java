package com.rsd.service.impl;

import com.rsd.bean.Behavior;
import com.rsd.bean.SysFunction;
import com.rsd.dao.IBehaviorDAO;
import com.rsd.service.IBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BehaviorServiceImpl implements IBehaviorService {

    @Autowired
    private IBehaviorDAO behaviorDAO;

    @Override
    public List<Behavior> treeList1() {
        List<Behavior> list = behaviorDAO.getByFatherId(0);
        buildTree(list);
        return list;
    }

    @Override
    public List<Behavior> treeList2() {
        List<Behavior> allList = behaviorDAO.list();
        List<Behavior> rootList = new ArrayList<>();
        for (Behavior behavior : allList) {
            if (behavior.getFatherId() == 0) {
                rootList.add(behavior);
            }
        }
        buildTree2(allList, rootList);
        return rootList;
    }

    @Override
    public List<Behavior> queryList() {

        return behaviorDAO.list();
    }

    private void buildTree(List<Behavior> list) {
        if (list != null && !list.isEmpty()) {
            for (Behavior behavior : list) {
                List<Behavior> childList = behaviorDAO.getByFatherId(behavior.getId());
                if (childList != null && !childList.isEmpty()) {
                }
                behavior.setFatherList(childList);
                buildTree(childList);
            }
        }
    }

    private void buildTree2(List<Behavior> allList, List<Behavior> list) {
        if (list != null && !list.isEmpty()) {
            for (Behavior behavior : list) {

                List<Behavior> childList = new ArrayList<>();
                for (Behavior behavior1 : allList) {
                    if (behavior.getId() == behavior1.getFatherId()) {
                        childList.add(behavior1);
                    }
                }

                if (!childList.isEmpty()) {
                    behavior.setFatherList(childList);
                    buildTree2(allList, childList);
                }
            }
        }
    }
}
