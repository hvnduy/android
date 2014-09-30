package com.hs.mapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.hs.mapp.vo.PredictionVO;

/**
 * The Interface PredictionDAO.
 */
public interface PredictionDAO {
	
	/**
	 * Gets the prediction by daily.
	 *
	 * @param hs_id the hs_id
	 * @param date the date
	 * @param lgg the lgg
	 * @return the prediction by daily
	 * @throws SQLException 
	 */
	PredictionVO getPredictionByDaily(int hs_id, String date, String lgg) throws SQLException;
	
	/**
	 * Gets the list prediction by daily.
	 *
	 * @param date the date
	 * @param lgg the lgg
	 * @return the list prediction by daily
	 * @throws SQLException 
	 */
	List<PredictionVO> getListPredictionByDaily(String date, String lgg) throws SQLException;
	/**
	 * GetPredictionDaily.
	 *
	 * @param date the date
	 * @param lgg the lgg
	 * @return the list prediction by daily
	 * @throws SQLException 
	 */
	List<PredictionVO> getPredictionDaily(String date, String lgg) throws SQLException;
}
