package com.hrm.job.dao;

import com.hrm.commons.benas.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IJobDao {

    @SelectProvider(type = jobProvider.class , method = "selectJob")
    List<Job> selectJob(Map map);

    @SelectProvider(type = jobProvider.class , method = "selectJobCount")
    int selectJobCount(String name);

    @Select("select * from job_inf where id = #{id}")
    Job selectJobById(Integer id);

    @Update("update job_inf set name=#{name},remark=#{remark} where id = #{id}")
    int updateJob(Job job);

    @DeleteProvider(type = jobProvider.class , method = "deleteJob")
    int deleteJob(@Param("ids") Integer[] ids);

    @Insert("insert into job_inf (name,remark) values (#{name},#{remark})")
    int insertJob(Job job);
}
