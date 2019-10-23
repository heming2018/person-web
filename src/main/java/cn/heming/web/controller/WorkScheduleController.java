package cn.heming.web.controller;

import cn.heming.domain.WorkSchedule;
import cn.heming.domain.WorkScheduleItem;
import cn.heming.service.WorkScheduleService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("workSchedule")
public class WorkScheduleController {
    private static final Logger logger = LoggerFactory.getLogger(WorkScheduleController.class);

    @Resource
    private WorkScheduleService workScheduleService;

    @RequestMapping("goAddPage.do")
    public String goAddPage() {
        return "workSchedule/add";
    }

    @RequestMapping("goListPage.do")
    public String goListPage() {
        return "workSchedule/list";
    }

    @RequestMapping("add.do")
    @ResponseBody
    public Object add(@ModelAttribute WorkSchedule workSchedule) {
        logger.info("Start add, workSchedule: {}", workSchedule);

        Map<String, Object> res = new HashMap<>();

        List<WorkScheduleItem> workScheduleItems = workSchedule.getWorkScheduleItemList();
        if (CollectionUtils.isEmpty(workScheduleItems)) {
            logger.info("workScheduleItems can not be empty!");
            res.put("success",false);
            res.put("msg","排期明细不能为空");
            return res;
        }

        try {
            workScheduleService.add(workSchedule);
            res.put("msg","添加成功");
            res.put("success",true);
        } catch (Exception e) {
            logger.info("Failed to add", e);
            res.put("msg","添加失败");
            res.put("success",false);
        }

        return res;
    }
}