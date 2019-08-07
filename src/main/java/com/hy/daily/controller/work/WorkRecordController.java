package com.hy.daily.controller.work;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hy.daily.entity.work.WorkRecord;
import com.hy.daily.service.work.IWorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 考勤记录 前端控制器
 * </p>
 *
 * @author heiye
 * @since 2019-06-26
 */
@RestController
@RequestMapping("/work")
public class WorkRecordController {

    @Autowired
    private IWorkRecordService workRecordService;

    private WorkRecord queryRecord(){
        return workRecordService.getOne(Wrappers.<WorkRecord>lambdaQuery().eq(WorkRecord::getWorkDate, LocalDate.now()).eq(WorkRecord::getUserId, "0001"));
    }

    @GetMapping("/record")
    public Map<String, Object> record(){
        WorkRecord workRecord = queryRecord();
        Map<String, Object> result = new HashMap<>();
        result.put("result", workRecord);
        return result;
    }

    @GetMapping("/startWork")
    public Map<String, Object> startWork() {
        WorkRecord record = queryRecord();
        if (record != null) {
            throw new RuntimeException("今日已打卡");
        }
        WorkRecord workRecord = new WorkRecord();
        workRecord.setUserId("0001");
        workRecord.setUserName("heiye");
        workRecord.setStartWork(LocalDateTime.now());
        workRecord.setWorkDate(LocalDate.now());

        workRecordService.save(workRecord);
        Map<String, Object> result = new HashMap<>();
        result.put("result", workRecord);
        return result;
    }

    @GetMapping("/offWork")
    public Map<String, Object> offWork(Integer id) {
        workRecordService.update(Wrappers.<WorkRecord>lambdaUpdate().set(WorkRecord::getOffWork,LocalDateTime.now()).eq(WorkRecord::getId, id));
        Map<String, Object> result = new HashMap<>();
        result.put("result", workRecordService.getById(id));
        return result;
    }
}
