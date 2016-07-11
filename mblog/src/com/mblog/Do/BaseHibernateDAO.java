package com.mblog.Do;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mblog.Po.User;
import com.mblog.hibernate.HibernateSessionFactory;


public class BaseHibernateDAO implements IBaseHibernateDAO {

	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	/**
     * 添加实体
     * @param obj，要添加的实体对象
     * @throws Exception
     */
	public void add(Object obj) throws Exception {
		Session session = null;
		try {
			session = getSession();
			session.save(obj);
			session.beginTransaction().commit();
			if (session != null) {
				session.close();
			}
		} catch (RuntimeException e) {
			session.beginTransaction().rollback();
			if (session != null) {
				session.close();
			}
			throw e;
		}
	}
	/**
     * 删除实体
     * @param obj，要删除的实体
     * @throws Exception
     */
	public void delete(Object obj) throws Exception{
        Session session = null;
        try {
            //取得session对象
            session =getSession();
            //删除实体
            if(obj  != null){  
                session.delete(obj);  
            } 
            //提交事务
            session.beginTransaction().commit();
            if(session!=null){
            	session.close();
            }
        } catch (Exception e) {
            session.beginTransaction().rollback();//事务回滚
            if(session!=null){
            	session.close();
            }
            throw e;
        }
    }
	
	/**
     * 更新实体
     * @param obj，要更新的实体
     * @throws Exception
     */
    public void update(Object obj) throws Exception{
        Session session=null;
        try {
            //取得session对象
            session=getSession();
            //删除实体
            session.update(obj);
            //提交事务
            session.beginTransaction().commit();
            if(session!=null){
            	session.close();
            }
        } catch (Exception e) {
            session.beginTransaction().rollback();//事务回滚
            if(session!=null){
            	session.close();
            }
            throw e;
        }
    }
    
    /**
     * 根据指定的hql进行查询，并返回查询结果
     * @param hql，hql语句
     * @return 查询结果
     * @throws Exception
     */
    public List<?> findByHQL(String hql) throws Exception{
//    	Session session=null;
        try {
//        	session=getSession();
            Query queryObject =getSession().createQuery(hql);
//            Query queryObject =session.createQuery(hql);
//           session.beginTransaction().commit();
            return queryObject.list();
        } catch (Exception e) {
            throw e;
        }finally{
//        	if(session!=null){
//        		//session.clear();
//            	session.close();
//            }
        }
    }
    
    /**
     * 根据指定的hql进行分页查询，并返回查询结果
     * @param hql，hql语句
     * @return 查询结果
     * @throws Exception
     */
    public List<?> findByHQL(String hql,int index,int num) throws Exception{
    	Session session=getSession();
    	try {
            Query queryObject =getSession().createQuery(hql);
            queryObject.setFirstResult(index);
            queryObject.setMaxResults(num);
            session.beginTransaction().commit();
            return queryObject.list();
        } catch (Exception e) {
            throw e;
        }finally{
        	if(session!=null){
            	session.close();
            }
        }
    }
    
    /**
     * 根据指定的实体类型和主键的值，查找实体对象
     * @param cls，实体的类
     * @param key，主键的值
     * @return，查找的实体对象
     * @throws Exception
     */
    public Object findById(String cls,Serializable key)
        throws Exception
        
    {
    	Session session=getSession();
        try {
            Object instance = (Object) session.get(cls, key);
//            session.beginTransaction().commit();
            return instance;
        } catch (Exception e) {
            throw e;
        }finally{
//        	if(session!=null){
//            	session.close();
//            }
        }
        
    }
    public Object findById(Class cls,Serializable key)
            throws Exception
        {
    		Session session=getSession();
            try {
                Object instance = (Object) session.get(cls, key);
//                session.beginTransaction().commit();
                return instance;
            } catch (Exception e) {
                throw e;
            }finally{
//            	if(session!=null){
//                	session.close();
//                }
            }
            
        }

}