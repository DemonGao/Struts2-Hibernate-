package com.mblog.action.Articlescrap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mblog.Do.ArticlescrapDAO;
import com.mblog.Do.impl.ArticlescrapDAOImpl;
import com.mblog.Po.Articlescrap;
import com.mblog.Po.User;
import com.mblog.action.SuperAction;

public class QueryArticlescrapAction extends SuperAction {
	private static final long serialVersionUID = 1L;

	ArticlescrapDAO articleDAO = new ArticlescrapDAOImpl();
	private Map<String, Object> dataMap;
	private Articlescrap articlescrap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public Articlescrap getArticlescrap() {
		return articlescrap;
	}

	public void setArticlescrap(Articlescrap articlescrap) {
		this.articlescrap = articlescrap;
	}

//	public String json() throws Exception {
//		dataMap = new HashMap<String, Object>();
//		User user_add = new User();
//		int id = Integer.parseInt(request.getParameter("userid").toString());
//		int pageNum = Integer.parseInt(request.getParameter("pageNum")
//				.toString());
//		int Num = Integer.parseInt(request.getParameter("Num").toString());
//		User user = articleDAO.queryArticle(id, pageNum, Num);
//		// 将获取的Articlescrap表中内容放到arr数组中
//		Set<Articlescrap> set = user.getArticle();
//		Articlescrap[] arr = new Articlescrap[set.size()];
//		Iterator it = set.iterator();
//		int i = 0;
//		while (it.hasNext()) {
//			arr[i] = (Articlescrap) it.next();
//			i++;
//		}
//		dataMap.put("type", "articlescraps");
//		dataMap.put("articlescraps", arr);
//		// 存入作者名称
//		dataMap.put("success", "true");
//		return SUCCESS;
//	}

	// 分页获取文章
	public String queryById() throws Exception {
		dataMap = new HashMap<String, Object>();
		int id = Integer.parseInt(request.getParameter("userid").toString());
		System.out.println("*************************************\t"+id);
		int pageNum = Integer.parseInt(request.getParameter("pageNum")
				.toString());
		int Num = Integer.parseInt(request.getParameter("Num").toString());
		List<Articlescrap> list = articleDAO.queryArticle(id,pageNum * Num, Num);
		Articlescrap[] arr = new Articlescrap[list.size()];
		dataMap.put("articlescraps", list);
		// 存入作者名称
		dataMap.put("success", "true");
		return SUCCESS;
	}

	// 分页获取文章
	public String query() throws Exception {
		dataMap = new HashMap<String, Object>();
		int pageNum = Integer.parseInt(request.getParameter("pageNum")
				.toString());
		int Num = Integer.parseInt(request.getParameter("Num").toString());
		// int num=2;
		List<Articlescrap> list = articleDAO.queryArticle(pageNum * Num, Num);
		// List<Articlescrap> list=articleDAO.queryArticle();
		Articlescrap[] arr = new Articlescrap[list.size()];
		dataMap.put("articlescraps", list);
		// 存入作者名称
		dataMap.put("success", "true");
		return SUCCESS;
	}

	public String getNum() throws Exception {
		dataMap = new HashMap<String, Object>();
		String arg1=request.getParameter("arg1");
		String arg2=request.getParameter("arg2");
		
		System.out.println("-----------------------"+arg1+""+arg2);
		int length=0;
		if(arg1!=null&&arg2!=null){
			length = articleDAO.getArticleNum(arg1,arg2);
		}else{
			length = articleDAO.getArticleNum();
		}
		dataMap.put("length", length);
		dataMap.put("success", "true");
		return SUCCESS;
	}

}
