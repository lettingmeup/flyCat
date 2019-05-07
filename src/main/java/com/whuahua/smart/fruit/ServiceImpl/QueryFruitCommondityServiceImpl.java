package com.whuahua.smart.fruit.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.whuahua.smart.fruit.bo.FruitCommondityBO;
import com.whuahua.smart.fruit.bo.QueryFruitCommondityBO;
import com.whuahua.smart.fruit.dao.FruitCommondityDAO;
import com.whuahua.smart.fruit.po.FruitCommondityPO;
import com.whuahua.smart.fruit.service.QueryFruitCommondityService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional
public class QueryFruitCommondityServiceImpl implements QueryFruitCommondityService {
@Autowired
private FruitCommondityDAO fruitCommondityDAO;
	@Override
	public QueryFruitCommondityBO queryAll(){
		// TODO Auto-generated method stub
		QueryFruitCommondityBO queryFruitCommondityBO=new QueryFruitCommondityBO();
		List<FruitCommondityBO> fruitCommondityBOlist=new ArrayList<>();
		try {
			List<FruitCommondityPO> polist=fruitCommondityDAO.queryAll();
			if(polist!=null&&polist.size()>0) {
				for(FruitCommondityPO po:polist) {
					FruitCommondityBO bo=new FruitCommondityBO();
					bo.setCommondityId(po.getCommondityId());
					bo.setComName(po.getComName());
					bo.setComPhDress(po.getComPhDress());
					bo.setComPrice(po.getComPrice());
					fruitCommondityBOlist.add(bo);
				}
				queryFruitCommondityBO.setFruitCommondityBOList(fruitCommondityBOlist);
				queryFruitCommondityBO.setRespCode(BaseCode.SUCCESS_CODE);
				queryFruitCommondityBO.setRespDesc(BaseCode.SUCCESS_DESC);
			}else {
				queryFruitCommondityBO.setRespCode(BaseCode.SUCCESS_CODE);
				queryFruitCommondityBO.setRespDesc("查询为空");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			queryFruitCommondityBO.setRespCode(BaseCode.FAIL_CODE);
			queryFruitCommondityBO.setRespDesc(BaseCode.FAIL_DESC);
			return queryFruitCommondityBO;
		}
		
		return queryFruitCommondityBO;
	}
	 public QueryFruitCommondityBO queryById(Long id) {
		 QueryFruitCommondityBO bo=new QueryFruitCommondityBO();
		 List<FruitCommondityBO> bolist=new ArrayList<>();
		 try {
			 FruitCommondityPO po= fruitCommondityDAO.queryById(id);
			 FruitCommondityBO fruitCommondityBO=new FruitCommondityBO();
			 if(po!=null) {
				 fruitCommondityBO.setCommondityId(po.getCommondityId());
				 fruitCommondityBO.setComName(po.getComName());
				 fruitCommondityBO.setComPhDress(po.getComPhDress());
				 fruitCommondityBO.setComPrice(po.getComPrice());
			 }
			 
			 bolist.add(fruitCommondityBO);
			 bo.setFruitCommondityBOList(bolist);
			 bo.setRespCode(BaseCode.SUCCESS_CODE);
			 bo.setRespDesc(BaseCode.SUCCESS_DESC);
		} catch (Exception e) {
			// TODO: handle exception
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			System.out.println(e.getMessage());
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
			return bo;
		}
		
		 return bo;
	 }
	 public QueryFruitCommondityBO queryByLikeName(String name) {
		 QueryFruitCommondityBO bo=new QueryFruitCommondityBO();
		 List<FruitCommondityBO> bolist=new ArrayList<>();
		 try {
			 FruitCommondityPO po= fruitCommondityDAO.queryByLikeName(name);
			 FruitCommondityBO fruitCommondityBO=new FruitCommondityBO();
			 if(po!=null) {
				 fruitCommondityBO.setCommondityId(po.getCommondityId());
				 fruitCommondityBO.setComName(po.getComName());
				 fruitCommondityBO.setComPhDress(po.getComPhDress());
				 fruitCommondityBO.setComPrice(po.getComPrice());
			 }
			 
			 bolist.add(fruitCommondityBO);
			 bo.setFruitCommondityBOList(bolist);
			 bo.setRespCode(BaseCode.SUCCESS_CODE);
			 bo.setRespDesc(BaseCode.SUCCESS_DESC);
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
