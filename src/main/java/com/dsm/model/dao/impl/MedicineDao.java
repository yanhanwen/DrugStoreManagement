package com.dsm.model.dao.impl;

import com.dsm.model.entity.Medicine;

public class MedicineDao extends BaseDao<Medicine>
{
	public void addObject(Object obj)
	{
		Medicine Medicine = (Medicine) obj;
		String sql = "insert into Medicine(MedicineNo,MedicineName,Category,Factory,Indication,StorageCond,LifeTime) values(?,?,?,?,?,?,?)";
		update(sql,Medicine.getMedicineNo(),Medicine.getMedicineName(),Medicine.getCategory(),Medicine.getFactory(),
				Medicine.getIndication(),Medicine.getStorageCond(),Medicine.getLifeTime());
	}
	public void deleteObjectByKey(Object key)
	{
		String MedicineNo = (String)key;
		String sql = "delete from Medicine where MedicineNo=?";
		update(sql, MedicineNo);
	}
}
