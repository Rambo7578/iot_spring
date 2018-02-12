package com.iot.spring.common.dbcon;



import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;

import com.iot.spring.vo.ConnectionInfoVO;



public class DBConnector {

   private BasicDataSource bds;
   private SqlSessionFactoryBean ssf;

   public DBConnector(ConnectionInfoVO ci) throws Exception {
      bds = new BasicDataSource();
      bds.setDriverClassName("org.mariadb.jdbc.Driver");
      String url = "jdbc:mysql://" + ci.getCiUrl() + ":" + ci.getCiPort();
      bds.setUrl(url);
      bds.setUsername(ci.getCiUser());
      bds.setPassword(ci.getCiPwd());
      ssf = new SqlSessionFactoryBean();
      ssf.setDataSource(bds);
      ssf.setConfigLocation(new ClassPathResource("/mybatis-conf.xml"));
      
   }

/*   public Connection getConnection() {
      try {
         return bds.getConnection();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;
   }*/

   public SqlSession getSqlSession() throws Exception {
      return ssf.getObject().openSession();
   }
   
//   public static void main(String[] args) throws Exception {
//      ConnectionInfoVO ci = new ConnectionInfoVO();
//      ci.setCiUrl("localhost");
//      ci.setCiPort(3306);
//      ci.setCiUser("root");
//      ci.setCiPwd("test");
//      DBConnector dbc = new DBConnector(ci);
//      Connection con = dbc.getConnection();
//      if (con != null) {
//         System.out.println("연결 성공 ");
//      }
//   }
}
