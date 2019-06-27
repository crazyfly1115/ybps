package com.thinkgem.jeesite.modules.cms.filter;


import com.thinkgem.jeesite.modules.cms.entity.FiterIp;
import com.thinkgem.jeesite.modules.cms.utils.CmsUtils;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static com.thinkgem.jeesite.modules.cms.utils.CmsUtils.getIpList;

/**
 * @Author zhangsy
 * @Description  IP过滤过滤器
 * @Date 16:54 2019/6/27
 * @Param 
 * @return 
 * @Company 重庆尚渝网络科技
 * @version v1000
 **/

public class IpFilter implements Filter{
    protected org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String ip = request.getRemoteHost();
        logger.debug("当前访问者的IP{}",ip);
        List<FiterIp> ipList = CmsUtils.getIpList();
        long  ipl= getIpNum(ip);
        boolean isIPList=false;
        for (FiterIp fiterIp:ipList){
            long start_ip = getIpNum(fiterIp.getStartIp());
            long end_ip = getIpNum(fiterIp.getEndIp());
            isIPList=isInner(ipl, start_ip, end_ip);
            //返回true 在列表中 则退出循环
            if(isIPList)break;
        }

        if (isIPList)
        {
            System.out.println("在ip段中");
        }
        else
        {
            System.out.println("不在ip段中");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
    private long getIpNum(String ipAddress)
    {
        String[] ip = ipAddress.split("[.]");
        long a = Integer.valueOf(ip[0]);
        long b = Integer.valueOf(ip[1]);
        long c = Integer.valueOf(ip[2]);
        long d = Integer.valueOf(ip[3]);

        return a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
    }
    private boolean isInner(long clientIp, long begin, long end)
    {
        return (clientIp >= begin) && (clientIp <= end);
    }
}
