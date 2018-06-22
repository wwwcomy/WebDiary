package com.iteye.wwwcomy.main;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.iteye.wwwcomy.dao.DiaryRepository;
import com.iteye.wwwcomy.model.Diary;

@Component
public class Migrater implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	DiaryRepository diaryRepository;

	@Override
	public void run(String... arg0) throws Exception {
		migrate2Mysql();
	}

	public void migrate2Mysql() throws Exception {
		DataRoot root = gernateDiaries("d:/temp/book.xml");
		for (DiaryBean diary : root.getDiaries()) {
			String memo = diary.getMemo();
			String content = getNormalTextFromRtf(IOUtils.toInputStream(memo, Charset.forName("ISO8859_1")));
			Diary d = new Diary();
			d.setUserId(1);
			d.setContent(content);
			d.setDate(diary.getDate());
			d.setTitle(diary.getTitle());
			d.setWeather(diary.getIcotext());
			diaryRepository.save(d);
		}
	}

	/**
	 * 根据MDB导出的XML生成Diary的实体
	 * 
	 * @throws Exception
	 */
	private DataRoot gernateDiaries(String mdbExportedXml) throws Exception {
		JAXBContext context;
		DataRoot root = null;
		try {
			context = JAXBContext.newInstance(DataRoot.class);
			Unmarshaller shaller = context.createUnmarshaller();
			root = (DataRoot) shaller.unmarshal(new File(mdbExportedXml));
			logger.info(root.toString());
			logger.info("Migrated diaries size is :{}", root.getDiaries().size());
		} catch (JAXBException e) {
			throw e;
		}
		if (root.getDiaries() == null) {
			root.setDiaries(new ArrayList<DiaryBean>());
		}
		return root;
	}

	private String getNormalTextFromRtf(InputStream in) throws Exception {
		RTFEditorKit kit = new RTFEditorKit();
		Document doc = kit.createDefaultDocument();
		kit.read(in, doc, 0);
		String tmp = doc.getText(0, doc.getLength());
		return new String(tmp.getBytes(Charset.forName("ISO8859_1")), "GB2312");
	}

	/**
	 * Use JDBC-ODBC to connect to access
	 * 
	 * @deprecated sun.jdbc.odbc.JdbcOdbcDriver has been removed in jdk8
	 * @throws Exception
	 */
	public void connMdbUseJdbc() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E://diary//TianDiary.mdb;";
		Properties properties = new Properties();
		// 这里设置连接数据库时候用的编码
		properties.setProperty("charSet", "gbk");
		// properties.setProperty("user", "admin");
		properties.setProperty("password", "muae31910660天天日记本");
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
