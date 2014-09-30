package com.hs.mapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.mapp.dao.PredictionDAO;
import com.hs.mapp.service.PredictionService;
import com.hs.mapp.vo.PredictionVO;

@Service
public class PredictionServiceImpl implements PredictionService {

	@Autowired
	private PredictionDAO predictionDAO;
	@Override
	public PredictionVO getPredictionByDaily(int hs_id, String date, String lgg) throws SQLException {
		System.out.println(lgg);
		return predictionDAO.getPredictionByDaily(hs_id, date, lgg);
	}
	@Override
	public List<PredictionVO> getListPredictionByDaily(String date, String lgg) throws SQLException {
	    return predictionDAO.getListPredictionByDaily(date, lgg);
	}
	@Override
	public List<PredictionVO> getPredictionDaily(String date, String lgg)
			throws SQLException {
		return predictionDAO.getPredictionDaily(date, lgg);
	}

}
