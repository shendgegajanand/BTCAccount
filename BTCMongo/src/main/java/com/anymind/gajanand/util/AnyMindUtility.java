package com.anymind.gajanand.util;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anymind.gajanand.constants.AnyMindConstants;
import com.anymind.gajanand.model.Account;

@Service
public class AnyMindUtility {

	@Autowired
	AnyMindPropertyUtility propertyUtility;
	
	public static boolean isEmpty(Object obj) {
		return StringUtils.isEmpty(obj);
	}
	
	public Account getTempAccount(Account originalAccount) {
		Account tempAccount = new Account();
		tempAccount.setPublicAddress(originalAccount.getPublicAddress());
		tempAccount.setTotalAmount(originalAccount.getTotalAmount());
		return tempAccount;
	}
	
	public OffsetDateTime getDateFromString(String dateStr) throws Exception {
		if(isEmpty(dateStr))
			throw new Exception(propertyUtility.getProperty(AnyMindConstants.DATE_SHOULD_NOT_BE_EMPTY));
		
		DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
				.ofPattern(propertyUtility.getProperty(AnyMindConstants.DATE_FORMAT_WITH_OFFSET));
		//Instance with given offset
		OffsetDateTime odtInstanceAtOffset = null;
		try {
			odtInstanceAtOffset = OffsetDateTime.parse(dateStr, DATE_TIME_FORMATTER);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return odtInstanceAtOffset;
	}
	
	public static void main(String[] args) throws Exception {
		
		String startStr = "03/08/2019T16:20:17:717+05:30";
		String endStr = "03/08/2019T21:40:17:717+05:30";
		
		//OffsetDateTime startDate = new AnyMindUtility().getDateFromString(startStr);
		//OffsetDateTime endDate = new AnyMindUtility().getDateFromString(endStr);
		
		DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
				.ofPattern("dd/MM/uuuu'T'HH:mm:ss:SSSXXXXX");
		OffsetDateTime startDate = OffsetDateTime.parse(startStr, DATE_TIME_FORMATTER);
		OffsetDateTime endDate = OffsetDateTime.parse(endStr, DATE_TIME_FORMATTER);
				
		System.out.println("Start Date: " + startDate + "\nEnd Date: " + endDate);
		
		OffsetDateTime startDateWithZero = OffsetDateTime.of(startDate.getYear(), startDate.getMonthValue(), startDate.getDayOfMonth(), startDate.getHour(), 00, 00, 00, startDate.getOffset());
		OffsetDateTime endDateWithZero = OffsetDateTime.of(endDate.getYear(), endDate.getMonthValue(), endDate.getDayOfMonth(), endDate.getHour(), 00, 00, 00, endDate.getOffset());
		System.out.println("Start Date with 00: " + startDateWithZero + "\nEnd Date with 00: " + endDateWithZero);
		
		List<OffsetDateTime> totalDates = new ArrayList<>();
		while (!startDateWithZero.isAfter(endDateWithZero)) {
		    totalDates.add(startDateWithZero);
		    startDateWithZero = startDateWithZero.plusHours(1);
		}
		System.out.println("totalDates: " + totalDates);

	}

}
