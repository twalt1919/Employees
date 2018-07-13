package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

public interface CompensationService {
	Compensation create(Compensation c);
	Compensation read(String id);
	Compensation update(Compensation c);
}
