package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Service
public class DeptServiceImpl implements DeptService {
	
	private DeptMapper deptMapper;
	
	@Autowired
	DeptServiceImpl(DeptMapper deptMapper){
		this.deptMapper = deptMapper;
	}
	
	// 전체조회
	@Override
	public List<DeptVO> findAllDept() {
		return deptMapper.selectDeptList();
	}
	
	// 단건조회
	@Override
	public DeptVO findDeptInfo(DeptVO deptVO) {
		return deptMapper.selectDeptInfo(deptVO);
	}
	
	// 등록
	@Override
	public int createDeptInfo(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}
	
	// 수정
	@Override
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		
		boolean isSuccessed = false;
		
		int result = deptMapper.updateDeptInfo(deptVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		
		return map;
	}
	
	// 삭제
	@Override
	public Map<String, Object> removeDeptInfo(int departmentId) {
		Map<String, Object> map = new HashMap<>();
		
		int result = deptMapper.deleteDeptInfo(departmentId);
		
		if (result == 1) {
			map.put("departmentId", departmentId);
		}
		
		return map;
	}

}