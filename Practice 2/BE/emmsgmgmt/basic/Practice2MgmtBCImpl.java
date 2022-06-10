/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice2MgmtBCImpl.java
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

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.clv.training.emmsgmgmt.vo.ErrMsgVO;
import com.clt.apps.opus.practice2.emmsgmgmt.integration.Practice2MgmtDBDAO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.MasterVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.SubSystemVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Training Business Logic Command Interface<br>
 * - Interface to business logic for ALPS-Training<br>
 *
 * @author Dang Hoan Thanh
 * @since J2EE 1.6
 */
public class Practice2MgmtBCImpl extends BasicCommandSupport implements Practice2MgmtBC {
	// Database Access Object
	private transient Practice2MgmtDBDAO dbDao = null;
	
	/**
	 * function constructor CodeMgmtBCImpl<br>
	 * To initialize CodeMgmtDBDAO<br>
	 */
	public Practice2MgmtBCImpl(){
		dbDao = new Practice2MgmtDBDAO();
	}

	/**
	 * [searchMasterCodeMgmt] to get a list of code.<br>
	 * 
	 * @param MasterVO	masterVO
	 * @return List<MasterVO>
	 * @exception EventException
	 */
	public List<MasterVO> searchMasterCodeMgmt(MasterVO masterVO) throws EventException {
		try {
			return dbDao.searchMasterCodeMgmt(masterVO);
		}
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [searchDetailCodeMgmt] to get a list of code detail.<br>
	 * 
	 * @param MasterVO	masterVO
	 * @return List<MasterVO>
	 * @exception EventException
	 */
	public List<DetailVO> searchDetailCodeMgmt(DetailVO detailVO) throws EventException {
		try{
			return dbDao.searchDetailCodeMgmt(detailVO);
		}
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * [manageMasterCodeMgmt] to save the change(add, delete, update) in database.<br>
	 * 
	 * @param MasterVO[] masterVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageMasterCodeMgmt(MasterVO[] masterVO, SignOnUserAccount account) throws EventException{
		try {
			List<MasterVO> insertVoList = new ArrayList<MasterVO>();
			List<MasterVO> updateVoList = new ArrayList<MasterVO>();
			List<MasterVO> deleteVoList = new ArrayList<MasterVO>();
			List<DetailVO> deleteDetailVoList = new ArrayList<DetailVO>();
			
			for ( int i=0; i<masterVO .length; i++ ) {
				if ( masterVO[i].getIbflag().equals("I")){		
					if(checkDuplicate(masterVO[i].getIntgCdId())){
						insertVoList.add(masterVO[i]);
					}else{
						throw new DAOException(new ErrorHandler("ERR00001", new String[] {masterVO[i].getIntgCdId()}).getMessage());
					}
					
				} else if ( masterVO[i].getIbflag().equals("U")){
					updateVoList.add(masterVO[i]);
				} else if ( masterVO[i].getIbflag().equals("D")){
					DetailVO detailVO = new DetailVO();
					detailVO.setIntgCdId(masterVO[i].getIntgCdId());
					deleteDetailVoList.add(detailVO);
					deleteVoList.add(masterVO[i]);
				}
				masterVO[i].setCreUsrId(account.getUsr_id());
				masterVO[i].setUpdUsrId(account.getUsr_id());
			}
			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageMasterCodeMgmtS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageMasterCodeMgmtS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageMasterCodeMgmtS(deleteVoList);
				dbDao.removeDetailByMasterCdId(deleteDetailVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [manageDetailCodeMgmt] to save the change(add, delete, update) in database.<br>
	 * 
	 * @param DetailVO[] detailVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageDetailCodeMgmt(DetailVO[] detailVO, SignOnUserAccount account) throws EventException{
		try {
			List<DetailVO> insertVoList = new ArrayList<DetailVO>();
			List<DetailVO> updateVoList = new ArrayList<DetailVO>();
			List<DetailVO> deleteVoList = new ArrayList<DetailVO>();
			
			for ( int i=0; i<detailVO .length; i++ ) {
				if ( detailVO[i].getIbflag().equals("I")){
					insertVoList.add(detailVO[i]);
				} else if ( detailVO[i].getIbflag().equals("U")){
					updateVoList.add(detailVO[i]);
				} else if ( detailVO[i].getIbflag().equals("D")){
					deleteVoList.add(detailVO[i]);
				}
				detailVO[i].setCreUsrId(account.getUsr_id());
				detailVO[i].setUpdUsrId(account.getUsr_id());
			}
			
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageDetailCodeMgmtS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageDetailCodeMgmtS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageDetailCodeMgmtS(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	@Override
	public List<SubSystemVO> searchSubSystem() throws EventException {
		try {
			return dbDao.searchSubSytem();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	public boolean checkDuplicate(String msgCode) throws EventException{
		try {
			MasterVO masterVO = new MasterVO();
			masterVO.setIntgCdId(msgCode);
			List<MasterVO> listMasterVO = dbDao.searchMasterCodeMgmt(masterVO);
			if(listMasterVO.size() == 0){
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