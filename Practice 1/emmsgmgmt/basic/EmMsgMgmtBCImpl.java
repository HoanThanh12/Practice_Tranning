/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : EmMsgMgmtBCImpl.java
*@FileTitle : Practice 1
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2022.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.training.emmsgmgmt.basic;

import java.util.ArrayList;
import java.util.List;
import com.clt.apps.opus.esm.clv.training.emmsgmgmt.integration.EmMsgMgmtDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.clv.training.emmsgmgmt.vo.ErrMsgVO;

/**
 * ALPS-Training Business Logic Command Interface<br>
 * - ALPS-Training에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dang Hoan Thanh
 * @since J2EE 1.6
 */
public class EmMsgMgmtBCImpl extends BasicCommandSupport implements EmMsgMgmtBC {

	// Database Access Object
	private transient EmMsgMgmtDBDAO dbDao = null;

	/**
	 * EmMsgMgmtBCImpl 객체 생성<br>
	 * EmMsgMgmtDBDAO를 생성한다.<br>
	 */
	public EmMsgMgmtBCImpl() {
		dbDao = new EmMsgMgmtDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ErrMsgVO errMsgVO
	 * @return List<ErrMsgVO>
	 * @exception EventException
	 */
	public List<ErrMsgVO> searchErrMsgVO(ErrMsgVO errMsgVO) throws EventException {
		try {
			return dbDao.searchErrMsgVO(errMsgVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ErrMsgVO[] errMsgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manaErrMsgVO(ErrMsgVO[] errMsgVO, SignOnUserAccount account) throws EventException{
		try {
			List<ErrMsgVO> insertVoList = new ArrayList<ErrMsgVO>();
			List<ErrMsgVO> updateVoList = new ArrayList<ErrMsgVO>();
			List<ErrMsgVO> deleteVoList = new ArrayList<ErrMsgVO>();
			for ( int i=0; i<errMsgVO .length; i++ ) {
				if ( errMsgVO[i].getIbflag().equals("I")){
					errMsgVO[i].setCreUsrId(account.getUsr_id());
					errMsgVO[i].setUpdUsrId(account.getUsr_id());
					if(checkDuplicate(errMsgVO[i].getErrMsgCd())){
						insertVoList.add(errMsgVO[i]);
					}else{
						throw new DAOException(new ErrorHandler("ERR00001").getMessage());
					}
					
				} else if ( errMsgVO[i].getIbflag().equals("U")){
					errMsgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(errMsgVO[i]);
				} else if ( errMsgVO[i].getIbflag().equals("D")){
					deleteVoList.add(errMsgVO[i]);
				}
				
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanaErrMsgVOS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanaErrMsgVOS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanaErrMsgVOS(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	public boolean checkDuplicate(String msgCode) throws EventException{
		try {
			ErrMsgVO errMsgVO = new ErrMsgVO();
			errMsgVO.setErrMsgCd(msgCode);
			List<ErrMsgVO> listErrMsg = dbDao.searchErrMsgVO(errMsgVO);
			if(listErrMsg.size() == 0){
				return true;
			}				
			return false;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}