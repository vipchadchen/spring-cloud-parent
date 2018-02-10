package opst.we.service;


import opst.we.model.StWj;
import opst.we.util.Page;

import java.util.List;

public interface StzbService {

    List<StWj> listWj();

    Page listWjByPage(Page page);

    void updateHero();

    StWj getFirstHero(String type);
}
