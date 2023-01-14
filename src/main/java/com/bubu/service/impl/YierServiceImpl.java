package com.bubu.service.impl;

import com.bubu.mapper.YierMapper;
import com.bubu.pojo.PageBean;
import com.bubu.pojo.Yier;
import com.bubu.service.YierService;

import java.util.List;

import com.bubu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author qjl
 * @create 2023-01-09 17:35
 */
public class YierServiceImpl implements YierService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Yier> selectAll() {
        SqlSession sqlSession = factory.openSession();
        YierMapper mapper = sqlSession.getMapper(YierMapper.class);
        List<Yier> yiers = mapper.selectAll();
        sqlSession.close();
        return yiers;
    }

    @Override
    public void add(Yier yier) {
        SqlSession sqlSession = factory.openSession();
        YierMapper mapper = sqlSession.getMapper(YierMapper.class);
        mapper.add(yier);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        YierMapper mapper = sqlSession.getMapper(YierMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        YierMapper mapper = sqlSession.getMapper(YierMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public PageBean<Yier> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        YierMapper mapper = sqlSession.getMapper(YierMapper.class);
        //开始索引
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;

        //总的条数
        List<Yier> yiers = mapper.selectByPage(begin, size);
//        System.out.println(yiers);
        int totalCount = mapper.selectTotalCount();
//        System.out.println(totalCount);
        PageBean<Yier> yierPageBean = new PageBean<>();
        yierPageBean.setTotalCount(totalCount);
        yierPageBean.setRows(yiers);
        sqlSession.close();
        return yierPageBean;

    }

    @Override
    public PageBean<Yier> selectByPageAndCondition(int currentPage, int pageSize, Yier yier) {
        SqlSession sqlSession = factory.openSession();
        YierMapper mapper = sqlSession.getMapper(YierMapper.class);
        //开始索引
        int begin = (currentPage-1)*pageSize;
        int size = pageSize;
//        List<Yier> yiers = mapper.selectByPage(begin, size);
        //总的条数
        //加上%%表示模糊查询
        String friendName = yier.getFriendName();
        if (friendName!=null && friendName.length()>0){
            yier.setFriendName("%"+friendName+"%");
        }
        String schoolName = yier.getSchoolName();
        if (schoolName!=null && schoolName.length()>0){
            yier.setSchoolName("%"+schoolName+"%");
        }


        List<Yier> yiers = mapper.selectByPageAndCondition(begin,size,yier);
//        System.out.println(yiers);
        int totalCount = mapper.selectTotalCount();
//        System.out.println(totalCount);
        PageBean<Yier> yierPageBean = new PageBean<>();
        yierPageBean.setTotalCount(totalCount);
        yierPageBean.setRows(yiers);
        sqlSession.close();
        return yierPageBean;

    }

    @Override
    public void update(Yier yier) {
        SqlSession sqlSession = factory.openSession();
        YierMapper mapper = sqlSession.getMapper(YierMapper.class);
        mapper.update(yier);
        sqlSession.commit();
        sqlSession.close();

    }


}
