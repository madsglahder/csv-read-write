package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
public class GetOriginalController {

    private StorageService storageService;

    @Autowired
    public void FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping("/original")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute(
                "files",
                storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(
                                GetOriginalController.class,
                                "serveFile",
                                path.getFileName().toString()
                        ).build().toString()
                ).collect(Collectors.toList())
        );

        return "uploadForm";
    }

    @GetMapping("/original/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveOriginalFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageNotFound(StorageFileNotFoundException exc) {

        return ResponseEntity.notFound().build();

    }
}
