/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice2MgmtDBDAOSubSystemVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2022.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice2.emmsgmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dang Hoan Thanh
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Practice2MgmtDBDAOSubSystemVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public Practice2MgmtDBDAOSubSystemVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.practice2.emmsgmgmt.integration").append("\n"); 
		query.append("FileName : Practice2MgmtDBDAOSubSystemVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("select distinct(ownr_sub_sys_cd)" ).append("\n"); 
		query.append("from com_intg_cd" ).append("\n"); 

	}
}