package com.www.demo.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.www.demo.app.service.IMyService;
import com.www.demo.model.bo.system.SysUserRepository;
import com.www.demo.model.vo.SysuserVO;
/**
 * 服务层
 * @author www
 *
 */
@Service
public class MyServiceImpl implements IMyService{
	@Autowired
	private SysUserRepository sysuserRepository;
	
	@Transactional(rollbackFor=IllegalArgumentException.class)
	@Override
	public boolean modifyUserPawsswdWithRollBack(SysuserVO sysuserVO) {
		if (sysuserVO==null) {
			return false;
		}
		int count = sysuserRepository.modifyPasswd(sysuserVO.getUserId(), sysuserVO.getOldPasswd(), sysuserVO.getNewPasswd());
		if (count==1) {
			throw new IllegalArgumentException("数据将回滚！");
		}
		return count>0?true:false;
	}

	@Transactional(noRollbackFor=IllegalArgumentException.class)
	@Override
	public boolean modifyUserPawsswdWithoutRollBack(SysuserVO sysuserVO) {
		if (sysuserVO==null) {
			return false;
		}
		int count = sysuserRepository.modifyPasswd(sysuserVO.getUserId(), sysuserVO.getOldPasswd(), sysuserVO.getNewPasswd());
		if (count==1) {
			throw new IllegalArgumentException("数据将不会回滚！");
		}
		return count>0?true:false;
	}

}
