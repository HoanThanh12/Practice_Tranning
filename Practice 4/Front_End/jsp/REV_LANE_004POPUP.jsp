<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.practice4.revlane.event.RevLaneEvent"%>

<%
	RevLaneEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	try {
		event = (RevLaneEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="pagerows">
	
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span id="title1">Rev Lane</span></h2>
			<div class="opus_design_btn">
			   	<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_Down_Excel" id="btn2_Down_Excel">Down Excel</button><!-- 
				--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button><!-- 
				--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
			</div>
		    <div class="location">
		     	<span id="navigation"></span>
		    </div>
		</div>
	</div>
	
	<div class="wrap_search">
		<div class="opus_design_inquiry">
		    <table>
		        <tbody>
					<tr>
						<th width="40">Rev Lane</th>
						<td width="">
							<input type="text" style="width:100px;"class="input" value="" name="s_vsl_slan_cd" id="s_vsl_slan_cd">
						</td>
					</tr> 
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>	
	</div>
</form>