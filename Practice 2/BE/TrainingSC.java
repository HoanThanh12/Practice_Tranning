/*=========================================================
cc*Copyright(c) 2020 CyberLogitec
*@FileName : TrainingSC.java
*@FileTitle : Practice 2
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2020.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice2;

import java.util.Arrays;
import java.util.List;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.management.opus.codemanagement.basic.CodeManagementBC;
import com.clt.syscommon.management.opus.codemanagement.basic.CodeManagementBCImpl;
import com.clt.apps.opus.practice2.emmsgmgmt.basic.Practice2MgmtBC;
import com.clt.apps.opus.practice2.emmsgmgmt.basic.Practice2MgmtBCImpl;
import com.clt.apps.opus.practice2.emmsgmgmt.event.Practice2Trn002Event;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.MasterVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.SubSystemVO;


/**
 * ALPS-DouTraining Business Logic ServiceCommand - ALPS-DouTraining 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Dang Hoan Thanh
 * @see Practice2MgmtDBDAO
 * @since J2EE 1.6
 */

public class TrainingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DouTraining system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TrainingSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DouTraining system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TrainingSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DouTraining system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("Practice2Trn002Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchMaster(e);
			}else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchSubSystem(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageMaster(e);	
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = manageDetail(e);
			}
		}
		return eventResponse;
	}
	
	//search Subsystem
	private EventResponse searchSubSystem(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				Practice2MgmtBC command = new Practice2MgmtBCImpl();

				try{
					List<SubSystemVO> list = command.searchSubSystem();
					StringBuilder subSystemBuilder = new StringBuilder();
					if(list != null && list.size() > 0){
						for(int i =0; i < list.size(); i++){
							subSystemBuilder.append(list.get(i).getOwnrSubSysCd());
							if (i < list.size() - 1){
								subSystemBuilder.append("|");
							}	
						}
					}
					eventResponse.setETCData("subSystems", subSystemBuilder.toString());
				}catch(EventException ex){
					throw new EventException(new ErrorHandler(ex).getMessage(),ex);
				}catch(Exception ex){
					throw new EventException(new ErrorHandler(ex).getMessage(),ex);
				}	
				return eventResponse;
	}
	
	private EventResponse searchMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice2Trn002Event event = (Practice2Trn002Event)e;
		Practice2MgmtBC command = new Practice2MgmtBCImpl();

		try{
			List<MasterVO> list = command.searchMasterCodeMgmt(event.getMasterVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	private EventResponse searchDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice2Trn002Event event = (Practice2Trn002Event)e;
		Practice2MgmtBC command = new Practice2MgmtBCImpl();

		try{
			List<DetailVO> list = command.searchDetailCodeMgmt(event.getDetailVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	private EventResponse manageMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice2Trn002Event event = (Practice2Trn002Event)e;
		Practice2MgmtBC command = new Practice2MgmtBCImpl();
		try{
			begin();
			command.manageMasterCodeMgmt(event.getMasterVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	private EventResponse manageDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Practice2Trn002Event event = (Practice2Trn002Event)e;
		Practice2MgmtBC command = new Practice2MgmtBCImpl();
		try{
			begin();
			command.manageDetailCodeMgmt(event.getDetailVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
}