package com.dsm.model.dao.impl;

import com.dsm.model.entity.Supplier;

public class SupplierDao extends BaseDao<Supplier>
{
	private String key;
	public void addObject(Object obj)
	{
		Supplier Supplier = (Supplier) obj;
		String sql = "insert into Supplier(SupplierNo,SupplierName,ContactName,Telephone,Province,City,District,Street,AddrDetail,Rate,AddDate,Remark,OnDuty) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String key=update(sql,Supplier.getSupplierno(),Supplier.getSuppliername(),Supplier.getContactname(),Supplier.getTelephone(),
					Supplier.getProvince(),Supplier.getCity(),Supplier.getDistrict(),Supplier.getStreet(),Supplier.getAddrdetail(),
					Supplier.getRate(),Supplier.getAdddate(),Supplier.getRemark(),Supplier.getOnduty());
		this.key=key;
	}
	public String getKey()
	{
		return key;
	}
	public void deleteObjectByKey(Object key)
	{
		String SupplierNo = (String)key;
		String sql = "delete from Supplier where SupplierNo=?";
		update(sql, SupplierNo);
	}
}
