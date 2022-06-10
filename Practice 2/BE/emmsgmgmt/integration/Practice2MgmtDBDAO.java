/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : CodeMgmtDBDAO.java
*@FileTitle : Code Management
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2022.04.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice2.emmsgmgmt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.practice2.emmsgmgmt.vo.DetailVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.MasterVO;
import com.clt.apps.opus.practice2.emmsgmgmt.vo.SubSystemVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CodeMgmtDBDAO <br>
 * - JDBC operation to process ALPS-DouTraining system business logic.<br>
 * 
 * @author Dang Hoan Thanh
 * @see Practice2MgmtBCImpl 참조
 * @since J2EE 1.6
 */
public class Practice2MgmtDBDAO extends DBDAOSupport {
		

	
	
	/**
	 * [searchMasterCodeMgmt] to get a list of Code.<br>
	 * 
	 * @param MasterVO masterVO
	 * @return List<MasterVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MasterVO> searchMasterCodeMgmt(MasterVO masterVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<MasterVO> list = new ArrayList();

		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (masterVO != null) {
				Map<String, String> mapVO = masterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Practice2MgmtDBDAOMasterVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MasterVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * [searchSubSytem] to get a list of partner.<br>
	 * 
	 * @return List<SummaryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SubSystemVO> searchSubSytem() throws DAOException {
		DBRowSet dbRowset = null;
		 List<SubSystemVO> list = new ArrayList();
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new Practice2MgmtDBDAOSubSystemVORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SubSystemVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	}

	/**
	 * [searchDetailCodeMgmt] to get a list of Code detail.<br>
	 * 
	 * @param DetailVO detailVO
	 * @return List<DetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DetailVO> searchDetailCodeMgmt(DetailVO detailVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<DetailVO> list = new ArrayList();

		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (detailVO != null) {
				Map<String, String> mapVO = detailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Practice2MgmtDBDAODetailVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, DetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [addmanageMasterCodeMgmtS] to add Codes.<br>
	 * 
	 * @param List<MasterVO> masterVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageMasterCodeMgmtS(List<MasterVO> masterVO)
			throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (masterVO.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new Practice2MgmtDBDAOMasterVOCSQL(),
						masterVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [modifymanageMasterCodeMgmtS] to update Codes.<br>
	 * 
	 * @param List<MasterVO> masterVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifymanageMasterCodeMgmtS(List<MasterVO> masterVO)
			throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (masterVO.size() > 0) {
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new Practice2MgmtDBDAOMasterVOUSQL(),
						masterVO, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * [removemanageMasterCodeMgmtS] to delete Codes.<br>
	 * 
	 * @param List<MasterVO> masterVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removemanageMasterCodeMgmtS(List<MasterVO> masterVO)
			throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (masterVO.size() > 0) {
				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new Practice2MgmtDBDAOMasterVODSQL(),
						masterVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}

	/**
	 * [addmanageDetailCodeMgmtS] to add CodeDetails.<br>
	 * 
	 * @param List<DetailVO> detailVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addmanageDetailCodeMgmtS(List<DetailVO> detailVO)
			throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (detailVO.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new Practice2MgmtDBDAODetailVOCSQL(),
						detailVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}

	/**
	 * [modifymanageDetailCodeMgmtS] to update CodeDetails.<br>
	 * 
	 * @param List<DetailVO> detailVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifymanageDetailCodeMgmtS(List<DetailVO> detailVO)
			throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (detailVO.size() > 0) {
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new Practice2MgmtDBDAODetailVOUSQL(),
						detailVO, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * [removemanageDetailCodeMgmtS] to delete CodeDetails.<br>
	 * 
	 * @param List<DetailVO> detailVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removemanageDetailCodeMgmtS(List<DetailVO> detailVO)
			throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (detailVO.size() > 0) {
				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new Practice2MgmtDBDAODetailVODSQL(),
						detailVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}	
	/**
	 * [removeDetailByMasterCdId] to delete detail by master cd_id.<br>
	 * 
	 * @param List<DetailVO> detailVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeDetailByMasterCdId(List<DetailVO> detailVO)
			throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (detailVO.size() > 0) {
				delCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new Practice2MgmtDBDAODeleteDetailByCdIdDSQL(),
								detailVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
}