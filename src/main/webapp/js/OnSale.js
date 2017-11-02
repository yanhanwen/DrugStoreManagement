/**
 * StyleFix 1.0.3 & PrefixFree 1.0.7
 * @author Lea Verou
 * MIT license
*/
var script=document.createElement("script");  
script.type="text/javascript";  
script.src="jquery-3.2.1.min.js"; 
function checkAddInfo(){
     	var onSaleNo = document.getElementById("onSaleNo").value;
     	var medicineNo = document.getElementById("medicineNo").value;
     	var storeNo = document.getElementById("storeNo").value;
     	var saleNum = document.getElementById("saleNum").value;
     	var price = document.getElementById("price").value;
     	var cost = document.getElementById("cost").value;
     	var message = document.getElementById("message").value;
     	var errorInfo="";
     	if (onSaleNo=="") {
     		errorInfo+="在售编号不可为空\n";
     	}
     	if (medicineNo=="") {
     		errorInfo+="药品编号不可为空\n";
     	}
     	if (storeNo=="") {
     		errorInfo+="药店编号不可为空\n";
     	}
     	if (saleNum=="") {
     		errorInfo+="药品在售数量不可为空\n";
     	}
     	if (price=="") {
     		errorInfo+="售价不可为空\n";
     	}
     	if (price<=0) {
     		errorInfo+="售价不可小于等于0\n";
     	}
     	if (cost=="") {
     		errorInfo+="进价不可为空\n";
     	}
     	if (cost<=0) {
     		errorInfo+="进价不可小于等于0\n";
     	}
     	if(errorInfo==""){
     		document.getElementById("addMedicineForm").submit();
     		alert(message);
     	}  	
     	else{
     		alert(errorInfo);
         	return false; 	
     	}	
    }
function checkSellInfo(){
	var sellNo = document.getElementById("sellNo").value;
	var saleNum = document.getElementById("sellNum").value;
	var errorInfo="";
	if (sellNo=="") {
 		errorInfo+="药品编号不可为空\n";
 	}
	if (sellNum=="") {
 		errorInfo+="药品在售数量不可为空\n";
 	}
	if (sellNum<=0) {
 		errorInfo+="药品在售数量不可小于等于0\n";
 	}
	if(errorInfo==""){
 		document.getElementById("sellMedicineForm").submit();
 	}  	
 	else{
     	return false; 	
 	}
	
}
function showAddInfo(w,h){ 
	var baseText = null;
	var popUp = document.getElementById("addInfo"); 
	popUp.style.top = "200px"; 
	popUp.style.left = "200px"; 
	popUp.style.width = w + "px"; 
	popUp.style.height = h + "px" 
	popUp.style.visibility = "visible"; 
	} 
	function hideAddInfo(){ 
	var popUp = document.getElementById("addInfo"); 
	popUp.style.visibility = "hidden"; 
	} 
	
	
	function showSellInfo(w,h){ 
		var baseText = null;
		var popUp = document.getElementById("sellInfo"); 
		popUp.style.top = "200px"; 
		popUp.style.left = "200px"; 
		popUp.style.width = w + "px"; 
		popUp.style.height = h + "px" 
		popUp.style.visibility = "visible"; 
		} 
	
	function hideSellInfo(){ 
		var popUp = document.getElementById("sellInfo"); 
		popUp.style.visibility = "hidden"; 
		} 
	
	function altRows(id){
		if(document.getElementsByTagName){  
				
			var table = document.getElementById(id);  
			var rows = table.getElementsByTagName("tr");  
			for(i = 0; i < rows.length; i++){          
				if(i % 2 == 0){
					rows[i].className = "evenrowcolor";
				}else{
					rows[i].className = "oddrowcolor";
				}      
			}
		}
	}

		window.onload=function(){
			altRows('alternatecolor');
		}
	
		
		