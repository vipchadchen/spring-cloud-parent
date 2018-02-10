package opst.we.control;

import opst.we.model.BaseResult;
import opst.we.model.StWj;
import opst.we.service.StzbService;
import opst.we.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
        service.updateHero();
        result.setSuccess(true);
        result.setMessage("更新成功");
        return result;
    }

    @RequestMapping("first")
    public String showNo(ModelMap map,String type) {
        StWj wj = service.getFirstHero(type);
        map.put("wj",wj);
        return getView("first");
    }
}
