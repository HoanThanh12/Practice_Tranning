/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : TrainingSC.java
 *@FileTitle : Practice 3
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2022.06.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2022.04.22
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice3.emmsgmgmt.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.GeneralEventResponse;

public class Practice3Trn003ViewAdapterDL extends ViewAdapter{

	
	public String makeXML(HttpServletRequest request, HttpServletResponse response) {
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		request.setAttribute("SHEETDATA", eventResponse.getRsVoList());
		String forwardPath="./js/ibsheet/jsp/DirectDown2Excel.jsp" ; 
	    RequestDispatcher rd=request.getRequestDispatcher(forwardPath); 
	    try {
			rd.forward(request,response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@Override
	protected String makeDataTag(List<AbstractValueObject> arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}