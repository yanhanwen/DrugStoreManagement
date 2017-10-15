package com.dsm.model.dao.impl;

import com.dsm.model.entity.LeaveWare;

public class LeaveWareDao extends BaseDao<LeaveWare>
{
	public void addObject(Object obj)
	{
		LeaveWare LeaveWare = (LeaveWare)obj;
		String sql = "insert into LeaveWare(LeaveNo,MedicineNo,WarehouseNo,StoreNo,Cost,EnterNo,LeaveCount,LeaveTime,WareManNo) values(?,?,?,?,?,?,?,?,?)";
		update(sql,LeaveWare.getLeaveNo(),LeaveWare.getMedicineNo(),LeaveWare.getWarehouseNo(),LeaveWare.getStoreNo(),
				LeaveWare.getCost(),LeaveWare.getEnterNo(),LeaveWare.getLeaveCount(),LeaveWare.getLeaveTime(),LeaveWare.getWareManNo());
	}
	public void deleteObjectByKey(Object key)
	{
		String LeaveNo = (String)key;
		String sql = "delete from LeaveWare where LeaveNo=?";
		update(sql, LeaveNo);
	}
}
