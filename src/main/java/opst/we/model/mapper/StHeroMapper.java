package opst.we.model.mapper;

import opst.we.model.StHero;
import opst.we.model.StHeroExample;
import opst.we.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StHeroMapper {
    int countByExample(StHeroExample example);

    int deleteByExample(StHeroExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StHero record);

    int insertSelective(StHero record);

    List<StHero> selectByExample(StHeroExample example);

    StHero selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StHero record, @Param("example") StHeroExample example);

    int updateByExample(@Param("record") StHero record, @Param("example") StHeroExample example);

    int updateByPrimaryKeySelective(StHero record);

    int updateByPrimaryKey(StHero record);

    Integer selectHeroMaxId();

    List<StHero> recommendedHero();

    StHero getDefalutHero(@Param("column") String column);

    List<StHero> listStHeroByPage(Page page, @Param("hero")StHero hero,@Param("sort")String sort);

    List<StHero> listContrastHeroByUser(Integer userid);
}