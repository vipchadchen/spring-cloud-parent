package opst.we.control;

import opst.we.service.StzbService;
import opst.we.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
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
public class IndexCl extends BaseController {
    @Autowired
    private StzbService service;
    @Override
    public String getView(String view) {
        return view;
    }

    @RequestMapping("/")
    public String show(ModelMap map,String pages,String row) {
//        pages = "1";
//        row = "10";
//        Page page =Page.getPage(pages, row);
//        map.put("page",service.listWjByPage(page));
        map.put("page",service.listWj());
        return getView("index");
    }
}
