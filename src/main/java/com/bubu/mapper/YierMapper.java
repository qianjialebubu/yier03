package com.bubu.mapper;

import java.util.List;

import com.bubu.pojo.Yier;
import org.apache.ibatis.annotations.*;

/**
 * @author qjl
 * @create 2023-01-09 17:20
 */
public interface YierMapper {
    //查询所有
    @Select("select * from tb_yier")
    @ResultMap("YierResultMap")
    List<Yier> selectAll();

    @Insert("insert into tb_yier values (null,#{friendName},#{schoolName},#{age},#{description},#{status})")
    void add(Yier yier);

    void deleteByIds(@Param("ids") int[] ids);

    @Delete("delete from tb_yier where id = #{id}")
    void deleteById(@Param("id")int id);

    @Select("select * from tb_yier limit #{begin},#{size}")
    @ResultMap("YierResultMap")
    List<Yier> selectByPage(@Param("begin") int begin,@Param("size") int size);

    @Select("select count(*) from tb_yier ")
    int selectTotalCount();



    List<Yier> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("yier") Yier yier);


    int selectTotalCountByCondition(Yier yier);

    @Update("update tb_yier set friend_name = #{friendName}, school_name = #{schoolName},age = #{age},description = #{description} where id = #{id}")
    void update(Yier yier);

}
