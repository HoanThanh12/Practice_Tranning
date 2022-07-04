/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : Practice4MgmtBC.java
 *@FileTitle : Practice 4
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2022.06.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2022.05.16
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice4.emmsgmgmt.basic;

import java.util.List;





import com.clt.apps.opus.practice4.emmsgmgmt.vo.CarrierVO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.CustomerVO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.RevLaneVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Practice4 Business Logic Command Interface<br>
 * - Interface to business logic for ALPS-Practice4<br>
 *
 * @author Dang Hoan Thanh
 * @since J2EE 1.6
 */
public interface Practice4MgmtBC {
	/**
	 * [searchCarrierCarrierMgmt] to get a list of Carrier.<br>
	 * 
	 * @param CarrierVO	carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> searchCarrierCarrierMgmt(CarrierVO carrierVO) throws EventException;
	
	/**
	 * [searchCarrierCombo] to get a list of Carrier for Combo box.<br>
	 * 
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> searchCarrierCombo() throws EventException;
	
	/**
	 * [manageCarrierCarrierMgmt] to save the change(add, delete, update) in database.<br>
	 * 
	 * @param CarrierVO[] carrierVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCarrierCarrierMgmt(CarrierVO[] carrierVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [searchCustomer] to get a list of Customer.<br>
	 * 
	 * @param CustomerVO	customerVO
	 * @return List<CustomerVO>
	 * @exception EventException
	 */
	public List<CustomerVO> searchCustomer(CustomerVO customerVO) throws EventException; 
	
	/**
	 * [checkDuplicateInput] to check duplicate input.<br>
	 * 
	 * @param CarrierVO	carrierVO
	 * @return int
	 * @exception EventException
	 */
	public int checkDuplicateInput(CarrierVO carrierVO) throws EventException;
	
	
	/**
	 * [searchRevlane] to get a list of RevLane.<br>
	 * 
	 * @param RevLaneVO	revLaneVO
	 * @return List<RevLaneVO>
	 * @exception EventException
	 */
	public List<RevLaneVO> searchRevlane(RevLaneVO revLaneVO) throws EventException; 
}