package com.whuahua.smart.fruit.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.fruit.bo.FruitYOrderBO;
import com.whuahua.smart.fruit.bo.QueryFruitYOrderBO;
import com.whuahua.smart.fruit.bo.RespBaseBO;
import com.whuahua.smart.fruit.dao.FruitYOrderDAO;
import com.whuahua.smart.fruit.po.FruitYOrderPO;
import com.whuahua.smart.fruit.service.FruitYOrderService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class FruitYOrderServiceImpl implements FruitYOrderService {

	@Autowired
	private FruitYOrderDAO fruitYOrderDAO;
	@Override
	public RespBaseBO insert(FruitYOrderBO fruitYOrderBO) {
		// TODO Auto-generated method stub
		RespBaseBO bo=new RespBaseBO();
		try {
			FruitYOrderPO yOrderPO=new FruitYOrderPO();
			yOrderPO.setCommondityId(fruitYOrderBO.getCommondityId());
			yOrderPO.setFruitUserId(fruitYOrderBO.getFruitUserId());
			FruitYOrderPO fruitYOrderPO=fruitYOrderDAO.selectByCommondityId(yOrderPO);
			if(fruitYOrderPO!=null) {
				FruitYOrderPO orderPO=new FruitYOrderPO();
				orderPO.setCommondityId(fruitYOrderBO.getCommondityId());
				orderPO.setFruitUserId(fruitYOrderBO.getFruitUserId());
				System.out.println("数据库里的值："+fruitYOrderPO.getFruitNum()+"新增值："+fruitYOrderBO.getFruitNum());
				System.out.println(fruitYOrderPO.getFruitNum()+fruitYOrderBO.getFruitNum());
				orderPO.setFruitNum(fruitYOrderPO.getFruitNum()+fruitYOrderBO.getFruitNum());
				int a=fruitYOrderDAO.update(orderPO);
				if(a>0) {
					bo.setRespCode(BaseCode.SUCCESS_CODE);
					bo.setRespDesc(BaseCode.SUCCESS_DESC);
				}else{
					bo.setRespCode(BaseCode.FAIL_CODE);
					bo.setRespDesc(BaseCode.FAIL_DESC);
				}
				return bo;
			}
			FruitYOrderPO po=new FruitYOrderPO();
			po.setCommondityId(fruitYOrderBO.getCommondityId());
			po.setComName(fruitYOrderBO.getComName());
			po.setComPrice(fruitYOrderBO.getComPrice());
			po.setFruitNum(fruitYOrderBO.getFruitNum());
			po.setFruitUserId(fruitYOrderBO.getFruitUserId());
			po.setComPhDress(fruitYOrderBO.getComPhDress());
			po.setSelected(fruitYOrderBO.getSelected()+"");
			int a=fruitYOrderDAO.insert(po);
			if(a>0) {
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				bo.setRespCode(BaseCode.FAIL_CODE);
				bo.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
			return bo;
		}
		return bo;
	}

	@Override
	public RespBaseBO delect(Long id) {
		// TODO Auto-generated method stub
		RespBaseBO bo=new RespBaseBO();
		try {
			int a=fruitYOrderDAO.delect(id);
			if(a>0) {
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				bo.setRespCode(BaseCode.FAIL_CODE);
				bo.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
			return bo;
		}
		return bo;
	}

	@Override
	public QueryFruitYOrderBO selectByUserId(Long id) {
		// TODO Auto-generated method stub
		QueryFruitYOrderBO queryFruitYOrderBO=new QueryFruitYOrderBO();
		List<FruitYOrderBO> bolist=new ArrayList<>();
		try {
			List<FruitYOrderPO> polist=fruitYOrderDAO.selectByUserId(id);
			if(polist!=null&&polist.size()>0) {
				for(FruitYOrderPO po:polist) {
					FruitYOrderBO bo=new FruitYOrderBO();
					bo.setCommondityId(po.getCommondityId());
					bo.setComName(po.getComName());
					bo.setComPrice(po.getComPrice());
					bo.setFruitNum(po.getFruitNum());
					bo.setFruitUserId(po.getFruitUserId());
					bo.setyOrderId(po.getyOrderId());
					bo.setComPhDress(po.getComPhDress());
					if("true".equals(po.getSelected())) {
						bo.setSelected(true);
					}else {
						bo.setSelected(false);
					}
					bolist.add(bo);
				}
				queryFruitYOrderBO.setFruitYOrderBO(bolist);
				queryFruitYOrderBO.setRespCode(BaseCode.SUCCESS_CODE);
				queryFruitYOrderBO.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				queryFruitYOrderBO.setRespCode(BaseCode.SUCCESS_CODE);
				queryFruitYOrderBO.setRespDesc("查询为空");
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			queryFruitYOrderBO.setRespCode(BaseCode.FAIL_CODE);
			queryFruitYOrderBO.setRespDesc(BaseCode.FAIL_DESC);
			return queryFruitYOrderBO;
		}
		
		return queryFruitYOrderBO;
	}
	
	public RespBaseBO updateNum(FruitYOrderBO fruitYOrderBO) {
		RespBaseBO bo=new RespBaseBO();
		try {
			FruitYOrderPO po=new FruitYOrderPO();
			po.setFruitNum(fruitYOrderBO.getFruitNum());
			po.setFruitUserId(fruitYOrderBO.getFruitUserId());
			po.setCommondityId(fruitYOrderBO.getCommondityId());
			int a=fruitYOrderDAO.update(po);
			if(a>0) {
				bo.setRespCode(BaseCode.SUCCESS_CODE);
				bo.setRespDesc(BaseCode.SUCCESS_DESC);
			}else{
				bo.setRespCode(BaseCode.FAIL_CODE);
				bo.setRespDesc(BaseCode.FAIL_DESC);
			}
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
			return bo;
		}
		return bo;
	}

}
