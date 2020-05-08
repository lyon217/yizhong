package org.llaccj.yizhong.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * LiuLuAn
 * 2018/08/03
 */

//数据库连接池 Druid 的过滤文件类型 :
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.jpeg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }
)

public class DruidStatFilter extends WebStatFilter {
}
