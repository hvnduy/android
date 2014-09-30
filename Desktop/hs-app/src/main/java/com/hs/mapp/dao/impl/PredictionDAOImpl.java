package com.hs.mapp.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.hs.common.SQLConstant;
import com.hs.mapp.dao.PredictionDAO;
import com.hs.mapp.dao.utils.PredictionUtils;
import com.hs.mapp.vo.PredictionVO;

/**
 * The Class PredictionDAOImpl.
 */
@Component
public class PredictionDAOImpl implements PredictionDAO {

	/** The parameter jdbc template. */
	@Autowired
	NamedParameterJdbcTemplate parameterJdbcTemplate;
	@Override
	public PredictionVO getPredictionByDaily(int hs_id, String date,
			String lgg) throws SQLException{
		String sql = SQLConstant.GET_PREDICTION_BY_DAILY;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("horoscope_id", String.valueOf(hs_id));
		parameters.put("language", lgg);
		parameters.put("post_date", date);
		return parameterJdbcTemplate.queryForObject(sql, parameters, PredictionUtils.convertToPredictionVORowMapper());
	}
	
	@Override
	public List<PredictionVO> getListPredictionByDaily(String date, String lgg) throws SQLException {
	    
		String sql = SQLConstant.GET_LIST_PREDICTION_BY_DAILY;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("language", lgg);
		parameters.put("post_date", date);
		return parameterJdbcTemplate.query(sql, parameters, PredictionUtils.convertToPredictionVORowMapper());
	}

	@Override
	public List<PredictionVO> getPredictionDaily(String date, String lgg)
			throws SQLException {
		String sql = SQLConstant.GET_PREDICTION_DAILY;
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("language", lgg);
		parameters.put("post_date", date);
		return parameterJdbcTemplate.query(sql, parameters, PredictionUtils.convertToPredictionVORowMapper());
	}

}
