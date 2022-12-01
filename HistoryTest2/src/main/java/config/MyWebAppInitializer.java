package config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author аналог файла web.xml(web-inf)
 */

 public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {// корневая конфигурация 
      return new Class[] { WebConfig.class,HibernateConfiguration.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {// контрольная конфигурация 
      return new Class[] {};
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}
 
 
  
