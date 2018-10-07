package com.item.util;
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;

import com.base.CoreConstants;

import ch.qos.logback.classic.LoggerContext;  
import ch.qos.logback.classic.joran.JoranConfigurator;  
import ch.qos.logback.core.joran.spi.JoranException;  

/** 
 * log4j 转  logback
 */  
public class LogbackConfigListener implements ServletContextListener {  
    private static final Logger logger = LoggerFactory.getLogger(LogbackConfigListener.class);  
     
    private static final String CONFIG_LOCATION = "logbackConfigLocation";  
    public void contextInitialized(ServletContextEvent event) {  
        //从web.xml中加载指定文件名的日志配置文件  
        String logbackConfigLocation = event.getServletContext().getInitParameter(CONFIG_LOCATION);  
        String fn = event.getServletContext().getRealPath(logbackConfigLocation.replace("classpath:", "WEB-INF/classes/"));  
        try {  
            LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();  
            loggerContext.reset();  
            JoranConfigurator joranConfigurator = new JoranConfigurator();  
            joranConfigurator.setContext(loggerContext);  
            joranConfigurator.doConfigure(fn);  
            logger.debug("loaded slf4j configure file from {}", fn);  
        }  
        catch (JoranException e) {  
            logger.error("can't load slf4j configure file from " + fn, e);  
        }  
        
        //设置application 全局参数 
        event.getServletContext().setAttribute("fileMode", CoreConstants.FILE_MODE);
        event.getServletContext().setAttribute("ossPath", "http://"+CoreConstants.OSS_BUCKET+"."+CoreConstants.OSS_IMG_ENDPOINT);
    }  
    public void contextDestroyed(ServletContextEvent event) {  
    }  
}  