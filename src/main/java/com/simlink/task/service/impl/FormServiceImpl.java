package com.simlink.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simlink.task.dao.DrugDao;
import com.simlink.task.entity.TSiipDruginstore;
import com.simlink.task.entity.TSiipDruginstoredetail;
import com.simlink.task.entity.TSiipDrugoutstore;
import com.simlink.task.entity.TSiipDrugoutstoredetail;
import com.simlink.task.entity.TSiipDrugstoragestock;
import com.simlink.task.entity.TSiipInvdrugstore;
import com.simlink.task.entity.TSiipInvdrugstoredetail;
import com.simlink.task.entity.TSiipRecipe;
import com.simlink.task.entity.TSiipSendcollectdetail;
import com.simlink.task.entity.TSiipSendlist;
import com.simlink.task.entity.TSiipSendlistcollect;
import com.simlink.task.entity.TSiipSendlistdetail;
import com.simlink.task.service.FormService;
@Service("formService")
public class FormServiceImpl implements FormService {
	
	@Autowired
	private DrugDao drugInStoreDao;
	
	/**
	 * 药品入库主表  高效批量入库
	 * @param entityList 列表
	 */
	public int saveAllTSiipDruginstore(List<TSiipDruginstore> entityList){
		return drugInStoreDao.saveAllTSiipDruginstore(entityList);
	}
	/**
	 * 药品入库详情信息  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDruginstoredetail(List<TSiipDruginstoredetail> entityList){
		return drugInStoreDao.saveTSiipDruginstoredetail(entityList);
	}
	/**
	 * 药品出库主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDrugoutstore(List<TSiipDrugoutstore> entityList){
		return drugInStoreDao.saveTSiipDrugoutstore(entityList);
	}
	/**
	 * 药品出库明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDrugoutstoredetail(List<TSiipDrugoutstoredetail> entityList){
		return drugInStoreDao.saveTSiipDrugoutstoredetail(entityList);
	}
	/**
	 * 盘存库存记录主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDrugstoragestock(List<TSiipDrugstoragestock> entityList){
		return drugInStoreDao.saveTSiipDrugstoragestock(entityList);
	}
	/**
	 * 盘存库存记录表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipInvdrugstore(List<TSiipInvdrugstore> entityList){
		return drugInStoreDao.saveTSiipInvdrugstore(entityList);
	}
	/**
	 * 盘存库存记录明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipInvdrugstoredetail(List<TSiipInvdrugstoredetail> entityList){
		return drugInStoreDao.saveTSiipInvdrugstoredetail(entityList);
	}
	/**
	 * 发药汇总明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendcollectdetail(List<TSiipSendcollectdetail> entityList){
		return drugInStoreDao.saveTSiipSendcollectdetail(entityList);
	}
	/**
	 * 发药单主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendlist(List<TSiipSendlist> entityList){
		return drugInStoreDao.saveTSiipSendlist(entityList);
	}
	/**
	 * 发药单药品汇总主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendlistcollect(List<TSiipSendlistcollect> entityList){
		return drugInStoreDao.saveTSiipSendlistcollect(entityList);
	}
	/**
	 * 发药单明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendlistdetail(List<TSiipSendlistdetail> entityList){
		return drugInStoreDao.saveTSiipSendlistdetail(entityList);
	}
	
	public int  saveTSiipRecipe(List<TSiipRecipe> entityList){
		return drugInStoreDao.saveTSiipRecipe(entityList);
	}
}
