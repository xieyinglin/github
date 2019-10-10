package com.taosdata.github.dao;

import com.taosdata.github.domain.GithubIndicator;
import com.taosdata.github.domain.GithubIndicatorExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GithubIndicatorMapper {
    long countByExample(GithubIndicatorExample example);

    int deleteByExample(GithubIndicatorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GithubIndicator record);

    int insertSelective(GithubIndicator record);

    List<GithubIndicator> selectByExample(GithubIndicatorExample example);

    List<GithubIndicator> selectMaxByDay(@Param("userId") String userId, @Param("projectName") String projectName, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    GithubIndicator selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GithubIndicator record, @Param("example") GithubIndicatorExample example);

    int updateByExample(@Param("record") GithubIndicator record, @Param("example") GithubIndicatorExample example);

    int updateByPrimaryKeySelective(GithubIndicator record);

    int updateByPrimaryKey(GithubIndicator record);
}