package application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveTestController {

    private static String alive = "I'm alive, also a rest";

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    public ResponseEntity<Object> getAlive() {

        return new ResponseEntity<>(alive, HttpStatus.OK);

    }

}
