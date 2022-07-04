package com.clt.apps.opus.practice4.revlane.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.practice4.emmsgmgmt.vo.CustomerVO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.RevLaneVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;

public class REVLANEHTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * CUSTOMERHTMLAction function constructor
	 */
	public REVLANEHTMLAction(){
		
	}
	
	/**
	 * Parsing the value of HTML DOM object as a Java variable<br>
	 * Parsing the information of HttpRequest as Practice1Event and setting it in the request<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event An object that implements the Event interface.
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		RevLaneEvent event = new RevLaneEvent();
		
		if(command.isCommand(FormCommand.SEARCH)) {	
			RevLaneVO revLaneVO = new RevLaneVO();
			revLaneVO.setVslSlanCd(JSPUtil.getParameter(request, "s_vsl_slan_cd", ""));
			event.setRevLaneVO(revLaneVO);
		}
		
		return event;
	}
	
	/**
	 * Storing the business scenario execution result value in the attribute of HttpRequest<br>
	 * Setting the ResultSet that transmits the execution result from ServiceCommand to View (JSP) in the request<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse object that implements the interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}
	
	/**
	 * Saving HttpRequest parsing result value in HttpRequest attribute<br>
	 * HttpRequest parsing result value set in request<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event object that implements the interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}
