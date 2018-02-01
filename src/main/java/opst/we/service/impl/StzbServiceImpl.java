package opst.we.service.impl;

import opst.we.model.StWj;
import opst.we.model.mapper.StWjMapper;
import opst.we.service.StzbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class StzbServiceImpl implements StzbService {
    @Autowired
    private StWjMapper mapper;

    @Override
    public List<StWj> listWj() {
        return mapper.selectByExample(null);
    }
}
