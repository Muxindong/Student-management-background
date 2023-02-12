package com.example.springbooot.service.impl;

import com.example.springbooot.dao.TeacherRepository;
import com.example.springbooot.dto.LoginDto;
import com.example.springbooot.dto.RegisterDto;
import com.example.springbooot.entity.Teacher;
import com.example.springbooot.service.TeacherService;
import com.example.springbooot.util.PatternUtil;
import com.example.springbooot.util.TokenUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public RegisterDto register(RegisterDto dto) {
        // 判断密码是否合法
        if ( !(PatternUtil.isPassword ( dto.getPassword () )) ) {
            dto.setIllegal ( false );
            return dto;
        }
        ModelMapper modelMapper = new ModelMapper ();
        // 根据账号查询用户
        Optional<Teacher> one = teacherRepository.findTeacherByAccount ( dto.getAccount () );
        // 如果查询结果不为空，则已经注册
        if (one.isPresent ()) {
            RegisterDto ret = modelMapper.map ( one.get (), RegisterDto.class );
            ret.setExist ( true );
            return ret;
        }
        // 如果结果为空，那么创建新的实体
        // 根据dto映射实体类
        Teacher teacher = modelMapper.map ( dto, Teacher.class );
        teacherRepository.save(teacher);
        return dto;
    }

    @Override
    public LoginDto login(LoginDto dto) {
        if ( !(PatternUtil.isPassword ( dto.getPassword () )) ) {
            dto.setIllegal ( false );
            dto.setExist ( false );
            return dto;
        }
        ModelMapper modelMapper = new ModelMapper ();
        // 根据账号查询用户
        Optional<Teacher> one = teacherRepository.findTeacherByAccount ( dto.getAccount () );
        // 如果查询结果为空，则不存在该账号
        if (!one.isPresent()) {

            LoginDto ret = modelMapper.map ( one.orElseGet ( Teacher::new ), LoginDto.class );
            ret.setExist ( false );
            return ret;
        }
        // 如果查询结果不为空，但是密码和查询结果不同，则密码错误
        else {
            // 数据库中的密码与dto中的密码是否相同
            if (!one.get ().getPassword ().equals ( dto.getPassword () )) {
                LoginDto ret = modelMapper.map ( one.orElseGet ( Teacher::new ), LoginDto.class );
                ret.setExist ( false );
                return ret;
            }
        }
        // 如果账号密码都正确，返回
        String token = TokenUtil.genToken(one.get().getId().toString(), one.get().getPassword());
        LoginDto dto1=modelMapper.map ( one.orElseGet ( Teacher::new ), LoginDto.class );
        dto1.setToken(token);
        return dto1;
    }
}
