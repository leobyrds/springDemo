package com.goopal.filter;

/**
 * Created by leon on 2016/11/8.
 */

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * druid过滤器.
 * @author Administrator
 *
 */
/*@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        }
)*/
public class DruidStatFilter extends WebStatFilter {

}
