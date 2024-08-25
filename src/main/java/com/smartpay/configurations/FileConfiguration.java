package com.smartpay.configurations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.kafka.common.protocol.types.Field.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.smartpay.exception.ResourceNotFoundException;
import com.smartpay.exception.SmartPayGlobalException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileConfiguration {

	private final Path fileStorageLocation;

	@Autowired
	public FileConfiguration(FileStorageProperty fileStorageProperty) {

		this.fileStorageLocation = Paths.get(fileStorageProperty.getUploadDirectory()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(fileStorageLocation);
		} catch (Exception ex) {
			log.error("Unable to create Directory");
			throw new SmartPayGlobalException("Unable to craete directory");
		}
	}

	public String[] storeFile(MultipartFile[] files, String aadharCardLast4Digits) {
		String[] result = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			MultipartFile multipartFile = files[i];
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			if (org.apache.commons.lang3.StringUtils.isNotEmpty(fileName)) {
				if (fileName.contains("..")) {
					throw new ResourceNotFoundException("Invalid file name");

				} else {
					if ((fileName.contains(".jpeg")) || (fileName.contains(".JPEG")) || (fileName.contains(".pdf"))
							|| (fileName.contains(".PDF")) || (fileName.contains(".jpg")) || (fileName.contains(".JPG"))
							|| (fileName.contains(".png")) || (fileName.contains(".PNG"))

					) {
						try {
							Path targetLocation = this.fileStorageLocation
									.resolve(aadharCardLast4Digits + "_" + fileName);
							Files.copy(multipartFile.getInputStream(), targetLocation,
									StandardCopyOption.REPLACE_EXISTING);
							String fileLocation = String.valueOf(targetLocation);
							result[i] = fileLocation;
						} catch (IOException ex) {
							throw new ResourceNotFoundException("Could not save the file");
						}

					} else {
						throw new ResourceNotFoundException("Allowed files in jpg,pdf,jpeg,png");
					}

				}

			}

			else {
				log.error("Invalid file");
				throw new ResourceNotFoundException("Invalid file received");
			}

		}
		return result;
	}

}
