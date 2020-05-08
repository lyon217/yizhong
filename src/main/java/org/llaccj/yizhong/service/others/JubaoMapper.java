package org.llaccj.yizhong.service.others;

import org.apache.ibatis.annotations.Mapper;
import org.llaccj.yizhong.module.Jubao;

@Mapper
public interface JubaoMapper {

    Boolean insertByuserid(Integer fromUserid, Integer toUserid);

    int deleteByPrimaryKey(Integer id);

    int insert(Jubao record);

    int insertSelective(Jubao record);

    Jubao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jubao record);

    int updateByPrimaryKey(Jubao record);

}