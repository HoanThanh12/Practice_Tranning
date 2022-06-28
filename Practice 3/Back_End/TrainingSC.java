package com.clt.apps.opus.practice3;

import java.util.List;
import java.util.Map;
import com.clt.apps.opus.practice3.emmsgmgmt.basic.Practice3MgmtBC;
import com.clt.apps.opus.practice3.emmsgmgmt.basic.Practice3MgmtBCImpl;
import com.clt.apps.opus.practice3.emmsgmgmt.event.Practice3Trn003Event;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

public class TrainingSC extends ServiceCommandSupport{
	// Login User Information
	private SignOnUserAccount account = null;
	
	public void doStart() {
		log.debug("TrainningSC start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	public void doEnd() {
		log.debug("TrainningSC end");
	}
	
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("Practice3Trn003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = initData();
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchLane(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchTrade(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = searchDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				// direct down2excel
				eventResponse = searchDetailsRSForExcel(e); 
			}
		}
		return eventResponse;
	}
	
	private EventResponse searchDetailsRSForExcel(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice3Trn003Event event = (Practice3Trn003Event)e;
		Practice3MgmtBC command = new Practice3MgmtBCImpl();
		try{
			
			eventResponse.setRsVoList(command.searchDetailsRSForExcel(event.getDetailVO()));
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * [SearchSummary]
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice3Trn003Event event = (Practice3Trn003Event)e;
		Practice3MgmtBC command = new Practice3MgmtBCImpl();

		try{
			List<SummaryVO> list = command.searchSummaryMgmt(event.getSummaryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * [SearchDetails]
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice3Trn003Event event = (Practice3Trn003Event)e;
		Practice3MgmtBC command = new Practice3MgmtBCImpl();

		try{
			List<DetailVO> list = command.searchDetailMgmt(event.getDetailVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * [SearchPartner]
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse initData() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice3MgmtBC command = new Practice3MgmtBCImpl();

		try{
			List<SummaryVO> list = command.searchPartner();
			StringBuilder partnerBuilder = new StringBuilder();
			if(null != list && list.size() > 0){
				for(int i =0; i < list.size(); i++){
					partnerBuilder.append(list.get(i).getJoCrrCd());
					if (i < list.size() - 1){
						partnerBuilder.append("|");
					}	
				}
			}
			eventResponse.setETCData("partners", partnerBuilder.toString());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * [SearchLane]
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLane(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice3Trn003Event event = (Practice3Trn003Event)e;
		Practice3MgmtBC command = new Practice3MgmtBCImpl();
		try{		
			List<SummaryVO> list = command.searchLane(event.getSummaryVO());
			StringBuilder laneBuilder = new StringBuilder();
			if(list!= null && list.size() > 0){
				for(int i = 0; i < list.size(); i++){
					laneBuilder.append(list.get(i).getRlaneCd());
					if (i < list.size() - 1){
						laneBuilder.append("|");
					}	
				}
			}
			eventResponse.setETCData("lanes",laneBuilder.toString());
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * [SearchTrade]
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTrade(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice3Trn003Event event = (Practice3Trn003Event)e;
		Practice3MgmtBC command = new Practice3MgmtBCImpl();
		try{		
			Map<String,String> list = command.searchTrade(event.getTradeVO());
			StringBuilder tradeBuilder = new StringBuilder();
			String temp = "";
			for (Map.Entry<String, String> entry : list.entrySet()){
				tradeBuilder.append("|" + entry.getValue());
			}
			if (tradeBuilder.toString().length() > 0){
				temp = tradeBuilder.toString().substring(1);
			}
			eventResponse.setETCData("trades",temp);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
}
