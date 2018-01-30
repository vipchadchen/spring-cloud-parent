package opst.we.control;

import opst.we.util.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: chgj
 * @description:
 * @date: create in 2018/1/30 15:03
 * @modified:
 */
@Controller
@RequestMapping("/stzb/")
public class StzbCl extends BaseController {
    @Override
    public String getView(String view) {
        return view;
    }

    @RequestMapping("list")
    public String show(ModelMap map) {
        map.put("page","hello,world!");
        return getView("index");
    }
}
