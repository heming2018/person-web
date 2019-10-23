package cn.heming.service.impl;

import cn.heming.dao.WorkScheduleDao;
import cn.heming.dao.WorkScheduleItemDao;
import cn.heming.domain.WorkSchedule;
import cn.heming.domain.WorkScheduleItem;
import cn.heming.service.WorkScheduleService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author heming
 * @date 2019/10/15 15:01
 * @description TODO
 */
@Service
public class WorkScheduleServiceImpl implements WorkScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(WorkScheduleServiceImpl.class);

    @Resource
    WorkScheduleDao workScheduleDao;

    @Resource
    WorkScheduleItemDao workScheduleItemDao;

    @Override
    public void add(WorkSchedule workSchedule) {
        int id = workScheduleDao.insert(workSchedule);

        List<WorkScheduleItem> workScheduleItemList = workSchedule.getWorkScheduleItemList();
        if (CollectionUtils.isNotEmpty(workScheduleItemList)) {
            for (WorkScheduleItem workScheduleItem : workScheduleItemList) {
                workScheduleItem.setWorkScheduleId(id);
                workScheduleItemDao.insert(workScheduleItem);
            }
        }
    }
}