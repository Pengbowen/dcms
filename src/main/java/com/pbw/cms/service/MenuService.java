package com.pbw.cms.service;

import com.pbw.cms.entity.Menu;

public interface MenuService extends BaseService<Menu,Long>{
    void  deleteMenuAndChildren(long id);
}
