package com.dsm.model.dao.impl;

import com.dsm.model.entity.Supplier;

public class SupplierDao extends BaseDao<Supplier>
{
	public void addObject(Object obj)
	{
		Supplier Supplier = (Supplier) obj;
		String sql = "insert into Supplier(SupplierNo,SupplierName,ContactName,Telephone,Province,City,District,Street,AddrDetail,Rate,AddDate,Remark,OnDuty) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		update(sql,Supplier.getSupplierNo(),Supplier.getSupplierName(),Supplier.getContactName(),Supplier.getTelephone(),
				Supplier.getProvince(),Supplier.getCity(),Supplier.getDistrict(),Supplier.getStreet(),Supplier.getAddrDetail(),
				Supplier.getRate(),Supplier.getAddDate(),Supplier.getRemark(),Supplier.getOnDuty());
	}
	public void deleteObjectByKey(Object key)
	{
		String SupplierNo = (String)key;
		String sql = "delete from Supplier where SupplierNo=?";
		update(sql, SupplierNo);
	}
}
