var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;

/**
 * function for branching to the corresponding logic when a button on the screen is pressed.
 */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var formObj = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (srcName == null) {
			return;
		}
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
			case "btn_New":
				sheetObject1.RemoveAll();
        		formObj.reset();
        		break;
        	case "btn_Close":
        		ComClosePopup(); 
        		break;
        	case "btn_OK":
        		comPopupOK();
        		break;
        	case "btn_Down_Excel":
        		if(sheetObject1.RowCount() < 1){
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheetObject1.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObject1),Merge:false,FileName:"Rev Lane"});
        		} 	    	    	
    	        break;
			default :
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * functions that calls a common function that sets the default settings of the sheet.
 * It is the first called area when fire jsp onload event
 */
function loadPage(){
	//generate Grid Layout
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//auto search data after loading finish.
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * function to put sheet objects in global variable "sheetObjects"
 * 
 * @param sheet_obj  IBSheet Object
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * functions that define the basic properties of the sheet on the screen
 * 
 * @param sheetObj  IBSheet Object
 * @param sheetNo   Number of IBSheet Object
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle = "STS|Select|Rev.Lane|Full Rev|Full Name";
				
				SetConfig({SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 0});
				
	
				var info = {Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1};
				var headers = [ { Text : HeadTitle, Align : "Center" }];
				InitHeaders(headers, info);
				
				var cols = [
//				           	{ Type : "Status", Hidden : 1, Width : 50,  Align : "Center", SaveName : "ibflag" }, 
				            {Type : "Radio",  Hidden:0, Width:50,  Align:"Center", SaveName:"radio",           KeyField:0, UpdateEdit:1, InsertEdit:1}, 
				            {Type:"CheckBox", Hidden:0, Width:20,  Align:"Center", SaveName:"checkbox",        KeyField:0, UpdateEdit:1, InsertEdit:1},
				            {Type : "Text",   Hidden:0, Width:100, Align:"Center", SaveName:"vsl_slan_cd",     KeyField:1, UpdateEdit:0, InsertEdit:1}, 
				            {Type : "Text",   Hidden:0, Width:100, Align:"Center", SaveName:"rlane_cd",        KeyField:1, UpdateEdit:0, InsertEdit:1}, 
				            {Type : "Text",   Hidden:0, Width:500, Align:"Left",   SaveName:"rlane_nm", KeyField:1, UpdateEdit:0, InsertEdit:1} 				          
				           ];
				InitColumns(cols);
				SetEditable(1);
				SetWaitImageVisible(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 16));
			}
			break;
		
	}
}

/**
 * functions that define transaction logic between UI and server
 * 
 * @param sheetObj  IBSheet Object
 * @param formObj   Form Object
 * @param sAction   Action code
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
	switch (sAction) {
		case IBSEARCH: // retrieve
			formObj.f_cmd.value = SEARCH;
			ComOpenWait(true);
			sheetObj.DoSearch("REV_LANE_004POPUPGS.do", FormQueryString(formObj));
			break;
	}
}

/**
 * Handling event after search.
 * 
 * @param sheetObj
 * @param Code
 * @param Msg
 * @param StCode
 * @param StMsg
 */
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
 	ComOpenWait(false); 	
}