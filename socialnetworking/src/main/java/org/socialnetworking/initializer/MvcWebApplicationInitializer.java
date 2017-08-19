package org.socialnetworking.initializer;
 import javax.servlet.Filter;

import org.socialnetworking.config.MvcConfig;
import org.socialnetworking.filter.CORSFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
    
 public class MvcWebApplicationInitializer 
 extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[] {MvcConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] {"/"};
        }
        
        @Override
        protected Filter[] getServletFilters() {
        	Filter [] singleton =  { new CORSFilter() };
        	return singleton;
        }

    }