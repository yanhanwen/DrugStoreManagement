package com.dsm.model.dao.impl;

import com.dsm.model.entity.Stock;

public class StockDao extends BaseDao<Stock>
{
	public void addObject(Object obj)
	{
		Stock Stock = (Stock) obj;
		String sql = "insert into Stock(StockNo,MedicineNo,WarehouseNo,ShelfNo,Count,Cost,ProductDate,ValidPeriod) values(?,?,?,?,?,?,?,?,?)";
		update(sql,Stock.getStockNo(),Stock.getMedicineNo(),Stock.getWarehouseNo(),Stock.getShelfNo(),Stock.getCount(),
				Stock.getCost(),Stock.getProductDate(),Stock.getValidPeriod());
	}
	public void deleteObjectByKey(Object key)
	{
		String StockNo = (String)key;
		String sql = "delete from Stock where StockNo=?";
		update(sql, StockNo);
	}
}
