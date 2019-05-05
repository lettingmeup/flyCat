package com.whuahua.smart.fruit.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.whuahua.smart.fruit.bo.FruitCommondityBO;
import com.whuahua.smart.fruit.bo.QueryFruitCommondityBO;
import com.whuahua.smart.fruit.dao.FruitCommondityDAO;
import com.whuahua.smart.fruit.po.FruitCommondityPO;
import com.whuahua.smart.fruit.service.QueryFruitCommondityService;
import com.whuahua.smart.fruit.util.BaseCode;
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
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
			queryFruitCommondityBO.setRespCode(BaseCode.FAIL_CODE);
			queryFruitCommondityBO.setRespDesc(BaseCode.FAIL_DESC);
			return queryFruitCommondityBO;
		}
		
		return queryFruitCommondityBO;
	}
	 public QueryFruitCommondityBO queryById(Long id) {
		 QueryFruitCommondityBO bo=new QueryFruitCommondityBO();
		 try {
			 FruitCommondityPO po= fruitCommondityDAO.queryById(id);
			 bo.setFruitCommondityPO(po);
			 bo.setRespCode(BaseCode.SUCCESS_CODE);
			 bo.setRespDesc(BaseCode.SUCCESS_DESC);
		} catch (Exception e) {
			// TODO: handle exception
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
		}
		
		 return bo;
	 }
	 public QueryFruitCommondityBO queryByLikeName(String name) {
		 QueryFruitCommondityBO bo=new QueryFruitCommondityBO();
		 try {
			 FruitCommondityPO po= fruitCommondityDAO.queryByLikeName(name);
			 bo.setFruitCommondityPO(po);
			 bo.setRespCode(BaseCode.SUCCESS_CODE);
			 bo.setRespDesc(BaseCode.SUCCESS_DESC);
		} catch (Exception e) {
			// TODO: handle exception
			bo.setRespCode(BaseCode.FAIL_CODE);
			bo.setRespDesc(BaseCode.FAIL_DESC);
		}
		
		 return bo;
	 }

}
