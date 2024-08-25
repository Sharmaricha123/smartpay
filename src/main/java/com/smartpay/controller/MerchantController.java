package com.smartpay.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartpay.Validation.MerchantDtoValidation;
import com.smartpay.Validation.UserDtoValidation;
import com.smartpay.dto.MerchantDto;
import com.smartpay.enums.ErrorMsg;
import com.smartpay.enums.MerchantErrorMsg;
import com.smartpay.enums.MerchantSuccessMsg;
import com.smartpay.model.Merchant;
import com.smartpay.model.MerchantDocument;
import com.smartpay.response.Response;
import com.smartpay.service.MerchantService;

@RestController
@RequestMapping("/v1/users/merchant")
public class MerchantController {

	@Autowired
	private MerchantService merchantService;

	@PutMapping("/updateuserprofile/{username}")
	public ResponseEntity<Response> updateUserProfileToMerchant(@PathVariable String username,
			@RequestBody MerchantDto merchantDto) {
		List<String> errList = MerchantDtoValidation.validateMerchantUser(merchantDto);
		Merchant updatedUserProfile = null;
		if (errList.isEmpty()) {
			updatedUserProfile = merchantService.updateUserProfile(username, merchantDto);

		} else {
			return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.BAD_REQUEST, false,
					ErrorMsg.Error001.getValue(), errList), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.CREATED, true,
				MerchantSuccessMsg.MS001.getValue(), updatedUserProfile), HttpStatus.CREATED);

	}

	@PostMapping("/uploadDocuments/{identificationNumber}")
	public ResponseEntity<Response> uploadMerchantDocument(@PathVariable String identificationNumber,@RequestParam MultipartFile panCard,@RequestParam MultipartFile aadharCard,@RequestParam MultipartFile cancelledCheck,@RequestParam MultipartFile sign )
	{
		MultipartFile files[]=new MultipartFile[4];
		files[0]=panCard;
		files[1]=aadharCard;
		files[2]=cancelledCheck;
		files[3]=sign;
		
		MerchantDocument merchantDocument=merchantService.uploadMerchnatDocuments(identificationNumber,files);
		if(merchantDocument!=null)
		{
			return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.OK, true, MerchantSuccessMsg.MS002.getValue(), merchantDocument),HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<Response>(new Response(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, false, MerchantErrorMsg.ME0064.getValue(),null ),HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
	}

}
