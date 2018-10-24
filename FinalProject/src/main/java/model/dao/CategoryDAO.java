package model.dao;

import java.util.List;

import model.CategoryBean;

public interface CategoryDAO {
    List<CategoryBean> selectAll();
    CategoryBean selectById(int id);
    CategoryBean insert(CategoryBean bean);
    boolean update(CategoryBean bean);
   
}
