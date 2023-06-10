package com.qianfeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.ITravelTipDao;
import com.qianfeng.domain.TravelTip;
import com.qianfeng.service.ITravelTipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TravelTipServiceImpl implements ITravelTipService {
        @Resource
        private ITravelTipDao travelTipDao;

        @Override
        public void add(TravelTip travelTip) {
                travelTipDao.add(travelTip);
        }

        @Override
        public void deleteByIds(String[] ids) {
                for (String id : ids) {
//                        System.out.println("\n\n\n\\n");
//                        System.out.println(id);
//                        System.out.println("\n\n\n\\n");
                        travelTipDao.deleteById(id);
                }
        }

        @Override
        public List<TravelTip> findAll(Integer page, Integer pageSize) {
                PageHelper.startPage(page, pageSize);//导包，帮助我们在sql上拼接limit语句
                List<TravelTip> travelTipList = travelTipDao.findAll();
                return travelTipList;
        }

        @Override
        public String updateCountById(String tipId) {
                TravelTip travelTip = travelTipDao.findById(tipId);
                travelTipDao.updateCountByID(tipId,travelTip.getReadCount()+1);
                return travelTip.getUrl();
        }

        @Override
        public void update(TravelTip travelTip) {
                travelTipDao.update(travelTip);
        }

        @Override
        public TravelTip findById(String tipId) {
                return travelTipDao.findById(tipId);
        }

}
