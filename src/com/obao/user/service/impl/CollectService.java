package com.obao.user.service.impl;

import com.obao.business.entity.Product;
import com.obao.user.dao.ICollectDao;
import com.obao.user.entity.Collect;
import com.obao.user.entity.User;
import com.obao.user.service.ICollectService;

import java.util.List;

/**
 * author 代江平
 * create Date 2016/11/28
 */
public class CollectService implements ICollectService {
    private ICollectDao collectDao;

    public void setCollectDao(ICollectDao collectDao) {
        this.collectDao = collectDao;
    }

    @Override
    public void save(Collect collect) {
        collectDao.save(collect);
    }

    @Override
    public List<Object> findUserAllCollect(Integer userId) {
        return collectDao.findUserAllCollect(userId);
    }
    @Override
    public Integer isExist(Integer productId, Integer userId) {
        List<Collect> collects = collectDao.isExist(productId, userId);
        if(collects.size() == 0){
            return 0;
        }else{
            return collects.get(0).getId();
        }
    }

    @Override
    public void delete(Integer id) {
        collectDao.delete(id);
    }


}
