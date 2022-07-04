/*=========================================================
 *Copyright(c) 2022 CyberLogitec
 *@FileName : Practice4MgmtBCImpl
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

import java.util.ArrayList;
import java.util.List;






import com.clt.apps.opus.practice4.emmsgmgmt.integration.CarrierMgmtDBDAO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.CarrierVO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.CustomerVO;
import com.clt.apps.opus.practice4.emmsgmgmt.vo.RevLaneVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Practice4 Business Logic Command Interface<br>
 * - Interface to business logic for ALPS-Practice4<br>
 *
 * @author Dang Hoan Thanh
 * @since J2EE 1.6
 */
public class Practice4MgmtBCImpl extends BasicCommandSupport implements Practice4MgmtBC{
	// Database Access Object
	private transient CarrierMgmtDBDAO dbDao = null;
	
	/**
	 * function constructor CarrierMgmtBCImpl<br>
	 * To initialize CarrierMgmtDBDAO<br>
	 */
	public Practice4MgmtBCImpl(){
		dbDao = new CarrierMgmtDBDAO();
	}
	
	/**
	 * [searchCarrierCarrierMgmt] to get a list of Carrier.<br>
	 * 
	 * @param CarrierVO	carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> searchCarrierCarrierMgmt(CarrierVO carrierVO) throws EventException {
		try{
			return dbDao.searchCarrierVO(carrierVO);
		}
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [searchCarrierCombo] to get a list of Carrier for Combo box.<br>
	 * 
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> searchCarrierCombo() throws EventException {
		try{
			return dbDao.searchCarrierCombo();
		}
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [manageCarrierCarrierMgmt] to save the change(add, delete, update) in database.<br>
	 * 
	 * @param CarrierVO[] carrierVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageCarrierCarrierMgmt(CarrierVO[] carrierVO, SignOnUserAccount account) throws EventException {
		try{
			List<CarrierVO> insertVOList = new ArrayList<CarrierVO>();
			List<CarrierVO> updateVOList = new ArrayList<CarrierVO>();
			List<CarrierVO> deleteVOList = new ArrayList<CarrierVO>();
			StringBuilder dups = new StringBuilder();
			int count = 0;
			
			for (int i = 0; i < carrierVO.length; i++){
				if ( carrierVO[i].getIbflag().equals("I")){		
					if (checkDuplicateInput(carrierVO[i]) >= 1){
						dups.append(carrierVO[i].getJoCrrCd());
						dups.append("," + carrierVO[i].getRlaneCd());
						if (i < carrierVO .length - 1){
							dups.append("],[");
						}
						count++;
					}
					if (i == carrierVO.length-1){
						if (count > 0){
							throw new DAOException(new ErrorHandler("ERR00002", new String[]{dups.toString()}).getMessage());
						}
						else {
							carrierVO[i].setCreUsrId(account.getUsr_id());
							carrierVO[i].setUpdUsrId(account.getUsr_id());
							insertVOList.add(carrierVO[i]);
						
						}
					}			
				}
				else if (carrierVO[i].getIbflag().equals("U")){
					carrierVO[i].setUpdUsrId(account.getUsr_id());
					updateVOList.add(carrierVO[i]);
				}
				else if (carrierVO[i].getIbflag().equals("D")){
					deleteVOList.add(carrierVO[i]);
				}
				
			}
			
			if (insertVOList.size() > 0){
				dbDao.addmanageCarrierS(insertVOList);
			}
			
			if (updateVOList.size() > 0){
				dbDao.modifymanageCarrierS(updateVOList);
			}
			
			if (deleteVOList.size() > 0){
				dbDao.removemanageCarrierS(deleteVOList);
			}
		}
		catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [searchCustomer] to get a list of Customer.<br>
	 * 
	 * @param CustomerVO	customerVO
	 * @return List<CustomerVO>
	 * @exception EventException
	 */
	public List<CustomerVO> searchCustomer(CustomerVO customerVO) throws EventException {
		try{
			return dbDao.searchCustomer(customerVO);
		}
		catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [checkDuplicateInput] to check duplicate input.<br>
	 * 
	 * @param CarrierVO	carrierVO
	 * @return int
	 * @exception EventException
	 */
	public int checkDuplicateInput(CarrierVO carrierVO) throws EventException {
		try {
			return dbDao.duplicateInput(carrierVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	@Override
	public List<RevLaneVO> searchRevlane(RevLaneVO revLaneVO)
			throws EventException {
		try {
			return dbDao.searchRevLane(revLaneVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}