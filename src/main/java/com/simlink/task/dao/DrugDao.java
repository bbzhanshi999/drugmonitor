package com.simlink.task.dao;

import java.util.List;

import com.simlink.common.annotation.MyBatisDao;
import com.simlink.task.entity.TSiipDruginstore;
import com.simlink.task.entity.TSiipDruginstoredetail;
import com.simlink.task.entity.TSiipDrugoutstore;
import com.simlink.task.entity.TSiipDrugoutstoredetail;
import com.simlink.task.entity.TSiipDrugstoragestock;
import com.simlink.task.entity.TSiipInvdrugstore;
import com.simlink.task.entity.TSiipInvdrugstoredetail;
import com.simlink.task.entity.TSiipSendcollectdetail;
import com.simlink.task.entity.TSiipSendlist;
import com.simlink.task.entity.TSiipSendlistcollect;
import com.simlink.task.entity.TSiipSendlistdetail;


@MyBatisDao
public interface DrugDao {

	/**
	 * 药品入库主表  高效批量入库
	 * @param entityList 列表
	 */
	public int saveAllTSiipDruginstore(List<TSiipDruginstore> entityList);
	/**
	 * 药品入库详情信息  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDruginstoredetail(List<TSiipDruginstoredetail> entityList);
	/**
	 * 药品出库主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDrugoutstore(List<TSiipDrugoutstore> entityList);
	/**
	 * 药品出库明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDrugoutstoredetail(List<TSiipDrugoutstoredetail> entityList);
	/**
	 * 盘存库存记录主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipDrugstoragestock(List<TSiipDrugstoragestock> entityList);
	/**
	 * 盘存库存记录表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipInvdrugstore(List<TSiipInvdrugstore> entityList);
	/**
	 * 盘存库存记录明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipInvdrugstoredetail(List<TSiipInvdrugstoredetail> entityList);
	/**
	 * 发药汇总明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendcollectdetail(List<TSiipSendcollectdetail> entityList);
	/**
	 * 发药单主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendlist(List<TSiipSendlist> entityList);
	/**
	 * 发药单药品汇总主表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendlistcollect(List<TSiipSendlistcollect> entityList);
	/**
	 * 发药单明细表  高效批量入库
	 * @param entityList 列表
	 */
	public int  saveTSiipSendlistdetail(List<TSiipSendlistdetail> entityList);
}