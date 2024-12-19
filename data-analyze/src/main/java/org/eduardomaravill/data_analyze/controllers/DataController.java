package org.eduardomaravill.data_analyze.controllers;

import org.eduardomaravill.data_analyze.dtos.RequestLink;
import org.eduardomaravill.data_analyze.dtos.ResponseLink;
import org.eduardomaravill.data_analyze.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/download")
public class DataController {

    private final IDataService dataService;

    @Autowired
    public DataController(IDataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/data-links")
    public ResponseEntity<List<ResponseLink>> getDataLinks(@RequestBody RequestLink requestLink){
       return ResponseEntity.ok(dataService.getDataLinks(requestLink));
    }

    @GetMapping("/data-files")
    public ResponseEntity<Void> downloadDataFiles(){
        dataService.downloadDataFiles();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/generate-records")
    public ResponseEntity<Void> generateRecords(){
        dataService.generateRecords();
        return ResponseEntity.ok().build();
    }
}
