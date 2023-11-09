package com.example.smart_campus_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smart_campus_app.bean.StudentAccount;
import com.example.smart_campus_app.service.StudentAccountService;
import com.example.smart_campus_app.dao.StudentAccountMapper;
import org.springframework.stereotype.Service;

/**
* @author zero
* @description 针对表【student_account】的数据库操作Service实现
* @createDate 2023-11-09 17:06:13
*/
@Service
public class StudentAccountServiceImpl extends ServiceImpl<StudentAccountMapper, StudentAccount>
    implements StudentAccountService{

}




