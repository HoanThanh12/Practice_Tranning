/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : Practice3MgmtBC.java
 *@FileTitle : Practice3
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2022.06.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2022.04.22
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice3.emmsgmgmt.basic;

import java.util.List;
import java.util.Map;





import com.clt.apps.opus.practice3.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummarySearchTradeVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummaryVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * ALPS-Practice3 Business Logic Command Interface<br>
 * - Interface to business logic for ALPS-Practice3<br>
 *
 * @author Dang Hoan Thanh
 * @since J2EE 1.6
 */
public interface Practice3MgmtBC {
	/**
	 * [searchSummaryMgmt] to get a list of summary.<br>
	 * 
	 * @param SummaryVO	summaryVO
	 * @return List<SummaryVO>
	 * @exception EventException
	 */
	public List<SummaryVO> searchSummaryMgmt(SummaryVO summaryVO)
			throws EventException;

	/**
	 * [searchPartner] to get a list of partner.<br>
	 * 
	 * @param
	 * @return List<SummarySearchPartnerVO>
	 * @exception EventException
	 */
	public List<SummaryVO> searchPartner() 
			throws EventException;

	/**
	 * [searchLane] to get a list of lane.<br>
	 * 
	 * @param SummarySearchLaneVO	laneVO
	 * @return List<SummaryVO>
	 * @exception EventException
	 */
	public List<SummaryVO> searchLane(SummaryVO laneVO)
			throws EventException;

	/**
	 * [searchTrade] to get a list of trade.<br>
	 * 
	 * @param SummarySearchTradeVO	tradeVO
	 * @return Map<String, String>
	 * @exception EventException
	 */
	public Map<String, String> searchTrade(SummarySearchTradeVO tradeVO)
			throws EventException;

	/**
	 * [searchDetailMgmt] to get a list of detail.<br>
	 * 
	 * @param DetailVO	detailVO
	 * @return List<DetailVO>
	 * @exception EventException
	 */
	public List<DetailVO> searchDetailMgmt(DetailVO detailVO)
			throws EventException;
	
	
	public List searchDetailsRSForExcel(DetailVO detailVO) throws EventException;
}
