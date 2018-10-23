package misc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
//<context-param>
//    <param-name>contextClass</param-name>
//    <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
//</context-param>
//<context-param>
//    <param-name>contextConfigLocation</param-name>
//    <param-value>misc.SpringJavaConfiguration</param-value>
//</context-param>
//<listener>
//    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
//</listener>

//<servlet>
//		 <servlet-name>DispatcherServlet</servlet-name>
//		 <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//<init-param>
//		 <param-name>contextClass</param-name>
//		 <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
//</init-param> 		 
//<init-param>
//		 	<param-name>contextConfigLocation</param-name>
//		 	<param-value>misc.SpringMvcJavaConfigration</param-value>
//</init-param>
//<load-on-startup>1</load-on-startup>
//</servlet>
//	  	 <servlet-mapping>
//		 <servlet-name>DispatcherServlet</servlet-name>
//		 <url-pattern>/</url-pattern>
//</servlet-mapping>	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {SpringJavaConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {SpringMvcJavaConfigration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	

}
