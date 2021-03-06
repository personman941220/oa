package com.bwjf.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Department;
import com.bwjf.mapper.DepartmentMapper;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 部门逻辑业务层
 */
@Service
@Transactional
public class DepartmentServiceImpl implements com.bwjf.service.DepartmentService {

	public DepartmentMapper dMapper;

	public DepartmentMapper getdMapper() {
		return dMapper;
	}

	@Resource
	public void setdMapper(DepartmentMapper dMapper) {
		this.dMapper = dMapper;
	}

	@Override
	public List<Department> getAllDepartment() {
		System.out.println("---DepartmentServiceImpl.getAllDepartment()---");
		return dMapper.getAllDepartment();
	}

	@Override
	public int add(Department department) {
		System.out.println("---DepartmentServiceImpl.add(" + department.toString() + ")---");
		Department d = new Department();
		d.setName(department.getName());
		d = dMapper.getDepartmentByName(d.getName());
		
		if (d!=null) {// 部门已存在
			return 0;
		} else {
			dMapper.add(department);
			return 1;
		}
	}

	@Override
	public Department getDepartmentByNameMH(String name) {
		//模糊查询
		return dMapper.getDepartmentByNameMH(name);
	}

	@Override
	public int delet(int departmentId) {
		dMapper.delet(departmentId);
		Department department = dMapper.getDepartmentById(departmentId);
		if (department==null) {//删除成功
			return 1;
		}else {
			//删除失败
			return 0;
		}
	}

	@Override
	public Department getDepartmentByName(String name) {
		return dMapper.getDepartmentByName(name);
	}

}
