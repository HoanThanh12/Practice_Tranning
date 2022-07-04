/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : TrainingSC.java
 *@FileTitle : Practice 4
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2022.06.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2022.05.16
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice4;

import java.util.List;

import com.clt.apps.opus.practice4.customer.event.CustomerEvent;
import com.clt.apps.opus.practice4.emmsgmgmt.basic.Practice4MgmtBC;
import com.clt.apps.opus.practice4.emmsgmgmt.basic.Practice4MgmtBCImpl;
import com.clt.apps.opus.practice4.emmsgmgmt.event.Practice4Trn004Event;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.CarrierVO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.CustomerVO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.RevLaneVO;
import com.clt.apps.opus.practice4.revlane.event.RevLaneEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Practice4 Business Logic Service Command - Process the business transaction for ALPS-Practice4.
 * 
 * @author Dang Hoan Thanh
 * @see CarrierMgmtDBDAO
 * @since J2EE 1.6
 */
public class TrainingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	/**
	 * Practice4 system work scenario precedent work<br>
	 * Creating related internal objects when calling a business scenario<br>
	 */
	public void doStart() {
		log.debug("Start TrainingSC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Practice4 system work scenario finishing work<br>
	 * Release related internal objects at the end of the business scenario<br>
	 */
	public void doEnd() {
		log.debug("TrainingSC end");
	}
	
	/**
	 * Carry out business scenarios corresponding to each event<br>
	 * Branch processing of all events occurring in the ALPS-Practice4 system business<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("Practice4Trn004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCarrier(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = initData();
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageCarrier(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("CustomerEvent")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomer(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("RevLaneEvent")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevLane(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * Search list carrier data.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCarrier(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice4Trn004Event event = (Practice4Trn004Event)e;
		Practice4MgmtBC command = new Practice4MgmtBCImpl();

		try{
			List<CarrierVO> list = command.searchCarrierCarrierMgmt(event.getCarrierVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Generate ETCData for CarrierCode and RlaneCode
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse initData() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice4MgmtBC command = new Practice4MgmtBCImpl();
		try{
			List<CarrierVO> listCarrier = command.searchCarrierCombo();
			StringBuilder carrierBuilder = new StringBuilder();
			if (listCarrier != null && listCarrier.size() > 0){
				for (int i = 0; i < listCarrier.size(); i++){
					carrierBuilder.append(listCarrier.get(i).getJoCrrCd());
					if (i < listCarrier.size() - 1){
						carrierBuilder.append("|");
					}
				}
			}
			eventResponse.setETCData("carriers", carrierBuilder.toString());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 *  Save changed data.
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCarrier(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice4Trn004Event event = (Practice4Trn004Event)e;
		Practice4MgmtBC command = new Practice4MgmtBCImpl();
		try{
			begin();
			command.manageCarrierCarrierMgmt(event.getCarrierVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("BKG06071").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search list customer data.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomerEvent event = (CustomerEvent)e;
		Practice4MgmtBC command = new Practice4MgmtBCImpl();
		
		try{
			List<CustomerVO> list = command.searchCustomer(event.getCustomerVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * Search list customer data.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRevLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RevLaneEvent event = (RevLaneEvent)e;
		Practice4MgmtBC command = new Practice4MgmtBCImpl();
		
		try{
			List<RevLaneVO> list = command.searchRevlane(event.getRevLaneVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
}