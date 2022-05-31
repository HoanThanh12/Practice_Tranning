/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice1Trn001Event.java
*@FileTitle : Practice 1
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2022.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.training.emmsgmgmt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.clv.training.emmsgmgmt.vo.ErrMsgVO;


/**
 * PRACTICE1_TRN_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  PRACTICE1_TRN_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dang Hoan Thanh
 * @see PRACTICE1_TRN_001HTMLAction 참조
 * @since J2EE 1.6
 */

public class Practice1Trn001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	ErrMsgVO errMsgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	ErrMsgVO[] errMsgVOs = null;

	public Practice1Trn001Event(){}
	
	public void setErrMsgVO(ErrMsgVO errMsgVO){
		this. errMsgVO = errMsgVO;
	}

	public void setErrMsgVOS(ErrMsgVO[] errMsgVOs){
		this. errMsgVOs = errMsgVOs;
	}

	public ErrMsgVO getErrMsgVO(){
		return errMsgVO;
	}

	public ErrMsgVO[] getErrMsgVOS(){
		return errMsgVOs;
	}

}