package opst.we.model.mapper;

import opst.we.model.StWj;
import opst.we.model.StWjExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StWjMapper {
    int countByExample(StWjExample example);

    int deleteByExample(StWjExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StWj record);

    int insertSelective(StWj record);

    List<StWj> selectByExample(StWjExample example);

    StWj selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StWj record, @Param("example") StWjExample example);

    int updateByExample(@Param("record") StWj record, @Param("example") StWjExample example);

    int updateByPrimaryKeySelective(StWj record);

    int updateByPrimaryKey(StWj record);
}