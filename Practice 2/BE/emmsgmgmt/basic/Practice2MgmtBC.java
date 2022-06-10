/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice2MgmtBC.java
*@FileTitle : Practice 2
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2022.04.15
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice2.emmsgmgmt.basic;

import java.util.List;

import com.clt.apps.opus.practice2.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.MasterVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.SubSystemVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Training Business Logic Command Interface<br>
 * - Interface to business logic for ALPS-Training<br>
 *
 * @author Dang Hoan Thanh
 * @since J2EE 1.6
 */
public interface Practice2MgmtBC {
	/**
	 * [searchMasterCodeMgmt] to get a list of code.<br>
	 * 
	 * @param MasterVO	masterVO
	 * @return List<MasterVO>
	 * @exception EventException
	 */
	public List<MasterVO> searchMasterCodeMgmt(MasterVO masterVO) throws EventException;
	
	/**
	 * [searchMasterCodeMgmt] to get a list of code.<br>
	 * 
	 * @param MasterVO	masterVO
	 * @return List<MasterVO>
	 * @exception EventException
	 */
	public List<SubSystemVO> searchSubSystem() throws EventException;
	
	/**
	 * [searchDetailCodeMgmt] to get a list of code detail.<br>
	 * 
	 * @param MasterVO	masterVO
	 * @return List<MasterVO>
	 * @exception EventException
	 */
	public List<DetailVO> searchDetailCodeMgmt(DetailVO detailVO) throws EventException;
	
	/**
	 * [manageMasterCodeMgmt] to save the change(add, delete, update) in database.<br>
	 * 
	 * @param MasterVO[] masterVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMasterCodeMgmt(MasterVO[] masterVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [manageDetailCodeMgmt] to save the change(add, delete, update) in database.<br>
	 * 
	 * @param DetailVO[] detailVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageDetailCodeMgmt(DetailVO[] detailVO, SignOnUserAccount account) throws EventException;
	
	public boolean checkDuplicate(String msgCode) throws EventException;
	
}