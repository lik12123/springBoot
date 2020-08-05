package com.fh.service.impl;

import com.fh.dao.AreaDao;
import com.fh.dao.ShopDao;
import com.fh.entity.Area;
import com.fh.entity.Shop;
import com.fh.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Shop> queryShopBySales() {
        List<Shop> shops = shopDao.queryShopBySales();
        return shops;
    }

    @Override
    public List<Shop> queryShopList() {

        List<Shop> shops = shopDao.queryShopList();
        List<Area> areas = areaDao.queryAreaList();

        for (int i = 0; i < shops.size(); i++) {
            StringBuffer stringBuffer = new StringBuffer();
            String areaIds = ","+shops.get(i).getAreaIds()+",";
            for (int j = 0; j < areas.size(); j++) {
                if (areaIds.indexOf(","+areas.get(j).getId()+",") != -1){
                    stringBuffer.append(areas.get(j).getName()).append(",");
                    shops.get(i).setAreaIds(stringBuffer.toString());
                }
            }
        }
        return shops;
    }
}
