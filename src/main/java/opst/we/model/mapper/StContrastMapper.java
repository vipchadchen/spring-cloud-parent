package opst.we.model.mapper;

import opst.we.model.StContrast;
import opst.we.model.StContrastExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StContrastMapper {
    int countByExample(StContrastExample example);

    int deleteByExample(StContrastExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StContrast record);

    int insertSelective(StContrast record);

    List<StContrast> selectByExample(StContrastExample example);

    StContrast selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StContrast record, @Param("example") StContrastExample example);

    int updateByExample(@Param("record") StContrast record, @Param("example") StContrastExample example);

    int updateByPrimaryKeySelective(StContrast record);

    int updateByPrimaryKey(StContrast record);

    StContrast getContrastByHeroid(Integer heroid);

    int deleteByHeroid(Integer heroid);
}