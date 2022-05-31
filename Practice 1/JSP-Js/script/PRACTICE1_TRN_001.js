/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : PRACTICE1_TRN_001.js
*@FileTitle : Practice 1
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2022.05.24 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class PRACTICE1_TRN_001 : PRACTICE1_TRN_001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;

	/** Definition of the button  */
	function processButtonClick() {
		/** *** setting sheet object **** */
		var sheetObject1 = sheetObjects[0];
		/** **************************************************** */
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
				case "btn_Add":
				doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject1, formObj, IBDOWNEXCEL);
					break;
				default :
					break;}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('JOO00001');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
	function loadPage(){
		//Generate Grid Layout
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//Auto search data after loading finish.
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/** Create sheet */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch (sheetNo) {
		case 1: // Sheet1 init
			with (sheetObj) {
	
				var HeadTitle = "STS|Del|Message Code|Message Type|Message Level|Message|Description";
				// ComCountHeadTitle find in the CoObject.js
				// Create Header with split |
				var headCount = ComCountHeadTitle(HeadTitle);
				// (headCount, 0, 0, true);
				
				
				// SetConfig is may configure how to fetch initialized sheet, location of frozen rows  or columns and other basic configurations.
				// SearchMode is where you can configure search mode by selecting one from General, Paging, LazyLoad or real-time
				// MergeSheet is where you can configure merge styles. The default value is msNone
				// Page is where you may configure paging unit size for paging mode, LazyLoad mode or real-time server processing mode. The default value is 20
				// DataRowMerge can be used to configure whether to allow horizontal merge of the  entire row. The default value is 0.
				SetConfig({SearchMode : 2, MergeSheet : 5, Page : 20, DataRowMerge : 0});
	
				var info = {Sort : 1, ColMove : 1, HeaderCheck : 0, ColResize : 1};
				var headers = [ { Text : HeadTitle, Align : "Center" }];
				// You can define the header title and function using this method
				InitHeaders(headers, info);
				
				var cols = [ 
		             { Type : "Status", Hidden : 1, Width : 50, Align : "Center", ColMerge : 0, SaveName : "ibflag" }, 
		             { Type : "DelCheck", Hidden : 0, Width : 50, Align : "Center", ColMerge : 0, SaveName : "del_chk" }, 
		             { Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "err_msg_cd", KeyField : 1, Format : "", UpdateEdit : 0, InsertEdit : 1, EditLen: 8,BackColor: "#D7DBDD" }, 
		             { Type : "Combo", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "err_tp_cd", KeyField : 1, Format : "", UpdateEdit : 1, InsertEdit : 1, EditLen: 5,ComboText:"Server|UI|Both",ComboCode:"S|U|B"  }, 
		             { Type : "Combo", Hidden : 0, Width : 120, Align : "Center", ColMerge : 0, SaveName : "err_lvl_cd", KeyField : 1, Format : "", UpdateEdit : 1, InsertEdit : 1 , EditLen: 6,ComboText:"ERR|WARNING|INFO", ComboCode:"E|W|I" }, 
		             { Type : "Text", Hidden : 0, Width : 520, Align : "Left", ColMerge : 0, SaveName : "err_msg", KeyField : 1, Format : "", UpdateEdit : 1, InsertEdit : 1 , EditLen: 4 }, 
		             { Type : "Text", Hidden : 0, Width : 120, Align : "Left", ColMerge : 0, SaveName : "err_desc", KeyField : 1, Format : "", UpdateEdit : 1, InsertEdit : 1 , EditLen: 6 } 
		             ];
	
				InitColumns(cols);
				SetEditable(1);
				SetWaitImageVisible(0);
				resizeSheet();
			}
			break;
		}
	
	}
	/** Set hight sheet */
	function resizeSheet() {
		ComResizeSheet(sheetObjects[0]);
	}
	/** Save the change values sheet */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/** ComSheetObject() in jsp file call. Find in the CoObject.js */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}
	/** Handle buttons */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch (sAction) {
		case IBSEARCH: // Retrieve
			// Set values f_cmd
			formObj.f_cmd.value = SEARCH;
			// Set dim display 
			ComOpenWait(true);		
			// DoSave have GetSearchData and LoadSearchData
			sheetObj.DoSearch("PRACTICE1_TRN_001GS.do", FormQueryString(formObj));
			break;
		case IBSAVE: // Save		
			if(!validateForm(sheetObj))  return false;
			formObj.f_cmd.value = MULTI;
			// DoSave have GetSaveData and LoadSaveData
			sheetObj.DoSave("PRACTICE1_TRN_001GS.do", FormQueryString(formObj));
			break;
		case IBINSERT: //Row Add button event
			sheetObj.DataInsert();
			break;
		case IBDOWNEXCEL: // Down Excel button event
			// Check row of the sheet
			if(sheetObj.RowCount() < 1){
				ComShowCodeMessage("COM132501");
			}else { 
				cfg= {FileName:"DownExcel.xls", Merge:1,SheetDesign:1, ExcelFontSize:13};
				// Set value file Down2Excel
				sheetObj.SetDown2ExcelConfig(cfg);
				// Down file Excel	
				// MakeHiddenSkipCol is not down columns radio,check box,status,.. 
				sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj)});
			}
			break;
		}
	}
	/** Handling after DoSearch */
	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	 	ComOpenWait(false);
	}
	/** Function handling after DoSave */
	function sheet1_OnSaveEnd(sheetObj, Code) { 
		if(Code >= 0) {
			ComShowCodeMessage('COM130102', sheetObj.id);	// saving success message;
		} else {
			ComShowCodeMessage('COM130103',sheetObj.id);	// saving failure message
		}
	}

	/** Check validation input */
	function validateForm(sheetObj) {
		// Create variables regex with the first 3 characters are upper with the last 5 numbers from 0 to 9
		var regex = new RegExp("^([A-Z]{3})([0-9]{5})$");
		if(!regex.test(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"err_msg_cd"))){
			alert('Malformed : the first 3 characters are uppercase letters, the last 5 characters are numbers'); 
			return false;
		}
		return true;
	}
	
	
	function PRACTICE1_TRN_001() {
	    	this.processButtonClick		= tprocessButtonClick;
	    	this.setSheetObject 		= setSheetObject;
	    	this.loadPage 				= loadPage;
	    	this.initSheet 				= initSheet;
	    	this.initControl            = initControl;
	    	this.doActionIBSheet 		= doActionIBSheet;
	    	this.setTabObject 			= setTabObject;
	    	this.validateForm 			= validateForm;
	}
    
   	/* 개발자 작업	*/


	/* 개발자 작업  끝 */