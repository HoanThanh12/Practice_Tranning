/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : CarrierMgmtDBDAORevLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2022.07.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.practice4.emmsgmgmt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dang Hoan Thanh
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierMgmtDBDAORevLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierMgmtDBDAORevLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.practice4.emmsgmgmt.integration").append("\n"); 
		query.append("FileName : CarrierMgmtDBDAORevLaneVORSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	vsl_slan_cd," ).append("\n"); 
		query.append("	rlane_nm," ).append("\n"); 
		query.append("	rlane_cd" ).append("\n"); 
		query.append("from mdm_rev_lane" ).append("\n"); 
		query.append("where 1 = 1" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("and vsl_slan_cd like '%'||UPPER(@[vsl_slan_cd])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by vsl_slan_cd asc" ).append("\n"); 

	}
}