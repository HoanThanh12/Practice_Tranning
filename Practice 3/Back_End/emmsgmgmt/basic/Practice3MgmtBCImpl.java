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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;









import com.clt.apps.opus.practice3.emmsgmgmt.integration.Practice3MgmtDBDAO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummarySearchTradeVO;
import com.clt.apps.opus.practice3.emmsgmgmt.vo.SummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
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

	@Override
	public List searchDetailsRSForExcel(DetailVO detailVO)
			throws EventException {
		try {
			DBRowSet rs = dbDao.searchDetailsRSForExcel(detailVO);
			List<Object> li=new ArrayList<>();
			Map<Object, Object> mp=null;
			while (rs.next()){
				mp=new HashMap<>(); 
				mp.put("csr_no",rs.getString("CSR_NO"));
			    mp.put("inv_rev_act_amt",rs.getString("INV_REV_ACT_AMT")); 
			    mp.put("locl_curr_cd",rs.getString("LOCL_CURR_CD"));
			    mp.put("cust_vndr_seq",rs.getString("CUST_VNDR_SEQ")); 
			    mp.put("jo_crr_cd",rs.getString("JO_CRR_CD"));
			    mp.put("rlane_cd",rs.getString("RLANE_CD")); 
			    mp.put("rev_exp",rs.getString("REV_EXP"));
			    mp.put("cust_vndr_cnt_cd",rs.getString("CUST_VNDR_CNT_CD")); 
			    mp.put("inv_no",rs.getString("INV_NO"));
			    mp.put("cust_vndr_eng_nm",rs.getString("CUST_VNDR_ENG_NM"));
			    mp.put("inv_exp_act_amt",rs.getString("INV_EXP_ACT_AMT")); 
			    mp.put("item",rs.getString("ITEM"));
			    mp.put("prnr_ref_no",rs.getString("PRNR_REF_NO")); 
			    mp.put("apro_flg",rs.getString("APRO_FLG")); 
			    li.add(mp); 
			}
//			Search in DBDAO
			System.out.println(li);
			return li;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}
