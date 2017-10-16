package com.dsm.model.entity;

/*
仓库环境，用于保存各仓库可以提供的所有药品储存条件
*/
public class WarehouseEnvir
{
	private String envirNo;			//环境编号
    private String warehouseNo;     //仓库编号，主键，外键，非空
    private String condition;       //储存环境，主键，非空
    private String area;            //储存区域
	public String getEnvirNo() {
		return envirNo;
	}
	public void setEnvirNo(String envirNo) {
		this.envirNo = envirNo;
	}
	public String getWarehouseNo() {
		return warehouseNo;
	}
	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public WarehouseEnvir(String envirNo, String warehouseNo, String condition, String area) {
		super();
		this.envirNo = envirNo;
		this.warehouseNo = warehouseNo;
		this.condition = condition;
		this.area = area;
	}
	
}
