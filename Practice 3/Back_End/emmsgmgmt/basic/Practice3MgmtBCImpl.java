/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : Practice3MgmtBCImpl.java
 *@FileTitle : Practice 3
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






import com.clt.apps.opus.practice3.emmsgmgmt.integration.Practice3MgmtDBDAO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummarySearchTradeVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-Practice3 Business Logic Command Interface<br>
 * - Interface to business logic for ALPS-Practice3<br>
 *
 * @author Dang Hoan Thanh
 * @since J2EE 1.6
 */
public class Practice3MgmtBCImpl extends BasicCommandSupport implements Practice3MgmtBC {
	// Database Access Object
	private transient Practice3MgmtDBDAO dbDao = null;

	/**
	 * function constructor Practice3MgmtBCImpl<br>
	 * To initialize Practice3MgmtDBDAO<br>
	 */
	public Practice3MgmtBCImpl() {
		dbDao = new Practice3MgmtDBDAO();
	}

	/**
	 * [searchSummaryMgmt] to get a list of summary.<br>
	 * 
	 * @param SummaryVO	summaryVO
	 * @return List<SummaryVO>
	 * @exception EventException
	 */
	public List<SummaryVO> searchSummaryMgmt(SummaryVO summaryVO)
			throws EventException {
		try {
			return dbDao.searchSummaryVO(summaryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [searchPartner] to get a list of partner.<br>
	 * 
	 * @param 
	 * @return List<SummarySearchPartnerVO>
	 * @exception EventException
	 */
	public List<SummaryVO> searchPartner() 
			throws EventException {
		try {
			return dbDao.searchPartner();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [searchLane] to get a list of lane.<br>
	 * 
	 * @param SummarySearchLaneVO	laneVO
	 * @return Map<String, String>
	 * @exception EventException
	 */
	public List<SummaryVO> searchLane(SummaryVO laneVO)
			throws EventException {
		try {
			return dbDao.searchLane(laneVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [searchTrade] to get a list of trade.<br>
	 * 
	 * @param SummarySearchTradeVO	tradeVO
	 * @return Map<String, String>
	 * @exception EventException
	 */
	public Map<String, String> searchTrade(SummarySearchTradeVO tradeVO)
			throws EventException {
		try {
			return dbDao.searchTrade(tradeVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [searchDetailMgmt] to get a list of detail.<br>
	 * 
	 * @param DetailVO	detailVO
	 * @return List<DetailVO>
	 * @exception EventException
	 */
	public List<DetailVO> searchDetailMgmt(DetailVO detailVO)
			throws EventException {
		try {
			return dbDao.searchDetailVO(detailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}
