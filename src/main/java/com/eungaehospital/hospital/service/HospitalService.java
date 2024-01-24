package com.eungaehospital.hospital.service;

import com.eungaehospital.doctor.dto.DoctorResponseDto;
import com.eungaehospital.doctor.repository.DoctorRepository;
import com.eungaehospital.hospital.domain.Hospital;
import com.eungaehospital.hospital.domain.HospitalImage;
import com.eungaehospital.hospital.dto.HospitalViewResponseDto;
import com.eungaehospital.hospital.repository.HospitalImageRepository;
import com.eungaehospital.hospital.repository.HospitalRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HospitalService {

	private final HospitalRepository hospitalRepository;
	private final HospitalImageRepository hospitalImageRepository;

	@Transactional(readOnly = true)
	public HospitalViewResponseDto getHospitalByHospitalId(String hospitalId) {
		Hospital hospital = hospitalRepository.findByHospitalId(hospitalId).get();
		List<HospitalImage> hospitalImageList = hospitalImageRepository.findAllByHospital(hospital);

		return HospitalViewResponseDto.toDto(hospital, hospitalImageList);
	}
}
