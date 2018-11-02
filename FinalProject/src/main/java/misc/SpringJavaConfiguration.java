package misc;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.event.TransactionalEventListener;

@Configuration
@ComponentScan(basePackages={"model"})
public class SpringJavaConfiguration {
//	@Bean//WEB應用程式連資料庫
	public DataSource dataSource() {
		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setJndiName("java:comp/env/jdbc/xxx");
		factory.setProxyInterface(javax.sql.DataSource.class);
		try {
			factory.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return (DataSource) factory.getObject();
	}
	@Bean//一般JAVA應用程式連資料庫
	public DataSource dataSourcemanager() {
		DriverManagerDataSource DMDS = new DriverManagerDataSource();
		DMDS.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		DMDS.setUrl("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JeanYuan");
		DMDS.setUsername("sa");
		DMDS.setPassword("passw0rd");
		return DMDS;
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder =
				new LocalSessionFactoryBuilder(dataSource());//看程式執行地方換datasource

		Properties props = new Properties();

		props.put("hibernate.hbm2ddl.auto","update"); //有此行才會自行創建表格
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.put("hibernate.current_session_context_class", "thread");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		builder.addProperties(props);
		
		builder.scanPackages("model");
//		builder.addAnnotatedClasses(AllStockBean.class,BranchBean.class,BranchStockBean.class);
//		builder.addAnnotatedClasses(BrandBean.class,CabinetBean.class,CartBean.class);
//		builder.addAnnotatedClasses(CartDetailBean.class,CategoryBean.class,CpuBean.class);
//		builder.addAnnotatedClasses(ImportBean.class,MbBean.class,MemberBean.class);
//		builder.addAnnotatedClasses(MessageBean.class,OrderDetailBean.class,OrderListBean.class);
//		builder.addAnnotatedClasses(PinginBean.class,PinginDetailBean.class,PowerSupplierBean.class);
//		builder.addAnnotatedClasses(ProductBean.class,RamBean.class,StaffBean.class,ImportDetailBean.class);
//		builder.addAnnotatedClasses(StorageBean.class,TransferBean.class,VgaBean.class,WishBean.class);
		return builder.buildSessionFactory();
	}
	
	@TransactionalEventListener

	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		sessionFactory.getCurrentSession().beginTransaction();
//		Session session = sessionFactory.getCurrentSession();
//		CustomerBean select = session.get(CustomerBean.class, "Alex");
//		System.out.println("select="+select);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	
//		DataSource dataSource = (DataSource) context.getBean("dataSource");
//		Connection conn = dataSource.getConnection();
//		Statement stmt = conn.createStatement();
//		ResultSet rset = stmt.executeQuery("select * from dept");
//		while(rset.next()) {
//			String col1 = rset.getString(1);
//			String col2 = rset.getString(2);
//			System.out.println(col1+":"+col2);
//		}				
		((ConfigurableApplicationContext)  context).close();
	}
}
