package com.iteye.wwwcomy.main;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 用于将原本存于Access中的数据导入到MySQL中
 * 由于原本Access中，不同用户的日记都是存在不同的数据库里的，这点在MySQL中应该是所有用户的日记都存在于同一个数据库中，由一个UserId做关联。
 * 在导出过程中有一个数据转换的过程要做处理，Access中直接存的unicode(待补充)
 * 
 * @author wwwcomy
 *
 */
public class Migration {
	public static void main(String[] args) throws Exception {
		new Migration().gernateConfig();
	}

	/**
	 * TODO 完成写到数据库中!!
	 * 
	 * @throws Exception
	 */
	public void gernateConfig() throws Exception {
		JAXBContext context;
		DataRoot root = null;
		try {
			context = JAXBContext.newInstance(DataRoot.class);
			Unmarshaller shaller = context.createUnmarshaller();
			root = (DataRoot) shaller.unmarshal(new File("c:/temp/book.xml"));
			System.out.println(root);
			System.out.println(root.getDiaries().size());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		String memo = root.getDiaries().get(3).getMemo();
		System.out.println(memo);
		String result = getText(IOUtils.toInputStream(memo, Charset.forName("ISO8859_1")));
		System.out.println(new String(result.getBytes(Charset.forName("ISO8859_1")), "GB2312"));
	}

	public String getText(InputStream in) throws Exception {
		RTFEditorKit kit = new RTFEditorKit();
		Document doc = kit.createDefaultDocument();
		kit.read(in, doc, 0);
		return doc.getText(0, doc.getLength());
	}

	/**
	 * 测试用Spring连接Access数据源
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public void connMdbUseSpring() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = (DataSource) ac.getBean("access");
		Connection c = ds.getConnection();
		Statement st = c.createStatement();
		String sql = "select * from book";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString(3));
		}
	}

	/**
	 * 测试直接拿JDBC连接Access数据源
	 * 
	 * @throws Exception
	 */
	public void connMdbUseJdbc() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E://diary//winter.mdb;";
		Properties properties = new Properties();
		// 这里设置连接数据库时候用的编码
		properties.setProperty("charSet", "gbk");
		properties.setProperty("user", "admin");
		properties.setProperty("password", "123");
		Connection con = DriverManager.getConnection(url, properties);
		Statement st = con.createStatement();
		String sql = "select * from book";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(9));
		}
	}
}
