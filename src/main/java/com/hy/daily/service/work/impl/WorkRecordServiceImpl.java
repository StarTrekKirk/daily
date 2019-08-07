package com.hy.daily.service.work.impl;

import com.hy.daily.entity.work.WorkRecord;
import com.hy.daily.dao.work.WorkRecordMapper;
import com.hy.daily.service.work.IWorkRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考勤记录 服务实现类
 * </p>
 *
 * @author heiye
 * @since 2019-06-26
 */
@Service
public class WorkRecordServiceImpl extends ServiceImpl<WorkRecordMapper, WorkRecord> implements IWorkRecordService {

}
