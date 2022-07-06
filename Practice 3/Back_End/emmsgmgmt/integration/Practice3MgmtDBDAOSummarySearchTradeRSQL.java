/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : Practice3MgmtDBDAOSummarySearchTradeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2022.06.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice3.emmsgmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dang Hoan Thanh
 * @see DAO Reference
 * @since J2EE 1.6
 */

public class Practice3MgmtDBDAOSummarySearchTradeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public Practice3MgmtDBDAOSummarySearchTradeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.practice3.emmsgmgmt.integration").append("\n"); 
		query.append("FileName : Practice3MgmtDBDAOSummarySearchTradeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	DISTINCT(MODI_COST_CTR_CD)," ).append("\n"); 
		query.append("	JO_CRR_CD," ).append("\n"); 
		query.append("	RLANE_CD" ).append("\n"); 
		query.append("FROM JOO_STL_TGT " ).append("\n"); 
		query.append("WHERE RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("	AND JO_CRR_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${obj_list_no}) #if($velocityCount < $obj_list_no.size()) '$key', #else '$key' #end #end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}