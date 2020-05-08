package org.llaccj.yizhong.service.admin;

import org.llaccj.yizhong.module.AdminTable;
import org.llaccj.yizhong.module.config.ResultInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-18 20:20
 * @Version
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminTableMapper adminTableMapper;


    @Override
    public ResultInfo<AdminTable> AdminLogin(String aName, String aPassword) {
        ResultInfo<AdminTable> resultInfo = new ResultInfo<>();

        List<AdminTable> admins = adminTableMapper.AdminLogin(aName, aPassword);
        if (!admins.isEmpty()) {
            resultInfo.setSuccess(true);
            resultInfo.setData(admins.get(0));
            resultInfo.setMessage("登录成功");
        } else {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("登录失败");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo<Boolean> updateAdmin(AdminTable adminTable) {
        ResultInfo<Boolean> resultInfo = new ResultInfo<>();

        Boolean i = adminTableMapper.updateByPrimaryKeySelective(adminTable);
        resultInfo.setMessage("修改成功");
        resultInfo.setData(i);
        resultInfo.setSuccess(i);
        return resultInfo;
    }
}
