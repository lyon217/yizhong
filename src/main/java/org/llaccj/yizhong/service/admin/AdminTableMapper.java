package org.llaccj.yizhong.service.admin;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.AdminTable;

import java.util.List;

@Mapper
public interface AdminTableMapper {

    List<AdminTable> AdminLogin(String aName, String aPassword);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminTable record);

    int insertSelective(AdminTable record);

    AdminTable selectByPrimaryKey(Integer id);

    Boolean updateByPrimaryKeySelective(AdminTable record);

    int updateByPrimaryKey(AdminTable record);
}