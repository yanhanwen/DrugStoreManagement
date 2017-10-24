package com.dsm.model.dao.impl;

import com.dsm.model.entity.LeaveWare;

public class LeaveWareDao extends BaseDao<LeaveWare>
{
	public void addObject(Object obj)
	{
		LeaveWare LeaveWare = (LeaveWare)obj;
		String sql = "insert into LeaveWare(LeaveNo,MedicineNo,WarehouseNo,StoreNo,Cost,LeaveCount,LeaveTime,WareManNo) values(?,?,?,?,?,?,?,?)";
		update(sql,LeaveWare.getLeaveno(),LeaveWare.getMedicineno(),LeaveWare.getWarehouseno(),LeaveWare.getStoreno(),
				LeaveWare.getCost(),LeaveWare.getLeavecount(),LeaveWare.getLeavetime(),LeaveWare.getWaremanno());
	}
	public void deleteObjectByKey(Object key)
	{
		String LeaveNo = (String)key;
		String sql = "delete from LeaveWare where LeaveNo=?";
		update(sql, LeaveNo);
	}
}
