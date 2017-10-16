package com.dsm.model.entity;

/*
浠撳簱鐜锛岀敤浜庝繚瀛樺悇浠撳簱鍙互鎻愪緵鐨勬墍鏈夎嵂鍝佸偍瀛樻潯浠�
*/
public class WarehouseEnvir
{
	private String envirNo;			//鐜缂栧彿
    private String warehouseNo;     //浠撳簱缂栧彿锛屼富閿紝澶栭敭锛岄潪绌�
    private String condition;       //鍌ㄥ瓨鐜锛屼富閿紝闈炵┖
    private String area;            //鍌ㄥ瓨鍖哄煙
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
	public WarehouseEnvir()
	{
		
	}
}
