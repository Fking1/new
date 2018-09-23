package service;

import dao.PageDao;
import javaBean.Page;
import net.sf.json.JSONObject;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageService {
	public List<JSONObject> getOnePageRecord(Page page) throws Exception {
		PageDao pageDao = new PageDao();
		List list = new ArrayList<ResultSet>();
		pageDao.getSql(page);
		pageDao.getTotalRecordCount(page);
		pageDao.getTotalPageCount(page);
		ResultSet rs = pageDao.getList(page);
		rs.absolute((page.getPage()-1)*page.getPageSize());
		ResultSetMetaData md = rs.getMetaData();//获取结果集的各种信息
		int columnCount = md.getColumnCount();
		int i=0;
		while (rs.next()&&i!=page.getPageSize()) {
			i++;
			Map rowData = new HashMap();
			for (int j=1; j <=columnCount; j++) {
				rowData.put(md.getColumnName(j), rs.getObject(j));
//                分别为获取列名和列值
			}
			JSONObject jsonObject = JSONObject.fromObject(rowData);
			list.add(jsonObject);
		}
		
		return list;
	}
	//    设置显示的条数
	public Integer setPages(Page page){
		if(page.getPage()*page.getPageSize()>page.getTotalRecordCount()){
			return (page.getTotalRecordCount()%page.getPageSize());
		}
		else{
			return page.getPageSize();
		}
	}
}
