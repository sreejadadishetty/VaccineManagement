package com.epam.vaccinemanagementtool.restcontroller;
import com.epam.vaccinemanagementtool.servicelayer.VaccineCenters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/available-vaccines")
public class VaccineInfo {
    @Autowired
    VaccineCenters vaccineCenters;

    @GetMapping()
    public ResponseEntity<List> vaccineCentersInformation(@RequestParam("vaccineType") String vaccine) {
        ResponseEntity<List> responseEntity = null;
        if (vaccine.equalsIgnoreCase("covaxin")) {
            responseEntity = new ResponseEntity<List>(vaccineCenters.getCovaxin(), HttpStatus.OK);
        } else if (vaccine.equalsIgnoreCase("covishield")) {
            responseEntity = new ResponseEntity<List>(vaccineCenters.getCovishield(), HttpStatus.OK);
        }
        else {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }
}

