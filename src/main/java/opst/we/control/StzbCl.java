package opst.we.control;

import opst.we.model.BaseResult;
import opst.we.model.StHero;
import opst.we.service.StzbService;
import opst.we.util.BaseController;
import opst.we.util.Page;
import opst.we.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: chgj
 * @description:
 * @date: create in 2018/1/30 15:03
 * @modified:
 */
@Controller
@RequestMapping("/stzb/")
public class StzbCl extends BaseController {
    @Autowired
    private StzbService service;
    @Override
    public String getView(String view) {
        return view;
    }


    @ResponseBody
    @RequestMapping("update")
    public BaseResult show(ModelMap map) {
        BaseResult result = new BaseResult();
        service.updateAllHero();
        result.setSuccess(true);
        result.setMessage("更新成功");
        return result;
    }

    @RequestMapping("/hero/detail/{id}")
    public String detail(ModelMap map,@PathVariable Integer id) {
        StHero hero = service.getStHeroById(id);
        map.put("hero",hero);
        return getView("herodetail");
    }

    @RequestMapping("/hero/list")
    public String list(ModelMap map,StHero hero,String page,String rows) {
        if(StringUtils.isEmpty(page)){
            page = "1";
        }
        if(StringUtils.isEmpty(rows)){
            rows = "20";
        }
        map.put("page",service.listStHeroByPage(Page.getPage(page,rows),hero));
        map.put("hero",hero);
        return getView("herolist");
    }

    @ResponseBody
    @RequestMapping("/hero/contrast/{id}")
    public BaseResult contrast(ModelMap map,@PathVariable Integer id) {
        BaseResult result = new BaseResult();
        try {
            service.addContrastHero(id);
            result.setSuccess(true);
            result.setMessage("添加成功");
            return result;
        } catch (RuntimeException e) {
            result.setMessage(e.getMessage());
        }catch (Exception e) {
            result.setMessage("添加失败");
            e.printStackTrace();
        }
        result.setSuccess(false);
        return result;
    }

    @RequestMapping("/hero/contrastlist")
    public String contrastlist(ModelMap map) {
        map.put("list",service.listContrastHero(1));
        return getView("herocontrast");
    }

    @ResponseBody
    @RequestMapping("/hero/contrastdel/{id}")
    public BaseResult contrastdel(ModelMap map,@PathVariable Integer id) {
        BaseResult result = new BaseResult();
        try {
            service.delContrastHero(id);
            result.setSuccess(true);
            result.setMessage("删除成功");
            return result;
        } catch (RuntimeException e) {
            result.setMessage(e.getMessage());
        }catch (Exception e) {
            result.setMessage("删除失败");
            e.printStackTrace();
        }
        result.setSuccess(false);
        return result;
    }
}
