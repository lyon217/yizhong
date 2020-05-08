package org.llaccj.yizhong.service.admin;

import org.llaccj.yizhong.module.AdminTable;
import org.llaccj.yizhong.module.config.ResultInfo;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author Lyon
 * @Date 2020-04-18 20:20
 * @Version
 **/
public interface AdminService {
    ResultInfo<AdminTable> AdminLogin(String aName, String aPassword);

    ResultInfo<Boolean> updateAdmin(AdminTable adminTable);
}
